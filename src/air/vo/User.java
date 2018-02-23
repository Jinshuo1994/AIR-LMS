package air.vo;

public class User {
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	int user_id;
	String userName;
	String password;
	String Role;
	
	public User() {
		
	}
	
}
