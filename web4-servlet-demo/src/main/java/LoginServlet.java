

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if("admin".equals(userName) && "admin".equals(password)) {
			//out.println("<h3>Login successfull</h3>");
			response.sendRedirect("http://localhost:8888/web4-servlet-demo/LoginSuccessFile.html");
				// here a dummy response is sent back to the client and a new request is placed from the client to LoginSuccessFile.html
			
		}else {
			//out.println("<h3>Login failed!</h3>");
			response.sendRedirect("http://localhost:8888/web4-servlet-demo/LoginFailedFile.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
