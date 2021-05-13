package com.koreait.boardsignup.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.boardsignup1.MyUtils;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MyUtils.getLoginUser(request) != null) {
			response.sendRedirect("/board/list");
			return;
		}
		MyUtils.openJsp("user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO vo = new UserVO();
		vo.setUid(request.getParameter("uid"));
		vo.setUpw(request.getParameter("upw"));
		int result = UserDAO.loginUser(vo);
		
		if(result == 1) {
			HttpSession hs = request.getSession();
			vo.setUpw(null);
			hs.setAttribute("loginUser", vo);
			response.sendRedirect("/board/list");
			return;
		}
		String errMsg = null;
		switch(result) {
		case 0:
			errMsg = "에러가 발생하였습니다.";
			break;
		case 2:
			errMsg = "아이디를 확인 해 주세요.";
			break;
		case 3:
			errMsg = "비밀번호를 확인 해 주세요";
			break;
		}
		request.setAttribute("errMsg", errMsg);
		doGet(request, response);
	}
}