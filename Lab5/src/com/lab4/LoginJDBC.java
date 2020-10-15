package com.lab4;

import java.sql.*;

public class LoginJDBC{
 
    public boolean checkLogin(String email, String dob){
    	boolean status=false;
    	try {
        String jdbcURL = "jdbc:mysql://localhost:3306/userlogin";
        String dbUser = "root";
        String dbPassword = "Naina@2001";
 
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM user WHERE email = ? and dob = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, dob);
 
        ResultSet result = statement.executeQuery();
        status=result.next();
        
    	}catch(Exception e){
    		e.printStackTrace();
    	}
 
        return status;
    }
}
