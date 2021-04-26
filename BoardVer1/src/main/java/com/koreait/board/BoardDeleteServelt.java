package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardDeleteServelt
 */
@WebServlet("/del")
public class BoardDeleteServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("no");
		
		
		BoardVO vo = new BoardVO();
		
//		Database.list.remove(vo);
		
		request.setAttribute("data", Database.list.remove(Integer.parseInt(no)));
		System.out.println("no!! : " + no);
		response.sendRedirect("/list");
	}

}
