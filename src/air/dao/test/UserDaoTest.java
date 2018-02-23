package air.dao.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import air.dao.UserDaoImpl;

public class UserDaoTest {
	
	public static void main(String[] args) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		//testGetPwd();
//		testGetUserList();
//		testDelete();
//		testCreate();
		testCheckUserExists();
	}
	
	static void testGetPwd() {
		String password = new UserDaoImpl().getPwd("Jinan");
		System.out.println(password);
	}
	
	static void testGetUserList() {
	/*	ArrayList<ArrayList> userList = new UserDaoImpl().getUserList();
			for(ArrayList userInfo : userList) {
				System.out.println(userInfo.get(0)+" "+userInfo.get(1)+" "+userInfo.get(2));
			}*/
	}
	
	static void testDelete() {
		UserDaoImpl userImpl = new UserDaoImpl();
		System.out.println(userImpl.delete("Jinan"));
	}
	
	static void testCreate() {
		UserDaoImpl userImpl = new UserDaoImpl();
		userImpl.create("mingming", "123");
	}
	
	static void testCheckUserExists() {
		UserDaoImpl userImpl = new UserDaoImpl();
		System.out.println(userImpl.checkUserExists("Jinan"));
	}
}
