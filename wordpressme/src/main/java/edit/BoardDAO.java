package edit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.mysql.cj.protocol.Resultset;

import controller.WriteBoardController;

public class BoardDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	private BoardRowMapper row = new BoardRowMapper();
	
	public BoardDAO(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	public void insert(Board board) {
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pst = con.prepareStatement("INSERT INTO bbs(bdID,bdTitle,userId,bdDate,bdContent,bdIsdelete)"+
				"values(?,?,?,?,?,?)");
				pst.setInt(1, getNext());
				pst.setString(2, board.getBdTitle());
				pst.setString(3, board.getUserID());
				pst.setTimestamp(4, Timestamp.valueOf(board.getBdDate()));
				pst.setString(5, board.getBdContent());
				pst.setInt(6, 1);
				return pst;
			}
		} );
		
		
	}
	
	public void updateboard(Board board) {
		
	}
	
	public void deleteBoard(Board board) {
		
	}
	
	
	public List<Board> getpage(int pageNumber){
		
		List<Board> results = jdbcTemplate.query(
				"select * from bbs where bdID < ? and bdIsdelete=1 order by bdID desc limit 10",
			    row,  getNext() - (pageNumber - 1) * 10 );
		
		return results;
   }
	

	public int getNext() {
		String SQL = "select bdID from bbs order by bdID desc limit 1";
		int lastId = jdbcTemplate.queryForObject(
				"select * from bbs order by bdID desc limit 1",
				Integer.class);
		return lastId+1;
	}
	

	

	
	
}
