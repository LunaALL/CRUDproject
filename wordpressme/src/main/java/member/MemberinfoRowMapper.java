package member;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberinfoRowMapper implements RowMapper<Memberinfo> {
	
	@Override
	public Memberinfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Memberinfo member = new Memberinfo(
				rs.getString("EMAIL"),
				rs.getString("PASSWORD"),
				rs.getString("NAME"),
				rs.getTimestamp("REGDATE").toLocalDateTime()
				);
		member.setId(rs.getLong("ID"));
		return member;
	}

}
