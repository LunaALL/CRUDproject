package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import login.AuthInfo;
import member.DeleteMemService;
import member.MemberDAO;

@Controller
@RequestMapping("/deletemem")
public class DeleteMemController {
	
	private DeleteMemService deleteMemService;
	
	public void setDeleteMemService(DeleteMemService deleteMemService) {
		this.deleteMemService = deleteMemService;
	}

	@GetMapping
	public String delmem(HttpSession session) {
		AuthInfo auth = (AuthInfo)session.getAttribute("authinfo");
		if(auth==null) {
			return "member/loginform";
		}
		
		
		return "member/Deleteform";
	}
	
	@PostMapping
	public String delmempost(String repwd, HttpSession session) {
		AuthInfo auth = (AuthInfo)session.getAttribute("authinfo");
		if(auth==null) {
			return "member/loginform";
		}
		
		
		if(deleteMemService.deleteService(auth.getEmail(), repwd) ) {
			return "member/deletebye";
		}else {
			return "member/deleteform";
		}
		
		
		
		
	}

}
