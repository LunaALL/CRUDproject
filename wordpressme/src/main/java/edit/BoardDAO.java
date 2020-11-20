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
import edit.pageing.Criteria;

public class BoardDAO {

	private JdbcTemplate jdbcTemplate;

	private BoardRowMapper row = new BoardRowMapper();

	public BoardDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insert(Board board) {
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pst = con.prepareStatement(
						"INSERT INTO bbs(bdID,bdTitle,userId,bdDate,bdContent,bdIsdelete)" + "values(?,?,?,?,?,?)");
				pst.setInt(1, getNext());
				pst.setString(2, board.getBdTitle());
				pst.setString(3, board.getUserID());
				pst.setTimestamp(4, Timestamp.valueOf(board.getBdDate()));
				pst.setString(5, board.getBdContent());
				pst.setInt(6, 1);
				return pst;
			}
		});

	}

	public void updateboard(BoardDelupdateCommand board) {
		jdbcTemplate.update("update bbs set bdTitle=?, bdContent=? where bdID=?", board.getBdTitle(),
				board.getBdContent(), board.getBdID());
	}

	public void deleteBoard(int bdID) {
		jdbcTemplate.update("delete from bbs where bdID=?", bdID);
	}

	public List<Board> getpage(int pageNum) {
		List<Board> results = jdbcTemplate.query(
				"select * from bbs where bdID < ? and bdIsdelete=1 order by bdID desc limit 10", row,
				getNext() - (pageNum - 1) * 10);
		return results;
	}

	public boolean nextPage(int pageNum) {
		List<Board> results = jdbcTemplate.query(
				"select * from bbs where bdID < ? and bdIsdelete=1 order by bdID desc limit 10", row,
				getNext() - (pageNum - 1) * 10);
		Iterator<Board> it = results.iterator();
		if (it.hasNext()) {
			return true;
		}
		return false;

	}

	public int getNext() {
		int lastId = jdbcTemplate.queryForObject("select bdID from bbs order by bdID desc limit 1", Integer.class);
		return lastId + 1;
	}

	public Board getselectpage(int bdID) {
		List<Board> bd = jdbcTemplate.query("select * from bbs where bdID=?", row, bdID);
		return bd.get(0);
	}

	public int getTotalCountpage() {
		int num = jdbcTemplate.queryForObject("select count(*) from bbs", Integer.class);
		return num;
	}

	public List<Board> getDivPage(Criteria cri) {
		List<Board> bd = jdbcTemplate.query("select * from bbs order by bdID desc limit ? , ?", row, cri.getPageStart(),
				cri.getPerPageNum());

		return bd;

	}
	
	public int getAllMemberCount() {
		int num= jdbcTemplate.queryForObject("select count(*) from member",Integer.class);
		return num;
	}
	
	
	
	

}
