package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;

@WebServlet("/board/mod")
public class ModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
		int iuser = MyUtils.getLoginUserPk(request);
		BoardVO data = BoardDAO.selBoard(intIboard,iuser);
		request.setAttribute("data", data);
		MyUtils.openJsp("board/mod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		System.out.println("ddddd : " + iboard);
		int val = MyUtils.getParamInt("iboard",request);
		System.out.println(MyUtils.parseStringToInt("iboard"));
		System.out.println(MyUtils.getParamInt("iboard",request));
		BoardVO vo = new BoardVO();
		System.out.println(val);
		vo.setIboard(val);
		vo.setTitle(request.getParameter("title"));
		vo.setCtnt(request.getParameter("ctnt"));
		BoardDAO.updateBoard(vo);
		System.out.println("TITLE!!!! : " + vo.getTitle());
		response.sendRedirect("detail?iboard="+iboard);
	}
}
