package com.koreait.board6.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board6.DBUtils;
import com.koreait.board6.board.BoardVO;

public class BoardDAO {
	public static int getAllPage(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql  = " SELECT CEIL(COUNT(*) / ?) as cnt"
				    + " FROM t_board "
				    + " WHERE title LIKE ? " ;
		int result = 0;
		try {
			con = DBUtils.getCon();
			ps  = con.prepareStatement(sql);
			ps.setInt(1, param.getPage());
			ps.setString(2, "%"+param.getSearch()+"%");
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
	public static List<BoardVO> selBoardList(BoardVO param) {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.iboard, A.title, A.regdt, B.unm " 
				   + " FROM t_board A " 
				   + " INNER JOIN t_user B "
				   + " ON A.iuser = B.iuser "
				   + " WHERE A.title LIKE ? "
				   + " ORDER BY A.iboard DESC "
				   + " LIMIT ?, ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+param.getSearch()+"%");
			ps.setInt(2, param.getsIdx());
			ps.setInt(3, param.getPage());
			rs = ps.executeQuery();
			// while문으로 계속 하나의 객체를 생성
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				list.add(vo);
				vo.setIboard(rs.getInt(1));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString(3));
				vo.setUnm(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
	public static BoardVO selBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.ctnt, A.title, A.regdt, A.iuser, B.unm "
				   + " FROM t_board A " 
				   + " INNER JOIN t_user B "
				   + " ON A.iuser = B.iuser "
				   + " WHERE A.iboard = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIboard(iboard);
				vo.setCtnt(rs.getString("ctnt"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
				return vo;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
}
