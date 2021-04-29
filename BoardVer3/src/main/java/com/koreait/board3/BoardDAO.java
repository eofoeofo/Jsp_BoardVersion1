package com.koreait.board3;

import java.sql.Connection;
import java.sql.PreparedStatement;

//Data Access Object (DB 담당!)
public class BoardDAO {
	//글 등록
	public static int insertBoard(BoardVO3 vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board (title,ctnt) "
				   + " VALUSE (?,?) ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql); // prepared 아닙니다
			ps.setString(1, vo.getTitle()); 
			// ps.setString(1,vo컬럼명) (첫번째 물음표,컬럼이 String이기에 setString)
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con,ps); // 무조건 닫아주세요(이해안감)
		}
		return 0;
	}
}
