package com.koreait.board5.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/cmt")
public class CmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		int icmt = MyUtils.getParamInt("icmt", request);
		int iuser = MyUtils.getLoginUserPk(request);
		CmtVO vo = new CmtVO();
		vo.setIcmt(icmt);
		vo.setIuser(iuser);
		vo.setIboard(iboard);
		CmtDAO.delCmt(vo);
		// 삭제기능 자체에는 iboard값이 필요 없는데, detail로 이동 하기 위해서는 iboard값이 필요하다.
		response.sendRedirect("detail?iboard=" + iboard);
	}
	// post는 등록,삭제 기능
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request); // Iuser는 항상 session에서 얻어오자
		int icmt = MyUtils.getParamInt("icmt", request);
		CmtVO vo = new CmtVO();
		vo.setIboard(iboard);
		vo.setCmt(request.getParameter("cmt"));
		vo.setIuser(iuser);
		vo.setIcmt(icmt);
		CmtDAO.insCmt(vo);
		
		response.sendRedirect("detail?iboard="+iboard);
	}
}
