package com.koreait.board4.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
//		Boolean loginSuccess = (Boolean)hs.getAttribute("loginSuccess");
//		System.out.println("loginSuccess : " + loginSuccess);
		// boolean과 같은 기능이고, 대문자로 시작하면 래퍼타입이라고 함
		if (loginUser == null) { // 로그아웃상태
			response.sendRedirect("/user/login");
			return;
		} 
		System.out.println("loginUser : "+loginUser);
		List<BoardVO> list = BoardDAO.boardList();
		request.setAttribute("list", list);
		MyUtils.openJsp("board/list", request, response);
	}
}
