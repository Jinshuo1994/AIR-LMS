package air.dao.test;

import air.dao.UserDao;
import air.dao.UserDaoFactory;

public class UserDaoFactoryTest {
	
	public static void main(String[] args) {
		testUserDaoFactory();
	}
	
	static void testUserDaoFactory() {
		UserDaoFactory userDaoFactory = UserDaoFactory.getUserDaoFactory();
		UserDao userDao = userDaoFactory.getUserDao();
		System.out.println(userDao);
	}
}
