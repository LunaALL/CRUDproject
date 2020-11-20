package edit;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;



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
	
	public void InputComment(ReplyVO vo) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pst = con.prepareStatement(
						"INSERT INTO bdcomments(boardnum,commentnum,content,writer,bdcDate)"+"values(?, ?, ?, ?, ?)");
				pst.setInt(1, vo.getBoardnum());
				pst.setInt(2, vo.getCommentnum());
				pst.setString(3, vo.getContent());
				pst.setString(4, vo.getWriter());
				pst.setTimestamp(5, Timestamp.valueOf(vo.getBdcDate()));
				return pst;
			}
		});
    }
	
	

}
