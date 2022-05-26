

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginStatus
 */
public class LoginStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// here we will try to take out the request attribute "loginStatus" from the request
		String status = (String) request.getAttribute("loginStatus"); // there is no loginStatus request attribute if we reached this servlet through response.sendRedirect
		
		//String getUser = (String) request.getAttribute("user");
		
		HttpSession session = request.getSession();
		String getUser = (String) session.getAttribute("user");
		
		// now print the status to the response
		PrintWriter out = response.getWriter();
		
		out.println("<h2>"+status+"</h2>");
		
		if(getUser != null) {
			out.println("<h4>Welcome "+getUser+"!! </h4>");
			out.println("<a href=\"http://localhost:8888/web4-servlet-demo/Logout\">Logout</a>");
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
