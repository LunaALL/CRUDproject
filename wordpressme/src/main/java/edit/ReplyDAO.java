package edit;



import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;



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
