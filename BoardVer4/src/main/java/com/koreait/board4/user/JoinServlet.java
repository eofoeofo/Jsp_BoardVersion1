package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;

@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJsp("user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO vo = new UserVO();
		int gender = MyUtils.getParamInt("gender", request);
		
		vo.setUid(request.getParameter("uid"));
		vo.setUpw(request.getParameter("upw"));
		vo.setUnm(request.getParameter("unm"));
		vo.setGender(gender);
		UserDAO.joinUser(vo);
		response.sendRedirect("login"); // 애초에 슬러시를 붙이지 않으면 1차주소 값은 유지됨
	}

}
