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

@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.getLoginUser(request).getIuser();
		
		request.setAttribute("data", BoardDAO.selBoard(MyUtils.getParamInt(request.getParameter("iboard"), request)));
		request.setAttribute("list", CmtDAO.selCmt(MyUtils.getParamInt(request.getParameter("iboard"), request)));
		MyUtils.openJsp("board/detail", request, response);
	}
}