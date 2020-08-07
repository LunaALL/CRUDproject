package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import edit.BoardDAO;
import edit.BoardDelupdateCommand;
import edit.BoardDelupdateService;
import edit.BoardWriteService;
import login.AuthService;
import member.ChangePasswordService;
import member.MemberDAO;
import member.MemberRegiService;


@Configuration
@EnableTransactionManagement
public class MemberConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/webproject?serverTimezone=Asia/Seoul&characterEncoding=utf8");
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
	public BoardDAO boardDAO() {
		return new BoardDAO(dataSource());
	}
	
	
	@Bean
	public MemberRegiService memberRegiService() {
		return new MemberRegiService(memberDAO());
	}
	@Bean
	public BoardWriteService BoardWriteService() {
		return new BoardWriteService(boardDAO());
	}
	@Bean
	public BoardDelupdateService BoardDelupdateService() {
		return new BoardDelupdateService(boardDAO());
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
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
		
	}
	

	
}
