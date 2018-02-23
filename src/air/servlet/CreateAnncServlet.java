package air.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import air.dao.AnncDao;
import air.dao.DaoFactory;

public class CreateAnncServlet extends HttpServlet {

	  public void doGet(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  
	  }
	  
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  String page="xxx.jsp";
		  AnncDao ad=DaoFactory.getAnncDaoInstance();
		  String annc=req.getParameter("annc");
		  String anncTitle=req.getParameter("anncTitle");
		  String courseName=req.getParameter("courseName");
		  try {
			ad.addAnnc(anncTitle, annc, courseName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  RequestDispatcher dispatcher=req.getRequestDispatcher(page);
			dispatcher.forward(req, res);
		  
	  }

}
