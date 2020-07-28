package member;

import org.springframework.beans.factory.annotation.Autowired;


public class ChangePasswordService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public void changepassword(String email,String oldp , String newp ) {
		Memberinfo member= memberDAO.selectByEmail(email);
		if(member==null) {
			throw new MemberNotFound();
		}
		
		member.changepassword(oldp, newp);
		
		memberDAO.update(member);
		
		
		
		
	}
	

}
