package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		if (loginUser != null) { // 로그인이 되어 있다면 로그인 페이지로 이동 불가
			response.sendRedirect("/board/list");
			return; // 리턴은 필수! 왜냐면 sendRedirect와 forward가 두개 동시에 실행되면 에러나니까요
		} 
		
		System.out.println("LOGIN - request : "+ request.hashCode());
		System.out.println("LOGIN - hs : " + hs.hashCode());
		MyUtils.openJsp("user/userLogin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserVO vo = new UserVO();
		vo.setUid(request.getParameter("uid"));
		vo.setUpw(request.getParameter("upw"));

		int result = UserDAO.loginUser(vo); // vo객체의 주소값을 인자로 받아서 loginUser메소드의 매개변수로 주소값 전달(복사) 
		System.out.println("result : " + result);
		if (result == 1) {
			// 로그인이 성공한다면 session얻어도고,
			HttpSession hs = request.getSession();
			vo.setUpw(null); // Upw를 지우는 행위임
			System.out.println("id" + vo.getUid());
			System.out.println("nm" + vo.getUnm());
			hs.setAttribute("loginUser", vo);// hs의 loginSuccess에 true을 준것
			// vo가 가르키는 UserVO객체에는 iUser,uid,unm 값만 담고있다.
			
			response.sendRedirect("/board/list");
			return;
		}
		String errMsg = null;
		switch (result) {
		case 0:
			errMsg = "에러가 발생하였습니다.";
			break;
		case 2:
			errMsg = "아이디를 확인 해 주세요";
			break;
		case 3:
			errMsg = "비밀번호를 확인 해 주세요";
			break;
		}
		request.setAttribute("errMsg", errMsg);
		doGet(request, response); // 로그인 실패(1이 아닐 때)시 다시 get으로 이동
//			response.sendRedirect("login"); // 로그인 실패시 다시 login으로 이동(doget호출과 이것 중 한개만 써야함)
		// 리다이렉트로 get으로 다시 갈 경우 값이 초기화 된 채로 가기때문에 쿼리스트링으로 보내줘야함.
	}
}
