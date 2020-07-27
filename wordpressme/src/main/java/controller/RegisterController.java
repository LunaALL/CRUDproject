package controller;



import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.DuplicateMemberEx;
import member.MemberRegiService;
import member.RegisterReq;
import validator.RegisterVaildator;

@Controller
public class RegisterController {
	
	private MemberRegiService memberRegiService;
	
	public void setMemberRegiService(MemberRegiService memberRegiService) 
	{
		this.memberRegiService = memberRegiService;
	}
	
	
	@GetMapping("register/registep1")
	public String step1() 
	{
		return "register/registep1";
	}
	
	
	@PostMapping("register/registep2")
	public String step2( @RequestParam(value="agree", defaultValue = "false") Boolean Val) {
	if(!Val) 
	{
		return "register/registep1";
	}
	return "register/registep2";
	
	}
	
	
	@GetMapping("register/registep2")
	public String returnningstep2() 
	{
		return "redirect:/register/registep1";
	}
	
	
	
	@PostMapping("register/registep3")
	public String step3(@ModelAttribute("memberRegiService") RegisterReq req, Errors errors)
	{
		new RegisterVaildator().validate(req, errors);
		if(errors.hasErrors()) {
			return "register/registep2"; 
			//모든 종류의 에러가 발생하면 위에서 해당하는 이메일 중복 에러가 아닐때 리 다이렉트 step2 
			//email 검증하는 단계는 서비스단계에서 진행하므로 catch로 에러 해결 
		}
			
		
		try{
			memberRegiService.regist(req);
			return "register/registep3";
			}
		    catch(DuplicateMemberEx ex) 
			{
			errors.rejectValue("email", "duplicate");
			return "register/registep2";
			}
		
		
	}
	
	
	@GetMapping("register/registep3")
	public String returnningstep3() 
	{
		return "redirect:/register/registep1";
	}
	
	
}
