package air.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import air.dao.DaoFactory;
import air.dao.UserDao;

public class AssignRoleServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  doPost(req,res);
	  }
	  
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  String role=req.getParameter("user_role");
		  String user_name=req.getParameter("user_name");
		  
		  UserDao userdao = DaoFactory.getUserDaoInstance();
		  userdao.assignRole(user_name,role);
		  
		  res.sendRedirect("./xxxxxxxx.jsp"); //¸Ä
	  }
}
