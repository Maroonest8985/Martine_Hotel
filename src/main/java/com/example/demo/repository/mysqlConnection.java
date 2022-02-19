package com.example.demo.repository;
import java.sql.*;

public class mysqlConnection {
    public static void main(String args[]){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(
                    "jdbc:mysql://140.238.15.48:3306/induk_db?serverTimezone=UTC?autoReconnect=true", // DB URL
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
    }

}
