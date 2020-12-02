package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edit.BoardWriteCommand;
import edit.BoardWriteService;
import login.AuthInfo;
import validator.WriteBoardValidator;

@Controller
@RequestMapping("/write")
public class WriteBoardController {

	private BoardWriteService boardWriteService;

	public void setBoardWriteService(BoardWriteService boardWriteService) {
		this.boardWriteService = boardWriteService;
	}

	@GetMapping()
	public String writeboard(HttpSession session) {
		//게시판 목록 메인. 
		AuthInfo info = (AuthInfo) session.getAttribute("authinfo");
		if (info == null) {
			return "member/loginform";
		}
		return "edit/boardedit";
	}

	@PostMapping()
	public String postwriteboard(@ModelAttribute("writecommand") BoardWriteCommand board, HttpSession session,
			Errors errors) {
		//게시글 작성 처리 메서드. 
		AuthInfo info = (AuthInfo) session.getAttribute("authinfo");
		new WriteBoardValidator().validate(board, errors);

		if (errors.hasErrors()) {
			return "edit/boardedit";
		}
		board.setUserID(info.getName());

		String head = board.getBdTitle();
		String body = board.getBdContent();
		head = filterStr(head);
		body = filterStr(body);

		board.setBdTitle(head);
		board.setBdContent(body);

		boardWriteService.commit(board);

		return "redirect:/edit/main";
	}

	public String filterStr(String str) {
		//크로스 사이트 스크립팅 공격 방지. 
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
