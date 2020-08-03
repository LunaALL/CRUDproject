package edit;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoardRowMapper implements RowMapper<Board> {
	
	@Override
	public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Board board= new Board(
				rs.getInt("bdID"),
				rs.getString("bdTitle"), 
				rs.getString("userID"),
				rs.getTimestamp("bdDate").toLocalDateTime() , 
				rs.getString("bdContent") );
		
		
		return board;
	}
}
