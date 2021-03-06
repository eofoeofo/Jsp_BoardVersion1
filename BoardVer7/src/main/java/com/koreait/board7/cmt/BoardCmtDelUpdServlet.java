package com.koreait.board7.cmt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board7.MyUtils;

@WebServlet("/board/cmtDelUpd")
public class BoardCmtDelUpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardCmtEntity param = new BoardCmtEntity();
		int icmt = MyUtils.getParamInt("icmt", request);
		
		param.setIcmt(icmt);
		param.setIuser(MyUtils.getLoginUserPk(request));
		
		int result = BoardCmtDAO.delBoardCmt(param);
		
		response.getWriter()
		.append("{")
		.append("\"result\":")
		.append(String.valueOf(result))
		.append("}")
		.flush();
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardCmtEntity param = new BoardCmtEntity();
		int icmt = MyUtils.getParamInt("icmt", request);
		String cmt = request.getParameter("cmt");
		param.setIcmt(icmt);
		param.setCmt(cmt);
		param.setIuser(MyUtils.getLoginUserPk(request));
		int result = BoardCmtDAO.updBoardCmt(param);
		Gson gson = new Gson();
		String json = gson.toJson(result);
		response.setCharacterEncoding("UTF-8");
		response.getWriter()
		.append(json);
		
		System.out.println("result : " + result);
		System.out.println("icmt : " + icmt);
		System.out.println("cmt : " + cmt);
	}
}
