package web3112021;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/genericServlet")
public class GenericServlet extends javax.servlet.GenericServlet {

	public void init() {
		System.out.println("Init Method::");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.getWriter().write("Hello From GenericServlet:");
		
	}
	
	public void destroy() {
		System.out.println("Init Method::");
	}

}
