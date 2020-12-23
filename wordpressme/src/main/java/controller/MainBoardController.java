package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edit.Board;
import edit.BoardDAO;
import edit.BoardDelupdateCommand;
import edit.BoardDelupdateService;
import edit.ReplyService;
import edit.ReplyVO;
import edit.pageing.Criteria;
import edit.pageing.PageMaker;
import login.AuthInfo;
import member.MemberAdminService;
import member.MemberDAO;

@Controller
public class MainBoardController {

	private BoardDAO boardDAO;
	private MemberDAO memberDAO;
	private BoardDelupdateService boardDelupdateService;
	private ReplyService replyService;

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void setBoardDelupdateService(BoardDelupdateService boardDelupdateService) {
		this.boardDelupdateService = boardDelupdateService;
	}

	// @GetMapping("/board/boardList")
	@GetMapping("/edit/main")
	public ModelAndView BoardMain(@RequestParam(value = "page", required = true, defaultValue = "1") int page) {

		ModelAndView mav = new ModelAndView("/edit/boardmain");
		// 게시판 페이징
		Criteria cri = new Criteria();
		cri.setPage(page);
		PageMaker pagemaker = new PageMaker();
		// 전체 게시글 요청.
		List<Board> bd = boardDAO.getDivPage(cri);

		for (Board board : bd) {
			String head = board.getBdTitle();
			String body = board.getBdContent();
			head = filterStr(head);
			body = filterStr(body);
			board.setBdTitle(head);
			board.setBdContent(body);
		}

		pagemaker.setCri(cri);
		pagemaker.setTotalCount(boardDAO.getTotalCountpage());

		mav.addObject("boards", bd);
		mav.addObject("pageMaker", pagemaker);
		mav.addObject("allmemcount", boardDAO.getAllMemberCount());
		mav.addObject("allpage", boardDAO.getTotalCountpage());

		return mav;

	}

	/*
	 * @GetMapping("/edit/main") public String mainBoard(
	 * 
	 * @RequestParam(value="pagenum", required =false, defaultValue = "1") int
	 * pagenum, Model model,HttpSession session) { AuthInfo
	 * info=(AuthInfo)session.getAttribute("authinfo"); if(info==null) { return
	 * "member/loginform"; }
	 * 
	 * List<Board> result =boardDAO.getpage(pagenum); for(Board board : result) {
	 * String head=board.getBdTitle(); String body=board.getBdContent();
	 * head=filterStr(head); body=filterStr(body); board.setBdTitle(head);
	 * board.setBdContent(body); }
	 * 
	 * 
	 * model.addAttribute("boards", result);
	 * 
	 * return "edit/noticeboardmain"; }
	 */

	@GetMapping("/edit/editview")
	public ModelAndView clickBoard(@RequestParam(value = "bdID", required = false) int page, Model model,
			HttpSession session) {
		// 게시글 상세보기 처리 메서드.
		AuthInfo info = (AuthInfo) session.getAttribute("authinfo");
		if (info == null) {
			// 로그인 없이 들어오지 말자.
			ModelAndView mv = new ModelAndView("/member/loginform");
			return mv;
		}
		ModelAndView mv = new ModelAndView("/edit/BoardView");
		Board board = boardDAO.getselectpage(page);
		String head = board.getBdTitle();
		String body = board.getBdContent();
		// SSL 방지
		head = filterStr(head);
		body = filterStr(body);
		// 줄 띄움, 띄어쓰기
		body.replace("\r\n", "<br/>");

		board.setBdTitle(head);
		board.setBdContent(body);
		// 페이지 번호를 이용하여, 댓글목록 생성
		List<ReplyVO> results = replyService.GetReply(page);
		mv.addObject("board", board);
		mv.addObject("replylist", results);
		return mv;

	}

	// 해당 게시글 내용 요청 하여 수정하기 전 내용을 요청.
	@GetMapping("/edit/update")
	public String GetUpdate(@RequestParam(value = "bdID", required = false) int page, Model model,
			HttpSession session) {

		AuthInfo info = (AuthInfo) session.getAttribute("authinfo");
		if (info == null) {
			return "member/loginform";
		}

		Board board = boardDAO.getselectpage(page);
		if (!info.getName().equals(board.getUserID())) {
			return "edit/errorpage";
		}
		model.addAttribute("board", board);
		return "edit/update";

	}

	// 게시판 수정 요청 포스트 매핑. BoardDelupdateCommand VO클래스
	@PostMapping("/edit/updateboard")
	public String PostUpdate(@ModelAttribute("updatecommand") BoardDelupdateCommand board,
			@RequestParam(value = "bdID", required = false) int bdID, HttpSession session) {
		board.setBdID(bdID);
		String head = board.getBdTitle();
		String body = board.getBdContent();
		// XSS 공격 방지
		head = filterStr(head);
		body = filterStr(body);
		board.setBdTitle(head);
		board.setBdContent(body);

		boardDelupdateService.UpdateCommit(board);
		return "redirect:/edit/main";

	}

	// 게시글 삭제용 메서드
	@GetMapping("/edit/delete")
	public String PostDelete(@RequestParam(value = "bdID", required = false) int bdID,
			@RequestParam(value = "name", required = false) String name, HttpSession session) {

		AuthInfo info = (AuthInfo) session.getAttribute("authinfo");

		if (info == null) {
			return "member/loginform";
		}

		if (memberDAO.isAdmin(info.getEmail())) {
			boardDelupdateService.DeleteCommit(bdID);
			return "redirect:/edit/main";
		}

		if (!info.getName().equals(name)) {
			return "edit/errorpage";
		}

		boardDelupdateService.DeleteCommit(bdID);
		return "redirect:/edit/main";

	}

	public String filterStr(String str) {
		if (str.indexOf("<script>") != -1) {
			str = str.replaceAll("<script>", "");
		}
		if (str.indexOf("</script>") != -1) {
			str = str.replaceAll("</script>", "");
		}
		if (str.indexOf("<javascript>") != -1) {
			str = str.replaceAll("<javascript>", "");
		}
		if (str.indexOf("</javascript>") != -1) {
			str = str.replaceAll("</javascript>", "");
		}
		if (str.indexOf("<vbscript>") != -1) {
			str = str.replaceAll("<vbscript>", "");
		}
		if (str.indexOf("</vbscript>") != -1) {
			str = str.replaceAll("</vbscript>", "");
		}
		return str;
	}

}
