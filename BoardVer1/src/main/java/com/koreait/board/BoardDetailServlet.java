package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// set담고,get빼고..
	//getParameter, 브라우저에서부터 담긴값들을 빼낼 때 쓴다!!
	//서블릿,jsp에서도 사용 가능!
	
	//getAttribute, 내가 담고 내가 빼낼 때? 서블렛->jsp요청은 가능!!! jsp->서블렛은 안됨
	// 단방향
	//request.setAttribute(키값,value);
	//request.getAttribute(키값);
	// 뭔가 jsp에게 정보를 보내고 싶을때, set,getAttribute를 사용한다!
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no"); // 값을 받을때 쓴다;
		System.out.println("no : " + no);
		request.setAttribute("data", Database.list.get(Integer.parseInt(no)));// value에 한 값만 담을수 있음
		// setAttribute의 값이 jsp로 넘어간다
		// 1.하드코딩이 아니라면은 무조건 써야함;(전달기능)->request로 담고,
		// Database.list는 
		// .get(인덱스값),정수형
		// .add(넣는값),제네릭에 따라 변경,제네릭 안쓰면 오브젝트라서 아무거나 ㅇㅋ
		// .size(?)
		
		request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request,response);
		// 2.담아진 값을 forward를 이용해서 jsp로 이동한다
	}

}
