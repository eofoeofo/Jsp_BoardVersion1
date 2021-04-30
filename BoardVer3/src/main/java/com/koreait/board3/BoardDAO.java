package com.koreait.board3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Data Access Object (DB 담당!)
public class BoardDAO {
	//글 등록
	public static int insertBoard(BoardVO3 vo) { // 결국 VO에서 값을 받아와서 SQL에 값을 넣어줄겁니다
		Connection con = null; // 다리역할 , ps 객체화
		PreparedStatement ps = null; // 물음표의 역활, 쿼리문 완성 및 쿼리문 실행까지!
		
		String sql = " INSERT INTO t_board (title,ctnt) VALUES (?,?) ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql); // prepared 아닙니다
			
			ps.setString(1, vo.getTitle()); // ps가 null일 때 실행되면 에러남
			ps.setString(2, vo.getCtnt()); 
			// ps.setString(1,vo컬럼명) (첫번째 물음표,컬럼이 String이기에 setString)
			// String이면 내가 넣고자 하는 타입이 String 즉, 괄호 안에 두번째 타입을 뜻함.
			
			return ps.executeUpdate(); //insert,update,delete 사용할 때! executeUpdate를 써야 실행이 되요
			// return 타입은 정수형이고, 그 말은 보통 selete제외 하고는 하나의 행을 다루기 때문이다.
			// return 보통 0,1이다. 0이면 에러가 났을거임-> catch문을 만나 결국 return 0을 만나기 때문이다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con,ps); // 무조건 닫아주세요(이해안감), 자원낭비,커넥션풀
		}
		return 0;
	}

	public static List<BoardVO3> selBoardList() { // list서블릿의 list에 리턴된다
		List<BoardVO3> list = new ArrayList();
		// 하나의 객체에 몰아서 담게된다면 같은 값으로 저정된다.
		// 다른 값으로 저장 받고 싶다면 항상 새로운 객체로 만들어야한다.
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT iboard,title,regdt "
				   + " FROM t_board ";
		try {
			con = DBUtils.getCon(); // con은 항상 dbbtils의 getcon을 받아온다
			ps = con.prepareStatement(sql); // con으로부터 prepare(메소드)를 얻어온다.
			rs = ps.executeQuery(); // select만 executeQuery를 사용한다! 나머지는 update
			// 쿼리의 리턴타입은 rs이다.
			
			while(rs.next()) { // 1. 레코드 가르키기 최초 실행될 떄 첫번째 레코드를 가르킨다
				// next는 리턴값 불린, 레코드가 존재하면 true 존재하지 않으면 false 
				BoardVO3 vo = new BoardVO3();
				list.add(vo); // 위치에 상관 없다
				
				// 하나의 레코드들이 모여 결국 하나의 행이 담기게 되는것이에요.
				int iboard = rs.getInt(1); 
				String title = rs.getString(2);
				String regdt = rs.getString(3);
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
	
	public static BoardVO3 selBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT iboard,title,regdt "
				   + " FROM t_board ";
		try {
			con = DBUtils.getCon(); // con은 항상 dbbtils의 getcon을 받아온다
			ps = con.prepareStatement(sql); // con으로부터 prepare(메소드)를 얻어온다.
			rs = ps.executeQuery(); // select만 executeQuery를 사용한다! 나머지는 update
			// 쿼리의 리턴타입은 rs이다.
			
			while(rs.next()) { // 1. 레코드 가르키기 최초 실행될 떄 첫번째 레코드를 가르킨다
				// next는 리턴값 불린, 레코드가 존재하면 true 존재하지 않으면 false 
				BoardVO3 vo = new BoardVO3();
				list.add(vo); // 위치에 상관 없다
				
				// 하나의 레코드들이 모여 결국 하나의 행이 담기게 되는것이에요.
				int iboard = rs.getInt(1);  
				String title = rs.getString(2);
				String regdt = rs.getString(3);
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
}
