package air.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import air.service.CourseService;
//import air.service.LoginService;
import air.vo.Course;
public class DeleteCourseServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int courseId =Integer.parseInt(req.getParameter("courseid"));
		Course course = new Course();
		
		course.setCourse_id(courseId);
	
		CourseService courseService = new CourseService();
		boolean courseDeleted = courseService.deleteCourse(course);
		if(courseDeleted){
			RequestDispatcher rd = req.getRequestDispatcher("admin/deletecourse.jsp");
			///page 
			
			rd.forward(req, resp);			
		}
		else{
			resp.sendRedirect("admin/deletecourse.jsp?error=deleteError");
		}
		
			
	}

}
