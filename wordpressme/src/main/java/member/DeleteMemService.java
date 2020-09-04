package member;

public class DeleteMemService {
	
	private MemberDAO memberDAO;
	
	public void setMemberAO(MemberDAO memberdao) {
		memberDAO=memberdao;
	}
	
	public boolean equalPwd(String email, String pwd) {
		Memberinfo member= memberDAO.selectByEmail(email);
		if(member.matchmemberpassword(pwd)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean deleteService(String email, String pwd) {
		if(equalPwd(email,pwd)) {
			//memberDAO.deleteMem(email);
			return true;
		}
		
		return false;
		
	}
	

}
