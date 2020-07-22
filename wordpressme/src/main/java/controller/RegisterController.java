package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
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
	
}
