package member;

public class MemberAdminService {

	private MemberDAO memberDAO;

	public MemberAdminService(MemberDAO memberdao) {
		this.memberDAO = memberdao;
	}

	public boolean IsAdmin(String email) {
		return memberDAO.isAdmin(email);
	}

}
