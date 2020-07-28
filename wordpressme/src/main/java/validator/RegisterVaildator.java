package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import member.RegisterReq;

public class RegisterVaildator implements Validator {
	
	private static final String emailrequestExp = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final String pwreqestExp="^[A-Za-z[0-9]]{10,20}$"; 
	


	private Pattern pattern;
	private Pattern pattern2;
	public RegisterVaildator () {
		pattern= Pattern.compile(emailrequestExp);
		pattern2= Pattern.compile(pwreqestExp);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		
	return RegisterReq.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		RegisterReq req = (RegisterReq) target;
		if(req.getEmail()==null || req.getEmail().trim().isEmpty() ) {
			errors.rejectValue("email", "required");
		} else {
			Matcher matcher = pattern.matcher(req.getEmail()); //요청 정보 즉, 회원가입 신청한 이메일을 패턴 검증. 
			if(!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmpassword", "required");
		if(!req.getPassword().isEmpty()) {
			if(!req.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmpassword", "nomatch");
				//비밀번호와 비밀번호 확인이 같을경우 true임. 다를경우 false
			}
		}
		
		if(!req.getPassword().isEmpty()) {
			Matcher pwmatcher = pattern2.matcher(req.getPassword());
			if(!pwmatcher.matches()) {
				errors.rejectValue("password", "bad");
			}
			
		}
	}

}
