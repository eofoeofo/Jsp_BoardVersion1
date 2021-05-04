package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod")
public class BoardModServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
		BoardVO data = BoardDAO.selBoard(intIboard);
		request.setAttribute("data", data);
		request.getRequestDispatcher("WEB-INF/view/mod.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int intIboard = Integer.parseInt(iboard);
		BoardVO vo = new BoardVO();
		System.out.println("title : "+ title);
		System.out.println("content : "+ ctnt);
		System.out.println("intIboard : "+ intIboard);
		vo.setIboard(intIboard);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		BoardDAO.updateBoard(vo);
		response.sendRedirect("/detail?iboard="+iboard);
	}
}
