package com.webclient;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.connector.SqlDatabaseConnection;
/**
 * Servlet implementation class WebClientServlet
 */
@WebServlet("/submitForm")
public class WebClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String number = request.getParameter("number");
		PrintWriter writer =  response.getWriter();
		writer.println("Number is:" + number);
		writer.flush();
		String query = "SELECT id,name,age FROM employee_employee";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cell_production","shiv","shiv");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee_employee");
			System.out.println("rs" + rs);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			}
		}catch (ClassNotFoundException ex) {
			// TODO: handle exception
			System.out.println("Exception " + ex);
		}catch(SQLException sq) {
			System.out.println("Exception " + sq);
		}
	}

}
