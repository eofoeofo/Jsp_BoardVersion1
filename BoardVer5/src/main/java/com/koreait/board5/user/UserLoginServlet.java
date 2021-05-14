package com.koreait.board5.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board5.user.UserVO;
import com.koreait.board5.MyUtils;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MyUtils.getLoginUser(request) != null) {
			response.sendRedirect("/board/list");
			return;
		}
		MyUtils.openJsp("user/userLogin", request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO vo = new UserVO();
		vo.setUid(request.getParameter("uid"));
		vo.setUpw(request.getParameter("upw"));
		UserVO result = UserDAO.selUser(vo);
		if(result == null) { // 아이디 없는 경우
			request.setAttribute("errMsg", "아이디를 확인 해 주세요.");
		} else if(BCrypt.checkpw(request.getParameter("upw"),result.getUpw())) { 
			// 아이디 있는 경우
			result.setUpw(null);
			HttpSession hs = request.getSession();
			hs.setAttribute("loginUser", result); // loginUser란 키 값으로 UserDAO에 담았다.
			response.sendRedirect("/board/list");
			return;
		} else { // 비밀번호 틀린 경우
			request.setAttribute("errMsg", "비밀번호를 확인 해 주세요.");
		}
		doGet(request,response);
	}
}