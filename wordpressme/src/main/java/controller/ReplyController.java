package controller;

import java.time.LocalDateTime;

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
	public ModelAndView replyWrite(@ModelAttribute("replycommand") ReplyVO vo,
			@RequestParam(value = "bdId", required = true )int bdID, HttpSession session
			) {
		AuthInfo info = (AuthInfo) session.getAttribute("authinfo");
		ModelAndView mv = new ModelAndView();
		if (info == null) {
			mv.setViewName("member/loginform");
			return mv;
		}
		
		vo.setBoardnum(bdID);
		vo.setBdcDate(LocalDateTime.now());
		replyService.inputComment(vo);
		mv.setViewName("redirect:/edit/main");
		
		
		return mv;
	}
}
