package com.db.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String query = "SELECT id,name,age FROM employee_employee";
		try {
//			SqlDatabaseConnection sql = new SqlDatabaseConnection("localhost", "3306", "cell_production", "shiv", "shiv");
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
