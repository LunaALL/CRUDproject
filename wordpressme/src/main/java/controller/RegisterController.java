package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.DuplicateMemberEx;
import member.MemberRegiService;
import member.RegisterReq;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	private MemberRegiService memberRegiService;
	
	public void setMemberRegiService(MemberRegiService memberRegiService) {
		this.memberRegiService = memberRegiService;
	}
	
	@GetMapping("/step1")
	public String step1() {
		return "register/registep1";
	}
	
	@PostMapping("/step2")
	public String step2( @RequestParam(value="agree", defaultValue = "false") Boolean Val) {
	if(!Val) {
		return "register/registep1";
	}
	return "register/registep2";
	
	}
	
	@GetMapping("/step2")
	public String returnningstep2() {
		return "redirect:/register/registep2";
	}
	
	
	@PostMapping("/step3")
	public String step3(RegisterReq req){
		try {
			memberRegiService.regist(req);
			return "register/registep3";
		}catch(DuplicateMemberEx ex) {
			return "register/registep2";
		}
		
	}
	
}
