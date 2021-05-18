package com.koreait.board5.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;
import com.koreait.board5.cmt.CmtDAO;
import com.koreait.board5.cmt.CmtVO;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MyUtils.getLoginUser(request) == null) {
			response.sendRedirect("/user/login");
			return;
		}
		MyUtils.getLoginUser(request).getIuser();
		int iboard = MyUtils.getParamInt("iboard", request);
		CmtVO vo = new CmtVO();
		request.setAttribute("data", BoardDAO.selBoard(MyUtils.getParamInt("iboard", request)));
		request.setAttribute("list", CmtDAO.selListCmt(iboard));
		System.out.println("iboard : " + vo.getIboard());
		System.out.println("cmt :: " + vo.getCmt());
		
//		System.out.println("iboard : " + CmtDAO.selListCmt(MyUtils.getParamInt("iboard", request)));
		MyUtils.openJsp("board/boardDetail", request, response);
		
	}
}
