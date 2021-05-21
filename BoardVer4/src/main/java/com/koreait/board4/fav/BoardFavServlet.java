package com.koreait.board4.fav;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;

@WebServlet("/board/fav")
public class BoardFavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request);
		
		switch(MyUtils.getParamInt("fav", request)) {
		case 0:
			FavDAO.delFav(iboard, iuser);
			break;
		case 1:
			FavDAO.insFav(iboard, iuser);
			break;
		}
		response.sendRedirect("detail?iboard="+iboard);
	}
}