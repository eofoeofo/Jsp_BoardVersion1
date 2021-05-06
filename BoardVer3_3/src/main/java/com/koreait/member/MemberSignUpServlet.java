package com.koreait.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberSignUpServlet
 */
@WebServlet("/signup")
public class MemberSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/userview/signUp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SignUpVO vo = new SignUpVO();
		vo.setId(request.getParameter("id"));
		vo.setUserpwd(request.getParameter("password"));
		vo.setUsernm(request.getParameter("usernm"));
		vo.setGender(request.getParameter("gender"));
		vo.setBirthyy(request.getParameter("birthyy"));
		vo.setBirthmm(request.getParameter("birthmm"));
		vo.setBirthdd(request.getParameter("birthdd"));
		vo.setEmail1(request.getParameter("email1"));
		vo.setEmail2(request.getParameter("email2"));
		vo.setPhone(request.getParameter("phone"));
		vo.setAddress(request.getParameter("address"));
		MemberDAO.insertMember(vo);
		response.sendRedirect("/list");
	}
}
