package com.koreait.boardsignup.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.boardsignup1.MyUtils;

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJsp("board/write", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setCtnt(request.getParameter("ctnt"));
		vo.setIuser(MyUtils.getLoginUserPk(request));
		System.out.println("user PK : " + MyUtils.getLoginUserPk(request));
		BoardDAO.insBoard(vo);
		response.sendRedirect("list");
	}
}
