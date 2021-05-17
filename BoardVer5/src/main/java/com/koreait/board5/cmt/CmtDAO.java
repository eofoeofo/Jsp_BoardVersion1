package com.koreait.board5.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;

public class CmtDAO {
	public static void insCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board_cmt(iboard,iuser,cmt)"
				   + " VALUES(?,?,?) ";
		try {
			con = DBUtils.getCon();
			ps  = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.setString(3, param.getCmt());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	public static List<CmtVO> selListCmt(int iboard) {
		List<CmtVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.iuser, A.cmt, B.unm, A.regdate, A.icmt "
				   + " FROM t_board_cmt A "
				   + " INNER JOIN t_user B "
				   + " ON A.iuser = B.iuser "
				   + " WHERE A.iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps  = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			while(rs.next()) {
				CmtVO vo = new CmtVO();
				list.add(vo);
				vo.setIboard(vo.getIboard());
				vo.setIuser(rs.getInt("iuser"));
				vo.setCmt(rs.getString("cmt"));
				vo.setUnm(rs.getString("unm"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setIcmt(rs.getInt("icmt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
	public static int delCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " DELETE FROM "
				   + " t_board_cmt "
				   + " WHERE icmt = ? "
				   + " AND iboard = ? ";
		try {
			con = DBUtils.getCon();
			ps  = con.prepareStatement(sql);
			ps.setInt(1, param.getIcmt());
			ps.setInt(2, param.getIboard());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		} 
		return 0;
	}
}
