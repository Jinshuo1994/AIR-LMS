package air.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import air.service.CourseService;
import air.service.UserService;
import air.vo.Course;
import air.vo.User;
public class CreateCourseServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String courseName = req.getParameter("coursename").trim();
		String courseLoc = req.getParameter("courseloc").trim();
		int courseId = Integer.parseInt(req.getParameter("courseid"));
		Course course = new Course();
		course.setCourse_name(courseName);
		course.setCourse_loc(courseLoc);
		course.setCourse_id(courseId);
	
		CourseService courseService = new CourseService();
		courseService.createCourse(course);
			RequestDispatcher rd = req.getRequestDispatcher("admin/createcourse.jsp");
			////page
			rd.forward(req, resp);	
	}
}
