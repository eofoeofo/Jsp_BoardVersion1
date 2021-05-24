package com.koreait.board6.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board6.MyUtils;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJsp("디테일", "board/boardDetail", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		System.out.println("iboard : " + iboard);
		response.setCharacterEncoding("UTF-8");
		BoardVO vo = new BoardVO();
		vo.setIboard(iboard);
		BoardVO result = BoardDAO.selBoard(iboard);
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		String json = gson.toJson(result);
		System.out.println(json);
		pw.append(json);
//		pw.append("{\"iboard\":")
//		.append(String.valueOf(result.getIboard()))
//		.append(",\"title\":")
//		.append("\"")
//		.append(result.getTitle())
//		.append("\", \"ctnt\": \"")
//		.append(result.getCtnt())
//		.append("\"}")
//		;
//		System.out.println(pw);
//		{"iboard" : 28, "title" : "안녕", "ctnt":"반갑습니다."}
	}
}