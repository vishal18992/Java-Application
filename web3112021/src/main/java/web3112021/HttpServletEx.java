package web3112021;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/httpServlet")
public class HttpServletEx extends HttpServlet {

	public void init() {
		System.out.println("Init Method::");
	}

	public void destroy() {
		System.out.println("Init Method::");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("Hello From HttpServlet:");
		ServletConfig servletConfig = getServletConfig();
		ServletContext servletContext1 = getServletConfig().getServletContext();
		ServletContext servletContext = getServletContext();
		if(servletContext1 == servletContext)
			System.out.println("both are equals:");
		String email = servletConfig.getInitParameter("email");
		String phone = servletConfig.getInitParameter("phone");
		String url = servletContext.getInitParameter("dbURL");
	}

}
