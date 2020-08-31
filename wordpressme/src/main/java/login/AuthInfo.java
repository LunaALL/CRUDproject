package login;

public class AuthInfo {
	private Long id;
	private String email;
	private String name;
	int admin=0;
	
	public int getAdmin() {
		return admin;
	}


	public void setAdmin(int admin) {
		this.admin = admin;
	}


	public AuthInfo(Long id, String email, String name) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
	}
	
	
	public Long getId() {
		return id;
	}


	public String getEmail() {
		return email;
	}


	public String getName() {
		return name;
	}
	
	


	
	
	
	

}
