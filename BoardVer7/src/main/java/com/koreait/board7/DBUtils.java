package com.koreait.board7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {


	public static Connection getCon() throws Exception{
		final String DB_NAME = "boardver4";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3308/"+DB_NAME;
		final String USER_NAME = "root";
		final String PASSWORD = "koreait";
		
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
		
		return con;
	}
	public static void close(Connection con, PreparedStatement ps) {
		close(con,ps,null);
	}
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs != null) { 
			try {rs.close();} catch(SQLException e) { e.printStackTrace(); } // JAVA와 DB를 연결 해주는 다리 역활?
			try {ps.close();} catch(SQLException e) { e.printStackTrace(); } 
			try {con.close();} catch(SQLException e) { e.printStackTrace(); } // "select"문의 역활, 결과값을 받는 역활
		}
	}
}