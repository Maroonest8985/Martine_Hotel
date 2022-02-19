package com.example.demo.repository;
import java.sql.*;

public class DAOImplMysql implements DAO{
    Connection conn = null;

    @Override
    public Connection getConn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(
                    "jdbc:mysql://140.238.15.48:3306/induk_db?serverTimezone=UTC", // DB URL
                    "root", "Induk1234!");  // USER_NAME과 PASSWORD
            System.out.println("Success");
        }
        catch(SQLException ex){
            System.out.println("SQLException" + ex);
            ex.printStackTrace();
        }
        catch(Exception ex){
            System.out.println("Exception:" + ex);
            ex.printStackTrace();
        }
        return conn;
    }
}
