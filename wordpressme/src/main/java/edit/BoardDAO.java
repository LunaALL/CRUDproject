package edit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class BoardDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public BoardDAO(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	public void insert(Board board) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pst = con.prepareStatement("INSERT INTO bbs(bdTitle,userId,bdDate,bdContent)"+
				"values(?,?,?,?)",new String[] {"bdId"} );
				pst.setString(1, board.getBdTitle());
				pst.setString(2, board.getUserID());
				pst.setTimestamp(3, Timestamp.valueOf(board.getBdDate()));
				pst.setString(4, board.getBdContent());
				return pst;
			}
		}, keyHolder);
		Number keyValue= keyHolder.getKey();
		board.setBdID(keyValue.longValue());
		
	}

}
