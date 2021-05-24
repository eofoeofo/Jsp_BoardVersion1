package com.koreait.board7.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJsp("회원가입", "user/userJoin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserEntity vo = new UserEntity();
		vo.setUid(request.getParameter("uid"));
		vo.setUpw(request.getParameter("upw"));
		vo.setUnm(request.getParameter("unm"));
		vo.setGender(MyUtils.getParamInt("gender", request));
		System.out.println("uid : " + vo.getUid());
		System.out.println("upw : " + vo.getUpw());
		System.out.println("unm : " + vo.getUnm());
		System.out.println("gender : " + vo.getGender());
	}
}