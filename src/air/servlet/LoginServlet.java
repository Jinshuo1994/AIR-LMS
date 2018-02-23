package air.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import air.service.UserService;
import air.vo.User;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		 Get input parameter values (form data)
		System.out.println("this is a test line");
		
		
		String recap = req.getParameter("g-recaptcha-response");
				
				// Send get request to Google reCaptcha server with secret key  
				URL url = new URL("https://www.google.com/recaptcha/api/siteverify?secret="+"6LfAezsUAAAAANtONyPEQwMywl365mJhwQB-Yy_t"+"&response="+recap+"&remoteip="+req.getRemoteAddr());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				String line, outputString = "";
				BufferedReader reader = new BufferedReader(
				        new InputStreamReader(conn.getInputStream()));
				while ((line = reader.readLine()) != null) {
				    outputString += line;
				}
				
				// Convert response into Object
				Response capRes = null;
				
				capRes = new Gson().fromJson(outputString, Response.class);
				// Verify whether the input from Human or Robot 
				if(!capRes.isSuccess()) {
					resp.sendRedirect("login.jsp?error=recaptchaError");
				} else {
					
					//login part
					String userName = req.getParameter("username").trim();
					String password = req.getParameter("password").trim();
					UserService loginService = new UserService();
					User user = new User();
					user.setUserName(userName);
					user.setPassword(password);
					String pageStudent="studentmain.jsp";
					String pageAdmin="adminmain.jsp";
					String pageInstructor="instructormain.jsp";
					RequestDispatcher rd=null;
					boolean pwdCorrect = loginService.checkPwd(user);
					if(pwdCorrect) {
						user.setRole(loginService.getUserRole(user));
						user.setUser_id(loginService.getUserId(user));
						System.out.println(user.getRole());
						System.out.println(user.getUser_id());
						HttpSession session = req.getSession();
						session.setAttribute("user", user);
						if(user.getRole().equals("admin"))
						rd = req.getRequestDispatcher(pageAdmin);
						else if(user.getRole().equals("instructor"))
							rd = req.getRequestDispatcher(pageInstructor);
						else
							rd = req.getRequestDispatcher(pageStudent);
						
						rd.forward(req, resp);
					} else {
						resp.sendRedirect("login.jsp?error=loginError");
					}
				}
				
				
				
				
				
				
				
	}
	
	
	
	
}
