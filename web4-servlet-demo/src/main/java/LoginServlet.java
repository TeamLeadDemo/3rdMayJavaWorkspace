

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// take out the request parameters from the request
		String userName = request.getParameter("user");
		String password = request.getParameter("pword");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		// process or logic - validation
		String validationResult = null;
		if("admin".equals(userName) && "admin".equals(password)) {
			//1.
			//out.println("<h3>Login successfull</h3>");
			
			//2.
			//response.sendRedirect("http://localhost:8888/web4-servlet-demo/LoginSuccessFile.html");
				// here a dummy response is sent back to the client and a new request is placed from the client to LoginSuccessFile.html
				// we are redirecting to a static page, means we are loosing the dynamisn
				// so lets redirect to a dynamic page say another servlet
			
			validationResult = "Login success!!";
			
			//request.setAttribute("user", userName);
			
			// going for a wider scope ot hold the user data - session
			HttpSession session = request.getSession();
			session.setAttribute("user", userName);
			
		}else {
			//1.
			//out.println("<h3>Login failed!</h3>");
			
			//2.
			//response.sendRedirect("http://localhost:8888/web4-servlet-demo/LoginFailedFile.html");
			
			validationResult = "Login failed!!";
		}
		// a request attribute is a name/value pair that holds data
		// you could add any no. of request attributes
		// we no longer need the LoginFailedFile.html amd LoginSuccessFile.html
		request.setAttribute("loginStatus", validationResult);
		
		// 3.
		//response.sendRedirect("http://localhost:8888/web4-servlet-demo/LoginStatus");
		
		//4. use RequestDispatcher
		RequestDispatcher rd = request.getRequestDispatcher("LoginStatus"); // this is internal
		rd.forward(request, response); // here the current servlets request and response if forwarded to LoginStatus
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
