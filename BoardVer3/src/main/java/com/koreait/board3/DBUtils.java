package com.koreait.board3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	public static void main(String[] args) {
		//데이터베이스 연동 에러 확인
		try {
			getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon() throws Exception{
		final String DB_NAME = "boardver3";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3308/"+DB_NAME;
		final String USER_NAME = "root";
		final String PASSWORD = "koreait";
		
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
		System.out.println("연결 성공 !");
		
		return con;
	}
	public static void close(Connection con, PreparedStatement ps) {
		// select문을 제외하곤 rs를 쓰지 않기때문에 효율적으로 2개만 사용할 경우를 위해서 따로 만듬!
		close(con,ps,null);
	}
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		// select문을 할 땐 con,ps,rs를 다 쓴다.
		// select문 제외 하고는 정수형으로 return을 받는다 (행의 갯수?)
		// 열리는 순서는 con->ps->rs 닫히는 순서는 역순으로!
		// 한번의 try문에 담지 않는 이유는, rs가 닫히지 않으면 뒷순서 ps,con도 닫히지 않기에
		// rs가 안닫혀도 나머지는 닫기 위해서 각각의 try문에 담는것.
		if(rs != null) { 
			try {rs.close();} catch(SQLException e) { e.printStackTrace(); } // JAVA와 DB를 연결 해주는 다리 역활?
			try {ps.close();} catch(SQLException e) { e.printStackTrace(); } 
			// 쿼리를 실행 해주는 역활(많은 정보가 없기에 rs가 필요없다(끽해야 정수형으로 하나의 행만 수정,삭제하기에) 
			try {con.close();} catch(SQLException e) { e.printStackTrace(); } // "select"문의 역활, 결과값을 받는 역활
			}
	}
}
