package web3112021;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/register", initParams = {
		@WebInitParam(name = "email", value = "webmaster@domain.com", description = "Email from webmaster"),
		@WebInitParam(name = "phone", value = "xxxx/xx.xx.xx", description = "Phone webmaster") }, description = "Servlet 3 initialisation parameter annotation example: @WebInitParam")

public class RegistrationServlet extends HttpServlet {

	public void init() {
		System.out.println("Inside Init::");
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("fname");
		res.getWriter().write("Hello World from  GET servlet:" + name);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletConfig servletConfig = getServletConfig();
		String email = servletConfig.getInitParameter("email");
		String phone = servletConfig.getInitParameter("phone");
		ServletContext servletContext1 = getServletConfig().getServletContext();
		ServletContext servletContext = getServletContext();
		if (servletContext1 == servletContext)
			System.out.println("both are equals:");
		String url = servletContext.getInitParameter("dbURL");
		String servletName = servletConfig.getServletName();
		String name = req.getParameter("fname");
		res.getWriter().write("Hello World from POST servlet:" + name + ":Servlet:" + servletName);
	}

	public void destroy() {
		System.out.println("Inside Init::");
	}

	public void caluclate() {

	}

}
