package air.dao.test;


import air.service.UserService;
import air.vo.User;

public class testLoginService {
	static UserService loginService = new UserService();
	
	public static void main(String[] args) {
//		testCheckUserExists();
		testCheckPassword();
	}
	
	static void testCheckUserExists() {
		User user = new User();
		user.setUserName("Jinan");
//		boolean isExists = loginService.checkUserExists(user);
//		System.out.println(isExists);
	}
	
	static void testCheckPassword() {
		User user = new User();
		user.setUserName("Jinshuo Zhang");
		user.setPassword("root");
		System.out.println(loginService.checkPwd(user));
	}
}
