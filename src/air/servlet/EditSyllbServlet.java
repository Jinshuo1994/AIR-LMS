package air.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import air.service.SyllabusService;
import air.vo.Syllabus;

/**
 * Servlet implementation class EditSyllbServlet
 */
@WebServlet("/EditSyllbServlet")
public class EditSyllbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSyllbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int courseID = Integer.parseInt(request.getParameter("courseID"));
		String content = request.getParameter("content");
		Syllabus syllabus = new Syllabus();
		syllabus.setSyllabus(content);
		new SyllabusService().createSyllabus(syllabus, courseID);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
