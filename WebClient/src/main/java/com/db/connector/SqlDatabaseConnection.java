package com.db.connector;

import java.sql.*;

import lombok.Getter;
import lombok.Setter;  

public class SqlDatabaseConnection {
	private @Getter @Setter String host = null;
	private @Getter @Setter String port = null;
	private @Getter @Setter String databaseName = null;
	private @Getter @Setter String userName = null;
	private @Getter @Setter String password = null;
	
	public SqlDatabaseConnection(String host, String port, String databaseName, String userName, String password) {
		super();
		this.host = host;
		this.port = port;
		this.databaseName = databaseName;
		this.userName = userName;
		this.password = password;
	}
	
	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return this.port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDatabaseName() {
		return this.databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");	
		String str = "jdbc:mysql://" + this.getHost() + ":" + this.getPort() + "/" + this.getDatabaseName();
		System.out.println("strstrstrstrstr" + str);
		Connection con = DriverManager.getConnection(str,this.getUserName(),this.getPassword());
		return con;
	}
	
	public Statement getCursor() throws ClassNotFoundException, SQLException {
		Statement stmt = this.getConnection().createStatement();
		return stmt;
	}
	
	public ResultSet execute(String query) throws ClassNotFoundException, SQLException {
		ResultSet rs= this.getCursor().executeQuery(query);  
		System.out.println("rs" + rs);
		return rs;
	}
	
}
		