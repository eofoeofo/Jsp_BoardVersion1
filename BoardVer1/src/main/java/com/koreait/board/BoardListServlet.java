package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//서블릿에서 jsp로 값 전달 하기
		request.setAttribute("data", Database.list);
		
		// list.jsp 파일을 열거야
		
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request,response);
	}

}
