package air.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import air.dao.AnncDao;
import air.dao.DaoFactory;

public class EditAnncServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  doPost(req,res);
	  }
	  
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  String anncTitle=req.getParameter("anncTitle");
		  String annc=req.getParameter("annc");
		  String page=null;
		  AnncDao ad=DaoFactory.getAnncDaoInstance();
		  if(ad.editAnnc(anncTitle, annc))
			  page="xxxx.jsp";
		  else page="xxx.jsp";
		  RequestDispatcher dispatcher=req.getRequestDispatcher(page);
			dispatcher.forward(req, res);
	  }

}
