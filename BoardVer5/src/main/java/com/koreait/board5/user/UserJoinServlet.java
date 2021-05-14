package com.koreait.board5.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board5.MyUtils;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJsp("user/userJoin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO vo = new UserVO();
		
		vo.setUid(request.getParameter("uid"));
		vo.setUpw(BCrypt.hashpw(request.getParameter("upw"), BCrypt.gensalt()));
		vo.setUnm(request.getParameter("unm"));
		vo.setGender(MyUtils.getParamInt(request.getParameter("gender"), request));
		System.out.println("id : " + vo.getUid());
		System.out.println("pw : " + vo.getUpw());
		UserDAO.joinUser(vo);
		response.sendRedirect("/user/login");
	}
}
