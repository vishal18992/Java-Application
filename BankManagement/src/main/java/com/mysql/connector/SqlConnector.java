package com.mysql.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnector {

    protected static String url = null;

    protected static String databaseName = null;
    protected static String userName = null;
    protected static String password = null;

    public SqlConnector(){}
    public SqlConnector(String url, String databaseName, String userName, String password){
        SqlConnector.url = url;
        SqlConnector.databaseName = databaseName;
        SqlConnector.userName = userName;
        SqlConnector.password = password;
    }

    public String getDriverUrl() {
        return SqlConnector.url + "/" + SqlConnector.databaseName;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String URL = this.getDriverUrl();
        Connection cn = DriverManager.getConnection(URL, SqlConnector.userName, SqlConnector.password);
        return cn;
    }
}
