package air.service;

import java.util.ArrayList;

import air.dao.DaoFactory;
import air.dao.UserDao;
import air.vo.User;

public class UserService {
	UserDao userDao = DaoFactory.getUserDaoInstance();
	
	private boolean checkUserExists(User user) {
		String userName = user.getUserName();
		return userDao.checkUserExists(userName);
		
	}
	
	public String getUserRole(User user){
		String result=userDao.getUserRole(user.getUserName());
		return result;
	}
	
	public boolean checkPwd(User user){
		String userName = user.getUserName();
		if(checkUserExists(user)) {
			String storedPassword = userDao.getPwd(userName);
			String inputPassword = user.getPassword();
			return storedPassword.equals(inputPassword);
		}
		return false;
	}
	
	public int getUserId(User user){
		return userDao.getUserId(user.getUserName());
	}
	
	public boolean createAccount(User user) {
		String userName = user.getUserName();
		String password = user.getPassword();
		if(checkUserExists(user)) {
			return false;
		}
		userDao.create(userName, password);
		return true;
	}
	
	public ArrayList<String> getAllUsers() {
		return userDao.getUserList();
	}

	public void removeUser(User user) {
		String userName = user.getUserName();
		userDao.delete(userName);
	}
	
	public void assignRole(User user) {
		String role = user.getRole();
		String username = user.getUserName();
		userDao.assignRole(username, role);
	}
	
}
