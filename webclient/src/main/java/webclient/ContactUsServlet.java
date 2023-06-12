package webclient;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import com.models.CrmLead;

@WebServlet(urlPatterns = {"/contactus", "/contactus-thank-you"})
public class ContactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		if(req.getRequestURI().equals("/contactus-thank-you")) {
			rd = req.getRequestDispatcher("contactus-thank-you.jsp");	
		}else{
			rd = req.getRequestDispatcher("contactus.jsp");
		}
		rd.include(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Session ormSession = null;
			ServletContext ctx = getServletContext();
			ormSession = (Session) ctx.getAttribute("orm-session");
			CrmLead lead = new CrmLead();
			lead.setName(req.getParameter("name"));
			lead.setEmail(req.getParameter("email"));
			lead.setDescription(req.getParameter("description"));
			ormSession.beginTransaction();
			ormSession.save(lead);
			ormSession.getTransaction().commit();
			resp.sendRedirect(req.getContextPath() + "/contactus-thank-you");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
