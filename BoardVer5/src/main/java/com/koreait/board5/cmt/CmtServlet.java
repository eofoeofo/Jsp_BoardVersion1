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
		CmtVO vo = new CmtVO();
		vo.setIcmt(MyUtils.getParamInt("icmt", request));
		vo.setIuser(MyUtils.getLoginUserPk(request));
		vo.setIboard(MyUtils.getParamInt("iboard", request));
		CmtDAO.delCmt(vo);
		// 삭제기능 자체에는 iboard값이 필요 없는데, detail로 이동 하기 위해서는 iboard값이 필요하다.
		response.sendRedirect("detail?iboard=" + MyUtils.getParamInt("iboard", request));
	}
	// post는 (insert,update기능)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CmtVO vo = new CmtVO();
		vo.setCmt(request.getParameter("cmt"));
		vo.setIuser(MyUtils.getLoginUserPk(request)); // Iuser는 항상 session에서 얻어오자
		System.out.println("icmt!!!! : "+MyUtils.getParamInt("icmt", request));
		if (MyUtils.getParamInt("icmt", request) != 0) {
			vo.setIcmt(MyUtils.getParamInt("icmt", request));
			CmtDAO.updCmt(vo);
		} else {
			vo.setIboard(MyUtils.getParamInt("iboard", request));
			CmtDAO.insCmt(vo);
		}
		
		response.sendRedirect("detail?iboard=" + MyUtils.getParamInt("iboard", request));
	}
}
