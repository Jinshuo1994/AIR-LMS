package air.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import air.dao.AnncDao;
import air.dao.DaoFactory;

public class AnncListServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  doPost(req,res);
	  }
	  
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  AnncDao ad=DaoFactory.getAnncDaoInstance();
		  String coursename=req.getParameter("coursename");
		  ArrayList<String> anncList=null;
		try {
			anncList = ad.getAnncList(coursename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  req.setAttribute("anncList",anncList);
			RequestDispatcher dispatcher=req.getRequestDispatcher("uxxxxxx.jsp");
			dispatcher.forward(req,res);
	  }

}
