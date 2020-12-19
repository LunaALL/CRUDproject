package login;

import member.MemberDAO;
import member.Memberinfo;

public class AuthService {

	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public AuthInfo authenticate(String email, String password) {
		Memberinfo memberin = memberDAO.selectByEmail(email);

		if (memberin == null) {
			throw new WrongPasswordException();
		}
		if (!memberin.matchmemberpassword(password)) {
			throw new WrongPasswordException();
		}
		AuthInfo auth = new AuthInfo(memberin.getId(), memberin.getEmail(), memberin.getName());

		if (memberDAO.isAdmin(memberin.getEmail())) {
			auth.admin = 1;
		}

		return auth;

	}

}
