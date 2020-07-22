package member;

import java.util.Collection;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.JdbcConnection;

public class MemberDAO {
	private JdbcTemplate jdbcTemplate;
	
	public MemberDAO(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	public Memberinfo selectByEmail(String email) {
		List<Memberinfo> results = jdbcTemplate.query(
				"select * from member where EMAIL = ?",
				new MemberinfoRowMapper(),email);	
				
		return results.isEmpty() ? null : results.get(0);
	}
	public void insert(Memberinfo member) {
		
	}  
	public void update(Memberinfo member) {
		
	}
	public Collection<Memberinfo> selectAll() {
	return null;
	}
	
	

}
