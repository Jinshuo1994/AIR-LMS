package air.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import air.service.CourseService;
import air.vo.Course;
import air.vo.User;

public class DisplayCourseServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CourseService courseService = new CourseService();
		//////////////ArrayList<>courseService.getCourseList();
		RequestDispatcher rd = req.getRequestDispatcher("admin/AdminCourseList.jsp");
		rd.forward(req, resp);
		
	}
	

}
