package webclient;

import java.io.IOException;
import java.util.List;
import java.util.*;

import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.query.NativeQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import com.base.Users;
import com.exceptions.*;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 5960886120630556368L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		authenticate(request, response);
	}

	protected void authenticate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
 		if (this.isValidUser(username, password)) {
			request.getSession().invalidate();
			HttpSession newSession = request.getSession(true);
			newSession.setMaxInactiveInterval(300);
			newSession.setAttribute("current-user", request.getParameter("username"));
			String encode = response.encodeURL(request.getContextPath());
			response.sendRedirect(encode + "/home");

		} else {
			request.setAttribute("login-error", true);
			request.setAttribute("error-message", "Your email and password is invalid!");
			RequestDispatcher rdLogin = request.getRequestDispatcher("login.jsp");
			rdLogin.include(request, response);
		}
	}
	

	protected boolean isValidUser(String username, String password){
		boolean isLoggedInUser = false;
		Session ormSession = null;
		Users user = null;
		ServletContext ctx = getServletContext();
		ormSession = (Session) ctx.getAttribute("orm-session");
		TypedQuery<Users> query = ormSession.getNamedQuery("findUserByLogin");
		query.setParameter("login", username);
		List<Users> users = query.getResultList();
		Iterator<Users> itr = users.iterator();
		while (itr.hasNext()) {
			user = itr.next();
		}
		if(user!=null && user.getPassword().equals(password)){
			isLoggedInUser = true;
		}
		return isLoggedInUser;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("current-user") != null) {
			RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath() + "/home");
			rd.include(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("login-error", false);
			rd.include(request, response);
		}
	}
}
