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
		String no = request.getParameter("no"); // 값을 받을때 쓴다;
		System.out.println("no : " + no);
		request.setAttribute("data", Database.list.get(Integer.parseInt(no)));
		request.getRequestDispatcher("/WEB-INF/jsp/mod.jsp").forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("no");
		String title = request.getParameter("title"); // name속성값(결국엔 value값)
		String ctnt = request.getParameter("ctnt"); // 1. jsp에서 submit 누르면 jsp에 담아진 값이 여기로 넘어옴
//		클라이언트 에서 넘어 오는건 무조건 request.getParameter(post,get이던 상관없이)! 
		System.out.println("title : "+title);
		System.out.println("ctnt : "+ctnt);
		BoardVO vo = Database.list.get(Integer.parseInt(no));
		vo.setTitle(title); // 
		vo.setCtnt(ctnt);
//		request.setAttribute("data", Database.list.get(Integer.parseInt(title)));
//		request.setAttribute("data", Database.list.get(Integer.parseInt(ctnt)));
		
		response.sendRedirect("/detail?no="+no);
	}

}
