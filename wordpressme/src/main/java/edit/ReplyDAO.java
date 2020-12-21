package edit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

//댓글 관련 DAO 클래스
public class ReplyDAO {

	private JdbcTemplate jdbcTemplate;

	private ReplyRowMapper row = new ReplyRowMapper();

	public ReplyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 댓글 목록 메서드. JDBC 호출. bdID 게시글 넘버에 종속됨.
	public List<ReplyVO> AllGetList(int boardnum) {
		List<ReplyVO> results = jdbcTemplate.query("SELECT * FROM bdcomments where boardnum=?", row, boardnum);
		return results;

	}

	// 댓글 입력 메서드. JDBC 입력.
	public void InputComment(ReplyVO vo) {
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pst = con.prepareStatement(
						"INSERT INTO bdcomments(boardnum,commentnum,content,writer,bdcDate)" + "values(?, ?, ?, ?, ?)");
				pst.setInt(1, vo.getBoardnum());
				pst.setInt(2, vo.getCommentnum());
				pst.setString(3, vo.getContent());
				pst.setString(4, vo.getWriter());
				pst.setTimestamp(5, Timestamp.valueOf(vo.getBdcDate()));
				return pst;
			}
		});
	}

	// 다음 댓글 번호를 가져오는 메서드. 인자는 게시글 번호. 1더해서 리턴
	public int getCommentnum(int bdId) {
		int result = 0;
		try {
			result = jdbcTemplate.queryForObject(
					"select commentnum from bdcomments where boardnum = ? order by commentnum  desc limit 1",
					Integer.class, bdId);
		} catch (EmptyResultDataAccessException e) {
			result = 0;
		}

		return result + 1;

	}

	// 해당 댓글을 삭제하는 메서드 인자는 댓글 번호와 종속된 게시글 번호
	public int delReply(int commentnum, int bdId, String writer) {
		jdbcTemplate.update("delete from bdcomments where commentnum=? AND boardnum=? AND writer=?;", commentnum, bdId,
				writer);
		return 1;
	}

}
