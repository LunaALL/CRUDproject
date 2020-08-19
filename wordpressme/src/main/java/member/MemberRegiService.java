package member;

import java.time.LocalDateTime;

public class MemberRegiService {
	private MemberDAO memberDAO;
	
	public MemberRegiService (MemberDAO memberDAO) {
		this.memberDAO=memberDAO;
	}
	
	public long regist(RegisterReq req) {
		Memberinfo member =memberDAO.selectByEmail(req.getEmail());
		if(member!=null) {
			throw new DuplicateMemberEx("중복된 이메일입니다. 다른 이메일을 등록해주세요");
		}
		Memberinfo mem =memberDAO.selectByName(req.getName());
		if(mem!=null) {
			throw new DuplicateMemberEx("중복된 닉네임입니다. 다른 닉네임을 사용해주세요.");
		}
		
		
		Memberinfo newinfo= new Memberinfo(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDAO.insert(newinfo);
		return newinfo.getId();
	}

}
