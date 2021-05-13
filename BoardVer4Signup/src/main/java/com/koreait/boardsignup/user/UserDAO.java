package com.koreait.boardsignup.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.boardsignup1.DBUtils;

public class UserDAO {
	public static int joinUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_user(uid,upw,unm,gender) VALUES(?,?,?,?) " ;
		
		try {
		con = DBUtils.getCon();
		ps = con.prepareStatement(sql);
		ps.setString(1, param.getUid());
		ps.setString(2, param.getUpw());
		ps.setString(3, param.getUnm());
		ps.setInt(4, param.getGender());
		return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	public static int loginUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM t_user WHERE uid = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String dbpw = rs.getString("upw");
				String unm = rs.getString("unm");
				int iuser = rs.getInt("iuser");
				if(BCrypt.checkpw(param.getUpw(), dbpw)) {
					param.setIuser(iuser);
					param.setUnm(unm);
					return 1;
				} else {
					return 3;
				}
			} else {
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return 0;
	}
}