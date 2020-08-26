package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edit.BoardWriteCommand;

public class WriteBoardValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return BoardWriteCommand.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		BoardWriteCommand cmd = (BoardWriteCommand)target;
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bdTitle", "required");
		ValidationUtils.rejectIfEmpty(errors,"bdContent" , "required");
			//서버사이드 스크립트 공격 방지용 구문
		
		
		
		
	}
	
	

}
