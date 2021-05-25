package com.koreait.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board7.DBUtils;

public class BoardDAO {
	public static int selPagingCnt(BoardDTO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
//		StringBuilder sb = new StringBuilder();
//		sb.append(" SELECT CEIL(COUNT(*) / ? ")
//		.append(" FROM t_board ");
		String sql = " SELECT ceil(COUNT(*) / ?) AS cnt "
				   + " FROM t_board A "
				   + " INNER JOIN t_user B "
				   + " ON A.iuser = B.iuser ";
//		if(param.getSearchType() > 0) {
//			sb.append(" WHERE ");
//		}
		switch(param.getSearchType()) {
		case 1:
//			sb.append(" A.title LIKE '&")
//			.append(param.getSearchText())
//			.append("%' OR A.ctnt LIKE '%")
//			.append(param.getSearchText())
//			.append("%'");
			sql += String.format(" WHERE A.title LIKE '%%%s%%' OR A.ctnt LIKE '%%%s%%' ", 
					param.getSearchText(),param.getSearchText());
			break;
		case 2:
			sql += String.format(" WHERE A.title LIKE '%%%s%%' ",
					param.getSearchText());
			break;
		case 3:
			sql += String.format(" WHERE A.ctnt LIKE '%%%s%%' ",
					param.getSearchText());
			break;
		case 4:
			sql += String.format(" WHERE B.unm LIKE '%%%s%%' ",
					param.getSearchText());
			break;
		}
		try {
			con = DBUtils.getCon();
			ps  = con.prepareStatement(sql);
			ps.setInt(1, param.getRecordCnt());
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} return result;
	}
	public static List<BoardDomain> selBoardList(BoardDTO param) {
		List<BoardDomain> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.iboard, A.title, A.regdt, B.unm AS writerNm " 
				   + " FROM t_board A " 
				   + " INNER JOIN t_user B "
				   + " ON A.iuser = B.iuser ";
			switch(param.getSearchType()) {
			case 1:
				sql += String.format(" WHERE A.title LIKE '%%%s%%' OR A.ctnt LIKE '%%%s%%' ", 
						param.getSearchText(),param.getSearchText());
				break;
			case 2:
				sql += String.format(" WHERE A.title LIKE '%%%s%%' ",
						param.getSearchText());
				break;
			case 3:
				sql += String.format(" WHERE A.ctnt LIKE '%%%s%%' ",
						param.getSearchText());
				break;
			case 4:
				sql += String.format(" WHERE B.unm LIKE '%%%s%%' ",
						param.getSearchText());
				break;
			}
			  sql += " ORDER BY A.iboard DESC "
				   + " LIMIT ?,? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getStartIdx());
			ps.setInt(2, param.getRecordCnt());
			rs = ps.executeQuery();
			// while문으로 계속 하나의 객체를 생성
			while (rs.next()) {
				BoardDomain vo = new BoardDomain();
				list.add(vo);
				vo.setIboard(rs.getInt(1));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString(3));
				vo.setWriterNm(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
	public static BoardDomain selDetail(BoardDTO param) {
		BoardDomain result = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.ctnt, A.title, A.regdt, A.iuser, B.unm AS writerNm "
				   + " FROM t_board A " 
				   + " INNER JOIN t_user B "
				   + " ON A.iuser = B.iuser "
				   + " WHERE A.iboard = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			if(rs.next()) {
				result = new BoardDomain();
				result.setIboard(param.getIboard());
				result.setCtnt(rs.getString("ctnt"));
				result.setTitle(rs.getString("title"));
				result.setRegdt(rs.getString("regdt"));
				result.setIuser(rs.getInt("iuser"));
				result.setWriterNm(rs.getString("writerNm"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
}
