package web3112021;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/login", initParams = {
		@WebInitParam(name = "email", value = "webmaster@domain.com", description = "Email from webmaster"),
		@WebInitParam(name = "phone", value = "xxxx/xx.xx.xx", description = "Phone webmaster") }, description = "Servlet 3 initialisation parameter annotation example: @WebInitParam")
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		ServletConfig sc = getServletConfig();
		String email = sc.getInitParameter("email");
		System.out.println("email :: " + email);

		ServletContext sco =  getServletContext();
		ServletContext sco1  = getServletConfig().getServletContext();
		sco.getInitParameter("dbusername");
		System.out.println("Sco is :"+ sco);
		String n = request.getParameter("userName");
		String p = request.getParameter("userPass");

		if (p.equals("servlet")) {
			
			  RequestDispatcher rd = request.getRequestDispatcher("/home");
			  rd.forward(request, response); Integer val =
			  (Integer)sco.getAttribute("logincount");
			 
			//sco.setAttribute("logincount", ++val);
			 //response.sendRedirect("home");
			// request.setAttribute("something", "value");

		} else {
			out.print("Sorry UserName or Password Error!");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);

		}
	}
}
