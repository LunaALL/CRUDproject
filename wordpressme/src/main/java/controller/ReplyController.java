package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edit.ReplyService;
import edit.ReplyVO;
import login.AuthInfo;

@Controller
public class ReplyController {

	ReplyService replyService;

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	@PostMapping("/replyedit")
	public ModelAndView replyWrite(HttpServletRequest request, @RequestParam(value = "bdID", required = true) int bdID,
			HttpSession session) {

		// 생성자없이 직접넣음. bdId는 주소 파라미터, content는 form, 시간
		ReplyVO vo = new ReplyVO();
		AuthInfo info = (AuthInfo) session.getAttribute("authinfo");
		ModelAndView mv = new ModelAndView();

		if (info == null) {
			mv.setViewName("member/loginform");
			return mv;
		}

		vo.setBoardnum(bdID);
		vo.setContent(request.getParameter("content"));
		vo.setBdcDate(LocalDateTime.now());
		vo.setWriter(info.getName());
		// 서비스 클래스에서 커멘트넘버를 DAO 조회해서 인풋.
		replyService.inputComment(vo);
		mv.setViewName("redirect:/edit/editview?bdID=" + bdID);

		return mv;
	}

	@PostMapping("/replydel")
	public ModelAndView replyDel(HttpServletRequest request,
			@RequestParam(value = "bdID", required = true) int bdID,
			@RequestParam(value = "commentnum", required = true) int commentnum,
			@RequestParam(value = "writer", required = true) String writer, HttpSession session) throws Exception {
		AuthInfo info = (AuthInfo) session.getAttribute("authinfo");
		ModelAndView mv = new ModelAndView();
		if (info == null) {
			mv.setViewName("member/loginform");
			return mv;
		}
		
		int result=replyService.delComment(commentnum, bdID, writer);
		
		mv.setViewName("redirect:/edit/editview?bdID=" + bdID);

		return mv;

	}

}
