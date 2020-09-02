package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDAO{

	private JdbcTemplate jdbcTemplate;
	
	public MemberDAO(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}

	
	public Memberinfo selectByEmail(String email) {
		List<Memberinfo> results = jdbcTemplate.query(
				new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						// TODO Auto-generated method stub
						PreparedStatement pst = con.prepareStatement("select * from member where EMAIL = ?");
						pst.setString(1, email);
						return pst;
					}
				}, new MemberinfoRowMapper() );	
				
		return results.isEmpty() ? null : results.get(0);
	}
	
	public Memberinfo selectByName(String name) {
		List<Memberinfo> results = jdbcTemplate.query("select * from member where NAME =? ", new MemberinfoRowMapper(), name);
		
		return results.isEmpty() ? null : results.get(0);
		
	}
	
	public void insert(Memberinfo member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pstt = con.prepareStatement("insert into member(EMAIL, PASSWORD, NAME, REGDATE)" + 
				"values(?,?,?,?)", new String[] {"ID"} );
				pstt.setString(1, member.getEmail());
				pstt.setString(2, member.getPassword());
				pstt.setString(3, member.getName());
				pstt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDataTime()));
				return pstt;
			}
		},keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue() );
	
		
	}  
	public void update(Memberinfo member) 
	{
		jdbcTemplate.update("update member set NAME = ?, PASSWORD= ? where EMAIL=?", member.getName(), member.getPassword(), member.getEmail() );	
	}
	public Collection<Memberinfo> selectAll() 
	{
		List<Memberinfo> results = jdbcTemplate.query("select * from member", new MemberinfoRowMapper() );
	return results;
	}
	
	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from member",Integer.class);
		return count;
	}
	
	
	public boolean isAdmin(String email) {
		List<Memberinfo> results= jdbcTemplate.query("select * from member where admin=1 && EMAIL=?",new MemberinfoRowMapper(), email);
		if(results.isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	
	public boolean deleteMem(String email) {
		jdbcTemplate.update("delete from member where email=?",email);
		return true;
	}
	
	

	
	

}
