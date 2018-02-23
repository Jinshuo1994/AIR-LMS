package air.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import air.dao.DaoFactory;
import air.dao.EnrollmentDao;

public class CourseofSingleUserServlet  extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  doPost(req,res);
	  }
	  
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  EnrollmentDao ed =DaoFactory.getEnrollmentDao();
		  String username=req.getParameter("username");
		  ArrayList<String> courseList=null;
		try {
			courseList = ed.getCoursebyUser(username); 
			req.setAttribute("userCourse", courseList);
			RequestDispatcher dispatcher=req.getRequestDispatcher("userCourse.jsp");
			dispatcher.forward(req,res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  }
	

}
