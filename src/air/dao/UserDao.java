package air.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface UserDao {
	public void create(String userName, String password);
	public String getPwd(String userName);
	public ArrayList<String> getUserList();
	public boolean delete(String userName);
	public boolean checkUserExists(String userName);
	public boolean assignRole(String username,String role);
	public String getUserRole(String userName);
	public int getUserId(String userName);

}
