package air.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDaoFactory {
	
	private static UserDao userDao = null;
	private static UserDaoFactory userDaoFactory = new UserDaoFactory();

	private UserDaoFactory() {
		Properties properties = new Properties();
		InputStream inputStream = UserDaoFactory.class.getClassLoader().getResourceAsStream("air/config/daoConfig.properties");
		try {
			properties.load(inputStream);
			String userDaoImpl = properties.getProperty("userDaoImpl");
			userDao = (UserDao) Class.forName(userDaoImpl).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static UserDaoFactory getUserDaoFactory() {
		return userDaoFactory;
	}

	public UserDao getUserDao() {
		return userDao;
	}
}
