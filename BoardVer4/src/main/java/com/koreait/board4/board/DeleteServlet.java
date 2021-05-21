package com.koreait.board4.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;

@WebServlet("/del")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
		int iuser = MyUtils.getLoginUserPk(request);
		BoardVO vo = BoardDAO.selBoard(intIboard,iuser);
		vo.setIboard(intIboard);
//		int iuser = vo.getIuser();
//		
//		System.out.println("iuser 값 : "+ iuser);
		
//		HttpSession hs = request.getSession();
//		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
//		hs.setAttribute("loginUser", vo);
//		
//		System.out.println("loginuser !!!! :" + loginUser.getIuser());
//		System.out.println("GETUID !!!! :" + loginUser.getUid());
		
		BoardDAO.deleteBoard(vo);
//		System.out.println(loginUser.getIuser() == vo.getIuser());
		
		response.sendRedirect("/board/list");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
