package edit;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ReplyRowMapper implements RowMapper<ReplyVO>{
	@Override
	public ReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ReplyVO rv = new ReplyVO(
				rs.getInt("boardnum"),
				rs.getInt("commentnum"),
				rs.getString("content"),
				rs.getString("writer"),
				rs.getTimestamp("bdcDate").toLocalDateTime() 
				);
		
		
		return rv;
	}

}
