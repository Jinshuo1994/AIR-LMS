package air.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import air.dao.DaoFactory;
import air.dao.EnrollmentDao;

public class RemoveUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  doPost(req,res);
	  }
	  
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  String coursename=req.getParameter("course_name");
		  String username=req.getParameter("user_name");
		  String page=null;
		  EnrollmentDao ed=DaoFactory.getEnrollmentDao();
		  try {
			  if(ed.removeUser(username,coursename))
				  page="xxxx.jsp";
			  else page="xxxx.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  RequestDispatcher dispatcher=req.getRequestDispatcher(page);
			dispatcher.forward(req, res);
	  }

}
