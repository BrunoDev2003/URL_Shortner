package com.url_shortner.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	protected ResultSet rs;
	protected Connection con;
	protected PreparedStatement stmt;
	
	private static final String DATABASE = "login_system_db?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "bartallen12";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:8080";
	
	public void open() throws Exception {
		Class.forName(DRIVER);
		con = DriverManager.getConnection(URL+DATABASE,USER,PASS);
		
		
	}
	
	public void close() throws Exception {
		if(!con.isClosed()) {
			con.close();
		}
	}
}
