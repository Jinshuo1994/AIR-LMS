package air.dao.test;

import air.dao.DaoFactory;
import air.dao.UserDao;

public class DaoFactoryTest {
	public static void main(String[] args) {
		testDaoFactory();
	}
	
	static void testDaoFactory() {
		UserDao userDao = DaoFactory.getUserDaoInstance();
		System.out.println(userDao);
	}
}
