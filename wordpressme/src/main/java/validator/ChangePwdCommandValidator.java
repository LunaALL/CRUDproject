package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import member.ChangePwdCommand;

public class ChangePwdCommandValidator implements Validator {
	
	private static final String pwreqestExp="^[A-Za-z[0-9]]{10,20}$"; 
	Pattern pattern= Pattern.compile(pwreqestExp);

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ChangePwdCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ChangePwdCommand cmd= (ChangePwdCommand) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oldpassword","required");
		ValidationUtils.rejectIfEmpty(errors, "newpassword", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmpassword", "required");
		Matcher match = pattern.matcher(cmd.getNewpassword() );
		
		if(!match.matches()) {
			errors.rejectValue("newpassword", "bad");
		}
		if(!cmd.isPasswordEqualToConfirmPassword()) {
			errors.rejectValue("confirmpassword","nomatch" );
		}
	}

}
