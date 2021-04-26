package com.koreait.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/write.jsp").forward(request, response); 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title"); // name속성값(결국엔 value값)
		String ctnt = request.getParameter("ctnt"); // 1. jsp에서 submit 누르면 jsp에 담아진 값이 여기로 넘어옴
//		클라이언트 에서 넘어 오는건 무조건 request.getParameter(post,get이던 상관없이)! 
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		Database.list.add(vo);
		
//		// 위의 코드와 같
//		List<BoardVO> refList = Database.list;
//		refList.add(vo);
		
		
		response.sendRedirect("/list"); // Get방식의 주소 이동
	}

}
