package com.koreait.board5.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.board.BoardVO;
import com.koreait.board5.DBUtils;

public class BoardDAO {
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
	public static BoardVO selBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.ctnt, A.title, A.regdt, A.iuser, B.unm, A.iboard,"
				   + " IF(C.iboard IS NULL ,0 ,1) AS isFav " 
				   + " FROM t_board A " 
				   + " INNER JOIN t_user B "
				   + " ON A.iuser = B.iuser "
				   + " LEFT JOIN t_board_fav C "
				   + " ON A.iboard = C.iboard "
				   + " AND C.iuser = ? "
				   + " WHERE A.iboard = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIuser()); // 로그인 user pk
			ps.setInt(2, param.getIboard());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setUnm(rs.getString("unm"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setIsFav(rs.getInt("isFav"));
				return vo;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
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
			ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils
			.close(con, ps);
		}
		return 0;
	}
	public static void remove(BoardVO param) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " DELETE FROM "
				   + " t_board "
				   + " WHERE iboard = ? "
				   + " AND iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	public static int boardMod(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " UPDATE t_board SET title = ? "
				   + " , ctnt = ? WHERE iboard = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
}
