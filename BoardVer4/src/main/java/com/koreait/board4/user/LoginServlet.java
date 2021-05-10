package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJsp("user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO vo = new UserVO();
		vo.setUid(request.getParameter("uid"));
		vo.setUpw(request.getParameter("upw"));
		
		int result = UserDAO.loginUser(vo);
		System.out.println("result : " + result);
		switch(result) {
		case 1:
			response.sendRedirect("/board/list");
			break;
		default:
			doGet(request,response); // 로그인 실패(1이 아닐 때)시 다시 get으로 이동
//			response.sendRedirect("login"); // 로그인 실패시 다시 login으로 이동(doget호출과 이것 중 한개만 써야함)
			//리다이렉트로 get으로 다시 갈 경우 값이 초기화 된 채로 가기때문에 쿼리스트링으로 보내줘야함.
			break;
		}
	}
}
