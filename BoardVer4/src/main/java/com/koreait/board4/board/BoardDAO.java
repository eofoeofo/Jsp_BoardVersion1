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
	public static int updateBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " UPDATE t_board SET title = ? "
				   + " ,ctnt = ? WHERE iboard = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());
//			ps.setInt(4, param.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	public static int deleteBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " DELETE FROM t_board WHERE iboard = ? "
				   + " AND iuser = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			return ps.executeUpdate();
//			System.out.println("DAO_IUSER : "+param.getIuser());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
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
	public static BoardVO selBoard(int iboard,int iuser) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.ctnt, A.title, A.regdt, A.iuser, B.unm,"
				   + " IF(C.iboard IS NULL,0,1) AS isFav " 
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
			ps.setInt(1, iuser);
			ps.setInt(2, iboard);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIboard(iboard);
				vo.setCtnt(rs.getString("ctnt"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
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
}
