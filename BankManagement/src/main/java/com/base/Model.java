package com.base;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.mysql.connector.SqlConnector;

public class Model extends SqlConnector{

    public Model(){}
    public Model(String url, String databaseName, String userName, String password) {
        super(url, databaseName, userName, password);
    }

    public void createInFile(String filePath, String fileName, String[] values){
        String str  = String.format("%s%s", filePath, fileName);
        try{
            CSVWriter writer = new CSVWriter(new FileWriter(str, true));
            writer.writeNext(values, false);
            writer.close();
        }catch (IOException ex){
            System.out.println("Exception " + ex);
        }
    }

    public void create(String query) {
        Connection cn = null;
        try {
            cn = this.getConnection();
            Statement st = cn.createStatement();
            System.out.println(query);
            Integer rs = st.executeUpdate(query);
            System.out.println("Result" + rs.intValue() );
//            while(rs.next()){
//                System.out.println(rs + "  " + rs.getString(1));
//            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Create Exception" + ex);
        } finally {
            try {
                cn.close();
            }catch (SQLException ex){}
        }
    }
    public int create(String query, ArrayList params) throws SQLException, ClassNotFoundException{
        return 0;
    }
    public ArrayList read(String query) {
        ArrayList<ArrayList> list = new ArrayList();
        try {
            Connection cn = this.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
//            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()){
                ArrayList listInner = new ArrayList();
                listInner.add(rs.getString(1));
                listInner.add(rs.getString(2));
                listInner.add(rs.getString(3));
                listInner.add(rs.getString(4));
                list.add(listInner);
            }
            cn.close();
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Read Exception" + ex);
        }
        return list;
    }

    public int write(String query){
        int result = 0;
        try {
            Connection cn = this.getConnection();
            Statement st = cn.createStatement();
            result = st.executeUpdate(query);
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Write Exception" + ex);
        }
        return result;
    }

    public int unlink(String query) {
        int result = 0;
        try {
            Connection cn = this.getConnection();
            Statement st = cn.createStatement();
            result = st.executeUpdate(query);
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Unlink Exception" + ex);
        }
        return result;
    }

}
