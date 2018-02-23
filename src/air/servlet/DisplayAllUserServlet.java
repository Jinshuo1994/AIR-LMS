package air.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import air.dao.DaoFactory;
import air.dao.UserDao;

public class DisplayAllUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  doPost(req,res);
	  }
	  
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  UserDao ud=DaoFactory.getUserDaoInstance();
		  ArrayList<String> userList=ud.getUserList();
		  req.setAttribute("userList", userList);
			RequestDispatcher dispatcher=req.getRequestDispatcher("userList.jsp");
			dispatcher.forward(req,res);
	  }
	

}
