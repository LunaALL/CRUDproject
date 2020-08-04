package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edit.BoardWriteCommand;
import edit.BoardWriteService;
import login.AuthInfo;

@Controller
@RequestMapping("/write")
public class WriteBoardController {
	
	private BoardWriteService boardWriteService;
	
	public void setBoardWriteService(BoardWriteService boardWriteService) {
		this.boardWriteService = boardWriteService;
	}

	@GetMapping()
	public String writeboard(HttpSession session) {
	AuthInfo info=(AuthInfo)session.getAttribute("authinfo");
	if(info==null) {
		return "member/loginform";
	}
		return "edit/noticeboard";
	}
	
	@PostMapping()
	public String postwriteboard(@ModelAttribute("writecommand") BoardWriteCommand board
		,HttpSession session) {
	AuthInfo info=(AuthInfo)session.getAttribute("authinfo");
	if(info!=null) {
		board.setUserID(info.getName());
		boardWriteService.commit(board);
	}
		return "redirect:/edit/main";
	}
	

}
