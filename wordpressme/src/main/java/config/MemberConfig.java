package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import login.AuthService;
import member.ChangePasswordService;
import member.MemberDAO;
import member.MemberRegiService;


@Configuration
public class MemberConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/webproject?serverTimezone=UTC&characterEncoding=utf8");
		ds.setUsername("webtask");
		ds.setPassword("blackcow84012");
		ds.setInitialSize(15);
		ds.setMaxActive(30);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}
	
	@Bean
	public MemberDAO memberDAO() {
		return new MemberDAO(dataSource());
	}
	
	
	@Bean
	public MemberRegiService memberRegiService() {
		return new MemberRegiService(memberDAO());
	}
	
	@Bean
	public AuthService authService() {
		AuthService authService = new AuthService();
		authService.setMemberDAO(memberDAO());
		return authService;
	}
	
	@Bean
	public ChangePasswordService changePasswordService() {
		ChangePasswordService ct= new ChangePasswordService();
		return ct;
		
	}

	
}
