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


public class ReplyDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	private ReplyRowMapper row = new ReplyRowMapper();
	
	public ReplyDAO (DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<ReplyVO> AllGetList(int boardnum){
		List<ReplyVO> results= jdbcTemplate.query("SELECT * FROM bdcomments where boardnum=?"
				, row, boardnum);
		return results;
		
		
	}
	
	

}
