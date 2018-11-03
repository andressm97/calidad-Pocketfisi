package proyecto.back.entity;

public class Usuario {
	
	private String id_user;
	private String name;
	private String lastname;
	private String username;
	private String password;
	private String mobile;
	private String id_profile;

	
	private boolean toQuery;
	
	
	
	public boolean getToQuery() {
		return toQuery;
	}
	public void setToQuery(boolean toQuery) {
		this.toQuery = toQuery;
	}
	
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getId_profile() {
		return id_profile;
	}
	public void setId_profile(String id_profile) {
		this.id_profile = id_profile;
	}
	
	
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return id_user+" "+name+" "+ lastname+" "+ " "+username+" "+password+" "+ mobile+" "+ id_profile;
	}
	
	
}
