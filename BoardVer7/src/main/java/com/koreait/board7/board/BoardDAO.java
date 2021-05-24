package com.koreait.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board7.DBUtils;

public class BoardDAO {
	public static List<BoardDomain> selBoardList() {
		List<BoardDomain> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.iboard, A.title, A.regdt, B.unm AS writerNm " 
				   + " FROM t_board A " 
				   + " INNER JOIN t_user B "
				   + " ON A.iuser = B.iuser "
				   + " ORDER BY A.iboard DESC ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// while문으로 계속 하나의 객체를 생성
			while (rs.next()) {
				BoardDomain vo = new BoardDomain();
				list.add(vo);
				vo.setIboard(rs.getInt(1));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString(3));
				vo.setWriteNm(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
}
