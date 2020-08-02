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
	
	private 
	BoardRowMapper row = new BoardRowMapper();
	public BoardDAO(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	public void insert(Board board) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pst = con.prepareStatement("INSERT INTO bbs(bdTitle,userId,bdDate,bdContent,bdIsdelete)"+
				"values(?,?,?,?,?)",new String[] {"bdId"} );
				pst.setString(1, board.getBdTitle());
				pst.setString(2, board.getUserID());
				pst.setTimestamp(3, Timestamp.valueOf(board.getBdDate()));
				pst.setString(4, board.getBdContent());
				pst.setInt(5, 1);
				return pst;
			}
		}, keyHolder);
		Number keyValue= keyHolder.getKey();
		board.setBdID(keyValue.longValue());
	}
	
	public void updateboard(Board board) {
		
	}
	
	public void deleteBoard(Board board) {
		
	}
	
	public boolean nextPage() {
		List<Integer> results = jdbcTemplate.query("select count(*) from member", rowMapper)	
		
		
	}
	
	
	public List<Board> selectpage(int pageNumber){
		
		List<Board> results = jdbcTemplate.query("select * from bbs where bdID < ? and bdIsdelete=1 order by bdID desc limit 10",
			row, );
		
		return results.isEmpty() ? null : results;
   }
	

	

	
	
}
