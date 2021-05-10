package com.koreait.board3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list3")
public class BoardListServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVO3> list = BoardDAO.selBoardList(); //arrayList 객체 주소값 
		// 인자값이 없다는 건 t_board를 다 가지고 오겠다는 뜻(인자값이 있으면 특정한 어느 것을 가지고 오는것)
		request.setAttribute("list", list);
//		String jsp = "/WEB-INF/view/list3.jsp";
		MyUtils.openJsp("list3", request, response); 
		// exception오류는 list서블렛의 throws와 MyUtils(throws자식개념)이 같은 throws를 가져야한다?
		// ( 오버라이딩이기 떄문이다. 오버라이딩은 throws도 똑같아야함)
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
