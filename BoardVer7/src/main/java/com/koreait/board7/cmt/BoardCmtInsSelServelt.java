package com.koreait.board7.cmt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board7.MyUtils;

@WebServlet("/board/cmtInsSel")
public class BoardCmtInsSelServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		System.out.println("iboard : " + iboard);
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		List<BoardCmtDomain> list = BoardCmtDAO.selBoardCmtList(param);
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println("json : " + json);
		response.getWriter()
		.append(json);
	}

	// 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(MyUtils.getParamInt("iboard", request));
		param.setIuser(MyUtils.getLoginUserPk(request));
		param.setCmt(request.getParameter("cmt"));
		int result = BoardCmtDAO.insBoardCmt(param);
		// 응답처리부분
		response.getWriter()
		.append("{")
		.append("\"result\":")
		.append(String.valueOf(result))
		.append("}");
	}
}