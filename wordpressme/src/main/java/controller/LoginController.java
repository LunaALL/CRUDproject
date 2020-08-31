package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
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
	public String login(LoginCommand loginCommand, @CookieValue(value="REMEMBER", required = false) Cookie rCookie) {
		if(rCookie!=null) {
			loginCommand.setEmail(rCookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		
		return "member/loginform";
	}
	
	@PostMapping("/login")
	public String submit(@ModelAttribute LoginCommand loginCommand, Errors errors,
			HttpSession httpSession, HttpServletResponse response) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if(errors.hasErrors()) {
			return "member/loginform";
		}
		try {
			AuthInfo authinfo= authService.authenticate(loginCommand.getEmail(), 
					loginCommand.getPassword());
			
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
			rememberCookie.setPath("/");
			if(loginCommand.isRememberEmail() ) {
				rememberCookie.setMaxAge(60*60*24*30);
			}else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			if(authinfo.getAdmin()==1) {
				httpSession.setAttribute("Admin", authinfo);
			}
			
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
