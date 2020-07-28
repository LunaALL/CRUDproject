package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import login.AuthInfo;
import login.AuthService;
import login.LoginCommand;
import login.WrongPasswordException;
import validator.LoginCommandValidator;

@Controller
public class LoginController {
	
	private AuthService authService;
	
	public void setAuthService(AuthService authService) {
		this.authService=authService;
	}
	
	@GetMapping("/login")
	public String login(LoginCommand loginCommand) {
		return "member/loginform";
	}
	
	@PostMapping("/login")
	public String submit(@ModelAttribute LoginCommand loginCommand, Errors errors,HttpSession httpSession) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if(errors.hasErrors()) {
			return "member/loginform";
		}
		try {
			AuthInfo authinfo= authService.authenticate(loginCommand.getEmail(), 
					loginCommand.getPassword());
			
			httpSession.setAttribute("authinfo", authinfo);
			return "member/main";
		}catch(WrongPasswordException e) {
			errors.rejectValue("password", "errorpassword");
			return "member/loginform";
		}
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "member/logout";
	}
	
	
	

}
