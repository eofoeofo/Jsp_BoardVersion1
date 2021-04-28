package com.korea.board2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class BoardDetailServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		int intNo = Integer.parseInt(no);
		
		List<BoardVO> list = Database.db; // 21번을 풀어쓴 것 
		BoardVO vo = Database.db.get(intNo); // Database는 정수형인데 여기선 스트링이라 에러가 남
		
		request.setAttribute("vo", vo);
		
		request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response); 
	}

}
