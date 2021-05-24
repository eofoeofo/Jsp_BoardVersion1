package com.koreait.board6.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board6.MyUtils;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJsp("회원가입", "user/userJoin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String unm = request.getParameter("unm");
		int gender = MyUtils.getParamInt("gender", request);
		
		System.out.println("uid : " + uid);
		System.out.println("upw : " + upw);
		System.out.println("unm : " + unm);
		System.out.println("gender : " + gender);
		
		int result = 1;
		//response에서 Writer를 얻어온다.
		PrintWriter pw = response.getWriter();
		// 안의 내용을 문자열로 만들어준다? 
		pw.append(String.format("{\"result\": %d}", result));
	}
}