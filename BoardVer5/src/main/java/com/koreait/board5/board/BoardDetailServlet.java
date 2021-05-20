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
		BoardVO vo2 = new BoardVO();
		vo2.setIboard(iboard);
		vo2.setIuser(MyUtils.getLoginUserPk(request));
		// 로그인 user의 PK값
		vo2 = BoardDAO.selBoard(vo2);
		request.setAttribute("data", vo2);
		request.setAttribute("list", CmtDAO.selListCmt(iboard));
		
		
//		System.out.println("iboard : " + CmtDAO.selListCmt(MyUtils.getParamInt("iboard", request)));
		MyUtils.openJsp("board/boardDetail", request, response);
		
	}
}
