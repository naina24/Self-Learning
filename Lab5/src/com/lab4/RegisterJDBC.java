package com.lab4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RegisterJDBC {
	protected static Connection initializeDatadase() throws SQLException,ClassNotFoundException{
		String dbDriver="com.mysql.cj.jdbc.Driver";
		String dbURL="jdbc:mysql://localhost:3306/";
		String dbName="userlogin";
		String dbUsername="root";
		String dbPassword="Naina@2001";
		Class.forName(dbDriver);
		Connection con=DriverManager.getConnection(dbURL+dbName,dbUsername,dbPassword);
		return con;
	}
}
