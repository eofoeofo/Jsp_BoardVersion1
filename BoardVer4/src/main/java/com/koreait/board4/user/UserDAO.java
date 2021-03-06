package com.koreait.board4.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.taglibs.standard.lang.jstl.EqualsOperator;
import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.DBUtils;

public class UserDAO {
	public static int joinUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO t_user(uid,upw,unm,gender) VALUES(?,?,?,?) ";

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

	// 로그인 성공:1 아이디없음:2 비번틀림:3 에러:0
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

			if (rs.next()) {
				// 한 행이라도 있는경우 true(1)
				String dbpw = rs.getString("upw");
				// iuser,unm값 담는법!
				int iuser = rs.getInt("iuser");
				String unm = rs.getString("unm");
				if(BCrypt.checkpw(param.getUpw(), dbpw)) {
					// BCrypt.checkpw(param.getUpw(), dbpw 
					// 1번이 암호화 된것, 2번이 암호화 안된것 1번과 2번이 맞으면 true
					param.setIuser(iuser);
					param.setUnm(unm);
					return 1;
				} else {
					return 3;
				}
//				param.setUid(param.getUid());
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
