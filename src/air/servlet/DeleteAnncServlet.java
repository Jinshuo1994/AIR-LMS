package air.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import air.dao.AnncDao;
import air.dao.DaoFactory;

public class DeleteAnncServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  doPost(req,res);
	  }
	  
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
	         throws IOException, ServletException{
		  String anncTitle=req.getParameter("anncTitle");
		  String page=null;
		  AnncDao ad=DaoFactory.getAnncDaoInstance();
		  try {
			if(ad.deleteAnnc(anncTitle)) page="xxxx.jsp";
			else page="xxxx.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  RequestDispatcher dispatcher=req.getRequestDispatcher(page);
			dispatcher.forward(req, res);
	  }

}
