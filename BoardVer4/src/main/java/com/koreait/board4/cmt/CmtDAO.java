package com.koreait.board4.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board4.DBUtils;

public class CmtDAO {
	public static int insCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board_cmt(iboard,iuser,cmt) "
				   + " VALUES(?,?,?) "; 
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.setString(3, param.getCmt());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	public static List<CmtVO> selCmt(int iboard) {
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
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			while(rs.next()) {
				CmtVO param = new CmtVO();
				list.add(param);
				param.setIboard(param.getIboard());
				param.setIuser(rs.getInt("iuser"));
				param.setIcmt(rs.getInt("icmt"));
				param.setCmt(rs.getString("cmt"));
				param.setUnm(rs.getString("unm"));
				param.setRegdate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
	public static int updCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " UPDATE t_board_cmt "
				   + " SET cmt = ? "
				   + " WHERE icmt = ? "
				   + " AND iboard = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getCmt());
			ps.setInt(2, param.getIcmt());
			ps.setInt(3, param.getIboard());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		} return 0;
	}
	public static int delCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " DELETE FROM t_board_cmt "
				   + " WHERE icmt = ? "
				   + " AND iuser = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIcmt());
			ps.setInt(2, param.getIuser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		} return 0;
	}
}
