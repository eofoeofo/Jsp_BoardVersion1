package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int intIboard = Integer.parseInt(request.getParameter("iboard"));
		BoardVO vo = new BoardVO();
		BoardVO data = BoardDAO.selBoard(vo);
		request.setAttribute("data", data);
		MyUtils.openJsp("board/boardMod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setCtnt(request.getParameter("ctnt"));
		vo.setIboard(MyUtils.getParamInt("iboard", request));
		System.out.println("title : :!!! " + request.getParameter("title"));
		System.out.println("title GET : " +vo.getTitle());
		System.out.println("iboard : " + MyUtils.getParamInt("iboard", request));
		BoardDAO.boardMod(vo);
		response.sendRedirect("/board/list");
	}
}