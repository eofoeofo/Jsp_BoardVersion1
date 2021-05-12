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

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJsp("board/write", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		System.out.println("title : " + title);
		System.out.println("ctnt : " + ctnt);
		BoardVO vo = new BoardVO();
		
		// 사용자 pk값 가져오는 법!!
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		int iuser = loginUser.getIuser();
		
		int iuserPk = MyUtils.getLoginUserPk(request);
		System.out.println("iuserPk" + iuserPk);
		// PK값을 html에서 (얻어오는게아니라)hidden name으로 처리하게되면, 실행은 되지만, pk값이 모두에게 노출되기 때문에 조심해야한다.
		
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		vo.setIuser(iuser);
		System.out.println("iuser : " + iuser);
		BoardDAO.insBoard(vo);
		response.sendRedirect("list");
	}
}
