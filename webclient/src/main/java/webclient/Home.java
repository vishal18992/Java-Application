package webclient;
import java.io.*;  
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Home extends HttpServlet {
	
	 protected void service(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException{
		 
		// TODO Auto-generated method stub
//			Cookie[] ck = request.getCookies();
//			System.out.println("ckckck" + ck + ck.toString());
//			
//			 if(ck!=null){ for (Cookie cookie : ck) { 
//				 if(cookie.getName().equals("current-user") && cookie.getValue().equals("admin@gmail.com")) {
//					 request.setAttribute("login",true);
//					 }
//				 }
//			 }
		 	RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.include(request, response);
			
	 }
	
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		Cookie[] ck = request.getCookies();
//		System.out.println("ckckck" + ck + ck.toString());
//		
//		 if(ck!=null){ for (Cookie cookie : ck) { 
//			 if(cookie.getName().equals("current-user") && cookie.getValue().equals("admin@gmail.com")) {
//				 request.setAttribute("login",true);
//				 }
//			 }
//		 }
//		 
//		if(request.getAttribute("login") != null && request.getAttribute("login").equals(true)) {
//			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
//			rd.include(request, response);
//		}else {
//			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
//			request.setAttribute("login", false);
//			rd.include(request, response);
//		}
//	}
}
