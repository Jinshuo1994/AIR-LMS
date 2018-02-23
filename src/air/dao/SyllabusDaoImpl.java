package air.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SyllabusDaoImpl implements SyllabusDao{
	
	PreparedStatement pstmt;
	String sql;
	ResultSet rs;
	DBConnect dbConnect;
	Connection conn;
	
	
	
	@Override
	public void create(String syllabus, int courseID, String type, boolean published) {
		
		sql = "INSERT INTO syllabus (`Syllabus`,`courseID`,`type`,`published`) VALUES (?, ?, ?, ?)";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, syllabus);
			pstmt.setInt(2, courseID);
			pstmt.setString(3,type);
			pstmt.setBoolean(4, published);
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
	public String getSyllabusType(int courseID) {
		String type = "";
		sql = "Select type From Syllabys Where courseID = ?";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				type = rs.getString(1);
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
		
		return type;
	}

	@Override
	public String getSyllabusContent(int courseID) {
		String content = "";
		sql = "Select Syllabus From Syllabys Where courseID = ?";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				content = rs.getString(1);
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
		
		return content;
	}

	@Override
	public void delete(int courseID) {
		sql = "DELETE FROM `syllabus` WHERE `courseId`=?;";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseID);
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
	public void editSyllabus(int courseID, String content) {
		
		
		sql = "UPDATE `syllabus` SET `syllabus`=? WHERE `courseId`=?;";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setInt(2, courseID);
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
	public void editSyllabus(int courseID, boolean published) {
		
		
		sql = "UPDATE `syllabus` SET `published`=? WHERE `courseId`=?;";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setBoolean(1, published);
			pstmt.setInt(2, courseID);
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
	public boolean checkSyllabusExists(int courseID) {
		Boolean isExist;
		sql = "SELECT * FROM syllabus WHERE courseID=?";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		int rowDeleted = 0;
		
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
