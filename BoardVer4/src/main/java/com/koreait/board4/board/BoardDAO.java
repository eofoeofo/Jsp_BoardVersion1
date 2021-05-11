package com.koreait.board4.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board4.DBUtils;

public class BoardDAO {
	public static int insBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO t_board " + " (title,ctnt,iuser) " + " VALUES(?,?,?) ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}

	public static List<BoardVO> boardList() {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT A.iboard, A.title, A.regdt, B.unm " 
				   + " FROM t_board A " 
				   + " INNER JOIN t_user B "
				   + " ON A.iuser = B.iuser "
				   + " ORDER BY A.iboard DESC ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				int iboard = rs.getInt(1);
				String title = rs.getString(2);
				String regdt = rs.getString(3);
				String unm = rs.getString(4);
				BoardVO vo = new BoardVO();
				list.add(vo);
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setUnm(unm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
}
