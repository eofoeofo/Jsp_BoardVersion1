package com.koreait.boardsignup1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.boardsignup.user.UserVO;

public class MyUtils {
	// 사용자의 세션을 가져오는 메소드
	public static UserVO getLoginUser(HttpServletRequest request) {
		if(request == null) { return null; }
		HttpSession hs = request.getSession();
		return (UserVO)hs.getAttribute("loginUser");
	}
	
	// 사용자의 Pk를 가져오는 메소드
	public static int getLoginUserPk(HttpServletRequest request) {
		return getLoginUser(request).getIuser();
	}
	
	// 파싱된 값을 전달하는 메소드
	public static int getParamInt(String key, HttpServletRequest request) {
		String val = request.getParameter(key);
		return parseStringToInt(val);
	}
	
	// 문자값을 정수로 파싱하는 메소드
	public static int parseStringToInt(String val) {
		try {
		return Integer.parseInt(val);
		} catch(Exception e) {
			return 0;
		}
	}
	
	// RequestDispatcher와 forward를 처리하는 메소드
	public static void openJsp(String fileNm, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/view/" + fileNm + ".jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
}