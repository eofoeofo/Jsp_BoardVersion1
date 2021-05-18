package com.koreait.board4.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;

@WebServlet("/board/cmt")
public class CmtSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CmtVO vo = new CmtVO();
		vo.setIcmt(MyUtils.getParamInt("icmt", request));
		vo.setIboard(MyUtils.getParamInt("iboard", request));
		vo.setIuser(MyUtils.getLoginUserPk(request));
		CmtDAO.delCmt(vo);
		response.sendRedirect("detail?iboard="+MyUtils.getParamInt("iboard", request));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CmtVO vo = new CmtVO();
		vo.setIboard(MyUtils.getParamInt("iboard", request));
		vo.setIcmt(MyUtils.getParamInt("icmt", request));
		vo.setCmt(request.getParameter("cmt"));
		vo.setIuser(MyUtils.getLoginUserPk(request));
		if(MyUtils.getParamInt("icmt", request) != 0) {
			CmtDAO.updCmt(vo);
		} else {
			CmtDAO.insCmt(vo);
		}
		response.sendRedirect("detail?iboard="+MyUtils.getParamInt("iboard", request));
	}
}
