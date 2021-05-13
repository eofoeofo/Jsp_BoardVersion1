package com.koreait.boardsignup.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.boardsignup1.MyUtils;

@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJsp("user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO vo = new UserVO();
		vo.setUid(request.getParameter("uid"));
		vo.setUpw(BCrypt.hashpw(request.getParameter("upw"), BCrypt.gensalt()));
		vo.setUnm(request.getParameter("unm"));
		vo.setGender(MyUtils.getParamInt("gender", request));
		UserDAO.joinUser(vo);
		response.sendRedirect("login");
	}
}
