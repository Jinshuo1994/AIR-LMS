package air.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import air.service.UserService;
import air.vo.User;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username").trim();
		String password = req.getParameter("password").trim();
		
		UserService userService = new UserService();
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		
		boolean accountCreated = userService.createAccount(user);
		if(accountCreated) {
			resp.sendRedirect("signup.jsp?success=signupSuccess");
		} else {
			resp.sendRedirect("signup.jsp?error=signupError");
		}
	}

}
