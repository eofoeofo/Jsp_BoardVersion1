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
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request);
		BoardVO fav = BoardDAO.selBoard(iboard, iuser);
		request.setAttribute("data", fav);
		request.setAttribute("list", CmtDAO.selCmt(MyUtils.getParamInt("iboard", request)));
		MyUtils.openJsp("board/detail", request, response);
	}
}