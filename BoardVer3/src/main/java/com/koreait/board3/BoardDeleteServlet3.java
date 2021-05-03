package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/del3")
public class BoardDeleteServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
		
		BoardVO3 param = new BoardVO3();
		// vo타입의 param을 받는 이유는 dao단에서 만약 컬럼의 추가나 수정이 있을 경우, 객체의 그릇에 담아지기 때문이다.
		// 다이렉트로(intIboard) 받게 된다면 dao의 수정이 빈번하게 일어난다.
		param.setIboard(intIboard);
		BoardDAO.deleteBoard(param);
//		BoardDAO.deleteBoard(intIboard);
		response.sendRedirect("/list3");
	}

}
