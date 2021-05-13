package com.koreait.boardsignup.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.boardsignup1.MyUtils;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MyUtils.getLoginUser(request) == null) {
			response.sendRedirect("/user/login");
			return;
		}
		List<BoardVO> list = BoardDAO.boardList();
		request.setAttribute("list", list);
		MyUtils.openJsp("board/list", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
