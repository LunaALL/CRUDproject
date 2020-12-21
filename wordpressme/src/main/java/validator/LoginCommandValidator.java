package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import login.LoginCommand;

public class LoginCommandValidator implements Validator {

	private Pattern pattern;

	private static final String emailrequestExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public LoginCommandValidator() {
		// TODO Auto-generated constructor stub
		pattern = Pattern.compile(emailrequestExp);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return LoginCommand.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		// 이메일 검증
		LoginCommand login = (LoginCommand) target;
		Matcher match = pattern.matcher(login.getEmail());
		if (!match.matches()) {
			errors.rejectValue("email", "bad");
		}

	}

}
