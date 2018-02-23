package air.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao{
	PreparedStatement pstmt;
	String sql;
	ResultSet rs;
	DBConnect dbConnect;
	Connection conn;
	
	@Override
	public void create(String userName, String password) {
		sql = "INSERT INTO user (`userName`, `password`,`userRole`) VALUES (?, ?, ?)";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			pstmt.setString(3,"Student");
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
	public String getPwd(String userName) {
		System.out.println("testline db connect");
		sql = "Select password From user Where userName = ?";
		
		String password = null;
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				password = rs.getString(1);
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
		
		
		return password;
	}

	@Override
	public ArrayList<String> getUserList() {
		sql = "Select userName From user";
		ArrayList<String> userList = new ArrayList<String>();
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String name=rs.getString("userName");
				userList.add(name);
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
		return userList;
	}

	@Override
	public boolean delete(String userName) {
		sql = "DELETE FROM user WHERE userName=?";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		int rowDeleted = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rowDeleted = pstmt.executeUpdate();
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
	public boolean checkUserExists(String userName) {
		Boolean isExist;
		sql = "SELECT * FROM user WHERE userName=?";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		int rowDeleted = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
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
	
	/**
	 * @author Danmei Ye
	 * @param userId
	 * @param role
	 * @return boolean
	 */
	
	public boolean assignRole(String username,String role){
		boolean flag=false;
		sql = "UPDATE user SET userRole=? WHERE userName=?";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, role);
			pstmt.setString(2, username);
			rs = pstmt.executeQuery();
			flag=true;
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
		return flag;
	}
	
	public String getUserRole(String userName){
		String role=null;
		sql = "SELECT userRole FROM user WHERE userName=?";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				role=rs.getString("userRole");
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
		
		return role;
	}
	
	public int getUserId(String userName){
		int id=0;
		sql = "SELECT userID FROM user WHERE userName=?";
		dbConnect = new DBConnect();
		conn = dbConnect.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				id=rs.getInt("userId");
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
		
		return id;
	}
	
}
