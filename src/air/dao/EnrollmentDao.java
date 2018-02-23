package air.dao;

/**
 * @author: Danmei Ye
 */

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import air.dao.DBConnect;
import air.vo.Course;
import air.vo.Enrollment;
import air.vo.User;


public class EnrollmentDao {
	DBConnect dbc;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public EnrollmentDao(){
		dbc=new DBConnect();
	}
	
	public boolean addUserToCourse(String coursename, String username) throws Exception{
		String sql= "insert into enrollment(courseName,userName) values(?,?)";
		Boolean result=false;
		
		try{
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1,coursename);
			pstmt.setString(2, username);
			pstmt.execute();
			result=true;
		}catch (Exception e) {
			System.err.println("EnrollmentDao.addUsertoCourse ERROR ## "+e.getMessage());
		}	
		finally{
			destroy();
		}
		
		return result;
	}
	
	
	public boolean removeUser(String username,String coursename)throws Exception{
		String sql="delete from enrollment where courseName=? AND userName=?";
		boolean result=false;
		
		try{
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, coursename);
			pstmt.setString(2, username);
			pstmt.execute();
			result=true;
		}catch (Exception e) {
			System.err.println("EnrollmentDao.removeUser ERROR ## "+e.getMessage());
		}	
		finally{
			destroy();
		}
		return result;
	}	
	
	/*private String getCourseName(int courseId)throws Exception{
		String result=null;
		String sql="select courseName from course where courseId=? LIMIT 1";
		try{
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, courseId);
			pstmt.execute();
			while(rs.next()){
				result=rs.getString("courseName");
			}
		}catch (Exception e) {
			System.err.println("EnrollmentDao.getCourseName ERROR ## "+e.getMessage());
		}	
		finally{
			destroy();
		}
		return result;
		
	}*/
	
	public ArrayList<String> getCoursebyUser(String username)throws Exception{
		ArrayList<String> courseList=new ArrayList<String>();
		String sql="select courseName from enrollment where userId=?";
		try{
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			rs=pstmt.executeQuery();
			while(rs.next()){
				courseList.add(rs.getString("courseName"));  
			}
		}catch (Exception e) {
			courseList=null;
			System.err.println("EnrollmentDao.getCoursebyUser ERROR ## "+e.getMessage());		
		}
		finally{
			destroy();
		}
		return courseList;
	}
	
	public ArrayList<String> getUserbyCourse(String coursename)throws Exception{
		ArrayList<String> userList=new ArrayList<String>();
		String sql="select userName from enrollment where courseName=?";
		try{
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1,coursename);
			rs=pstmt.executeQuery();
			while(rs.next()){
				userList.add(rs.getString("userName"));
			}
			}catch(Exception e){
				userList=null;
				System.err.println("EnrollmentDao.getUserbyCourse ERROR ## "+e.getMessage());
			}
			finally{
				destroy();
			}
		 return userList;
		}
	
	
	/*public String getUserName(int courseId)throws Exception{
		String result=null;
		String sql="select userName from user where userId=? LIMIT 1";
		try{	
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, courseId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				result=rs.getString("userName");
			}
		}catch(Exception e){
			System.err.println("EnrollmentDap.getUserName ERROR ##"+e.getMessage());
		}finally{
			destroy();
		}return result;
	}*/
	
	
	private void destroy(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(dbc!=null){
				dbc.close();
			}
		} catch (Exception e) {
			System.out.println("EnrollmentDAO.destroy ERROR ## "+e.getMessage());
		}
	}


}
