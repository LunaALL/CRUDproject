package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edit.ReplyVO;

@Controller
public class replyController {

	@PostMapping("/reply")
	public String replyWrite(ReplyVO vo) {
		
		return "redirect:/edit/main";
	}
}
