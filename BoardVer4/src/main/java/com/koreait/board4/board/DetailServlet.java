package com.koreait.board4.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.cmt.CmtDAO;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.getLoginUser(request).getIuser();
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
		
		BoardVO data = BoardDAO.selBoard(intIboard);
		System.out.println("intIboard : " + intIboard);
		request.setAttribute("data", data);
		request.setAttribute("list", CmtDAO.selCmt(intIboard));
		MyUtils.openJsp("board/detail", request, response);
	}
}