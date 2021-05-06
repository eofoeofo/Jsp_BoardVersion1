package com.koreait.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	// 싱글톤 패턴
	private static MemberDAO instance;
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		if(instance==null)
			instance=new MemberDAO();
		return instance;
	}
	// String을 Date로 변경하는 메서드다.
	public static Date stringToDate(SignUpVO vo) {
		
		String year = vo.getBirthyy();
		String month = vo.getBirthmm();
		String day = vo.getBirthdd();
		
		Date birthday = Date.valueOf(year+"-"+month+"-"+day+"-");
		
		return birthday;
	}
	public static int insertMember(SignUpVO vo) {
		Connection con = null;
        PreparedStatement ps = null;
        
        try {
        	con = DBUtils.getCon();
        	
        	con.setAutoCommit(false);
        	String sql = " INSERT INTO user_member(id,userpwd,usernm,gender,birth,email,phone,address) "
        			   + " VALUES (?,?,?,?,?,?,?,?) ";
        	ps = con.prepareStatement(sql);
        	ps.setString(1, vo.getId());
        	ps.setString(2, vo.getUserpwd());
        	ps.setString(3, vo.getUsernm());
        	ps.setString(4, vo.getGender());
        	ps.setString(5, vo.getBirthyy()+vo.getBirthmm()+vo.getBirthdd());
        	ps.setString(6, vo.getEmail1()+vo.getEmail2());
        	ps.setString(7, vo.getPhone());
        	ps.setString(8, vo.getAddress());
        	ps.executeUpdate();
        	con.commit();
        } catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	DBUtils.close(con, ps);
        }
        return 0;
	}
	public static boolean checkId(String id) {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
		boolean chk = false;
		try {
			String sql = " SELECT id FROM uesr_member "
					   + " WHERE id = ? ";
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) chk = true;
			return chk;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return chk;
	}
}

