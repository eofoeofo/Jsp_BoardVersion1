package com.koreait.board3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail3")
public class BoardDetailServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		System.out.println("iboard : "+iboard);
		
		int intIboard = Integer.parseInt(iboard); // 실제 값은 정수형 이기에 형변환
		
		BoardVO3 data = BoardDAO.selBoard(intIboard); // 객체명이 list가 붙어잇다는건
		request.setAttribute("data",data);
		
		request.getRequestDispatcher("/WEB-INF/view/detail3.jsp").forward(request, response);
	}
}
