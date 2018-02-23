package air.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class CourseDaoImpl extends DBConnect implements CourseDao{
	PreparedStatement pstmt;
	String sql;
	ResultSet rs;
	DBConnect dbConnect;
	Connection conn;
	@Override
	public void create(int courseId, String courseName, String courseLoc) {
		
		sql = "INSERT INTO course (`courseId`, `courseName`,`courseLoc`) VALUES (?, ?, ?)";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseId);
			pstmt.setString(2, courseName);
			pstmt.setString(2, courseLoc);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			dbConnect.close();
		}
		
	}
	@Override
	public ArrayList<ArrayList> getCourseList() {
		
		sql = "Select * From course";
		ArrayList<ArrayList> courseList = new ArrayList<ArrayList>();
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ArrayList courseInfo = new ArrayList();
				courseInfo.add(rs.getInt(1));
				courseInfo.add(rs.getString(2));
				courseInfo.add(rs.getString(3));
				courseList.add(courseInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			dbConnect.close();
		}
		return courseList;
		

	}
	@Override
	public boolean delete(int courseID) {
		
		sql = "DELETE FROM course WHERE courseId=?";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		int rowDeleted = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseID);
			rowDeleted = 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			dbConnect.close();
		}
		
		if(rowDeleted == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	@Override
	public boolean checkCourseExits(int courseID) {
		Boolean isExist;
		sql = "SELECT * FROM course WHERE courseId=?";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				isExist = true;
			} else {
				isExist = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			dbConnect.close();
		}
		
		if(isExist) {
			return true;
		} else {
			return false;
		}
	}
	


	
	
}
