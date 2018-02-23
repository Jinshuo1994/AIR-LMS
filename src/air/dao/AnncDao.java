package air.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnncDao {
	DBConnect dbc;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static void main() {
		
	}
	
	public ArrayList<String> getAnncList(String coursename)throws Exception{
		ArrayList<String> anncList=new ArrayList<String>();
		String sql="select anncTitle from annc where courseName=?";
		try{
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, coursename);
			rs=pstmt.executeQuery();
			while(rs.next()){
				anncList.add(rs.getString("anncTitle"));  
			}
		}catch (Exception e) {
			anncList=null;
			System.err.println("Annc.getAnncList ERROR ## "+e.getMessage());		
		}
		finally{
			destroy();
		}
		return anncList;
	}
	
	public boolean addAnnc(String anncTitle,String annc,String coursename ) throws Exception{
		String sql= "insert into annc(anncTitle,annc,courseName) values(?,?,?)";
		Boolean result=false;
		
		try{
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1,anncTitle);
			pstmt.setString(2, annc);
			pstmt.setString(3, coursename);
			pstmt.execute();
			result=true;
		}catch (Exception e) {
			System.err.println("Annc.add ERROR ## "+e.getMessage());
		}	
		finally{
			destroy();
		}
		
		return result;
	}
	
	public boolean deleteAnnc(String annc_title)throws Exception{
		String sql="delete from annc where annc_title=?";
		boolean result=false;
		try{
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, annc_title);
			pstmt.execute();
			result=true;
		}catch (Exception e) {
			System.err.println("Annc.delete ERROR ## "+e.getMessage());
		}	
		finally{
			destroy();
		}
		return result;
	}	
	
	public String getAnnc(String anncTitile){
		String annc=null;
		String sql="select annc from annc where anncTitle=?";
		try{
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, anncTitile);
			rs=pstmt.executeQuery();
			while(rs.next()){
				annc=rs.getString("annc");  
			}
		}catch (Exception e) {
			annc=null;
			System.err.println("Annc.getAnncList ERROR ## "+e.getMessage());		
		}
		finally{
			destroy();
		}
		return annc;
		
	}
	
	public Boolean editAnnc(String anncTitle,String annc){
		Boolean flag=false;
		String sql = "UPDATE annc SET annc=? WHERE anncTitle=?";
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1,annc);
			pstmt.setString(2, anncTitle);
			pstmt.execute();
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
	
		} finally{
			destroy();
		}
		
		return flag;
	}
	
	public Boolean isPublished(String anncTitle){ //anncTitle �����ظ�
		Boolean flag=false;
		String sql="select anncPublish from annc WHERE anncTitle=?";
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, anncTitle);
			rs=pstmt.executeQuery();
			while(rs.next()){
				if(rs.getInt("anncPublish")==1)
					flag=true;
				else{
					flag=false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
	
		} finally{
			destroy();
		}
		
		return flag;
	}
	
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
