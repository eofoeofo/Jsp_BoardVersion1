package com.koreait.board6;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board6.user.UserVO;

public class MyUtils {
	public static UserVO getLoginUser(HttpServletRequest request) {
		if(request == null) { return null; }
		HttpSession hs = request.getSession();
		return (UserVO)hs.getAttribute("loginUser");
	}
	
	public static int getLoginUserPk(HttpServletRequest request) {
		return getLoginUser(request).getIuser();
	}
	
	public static int getParamInt(String key, HttpServletRequest request) {
			String val = request.getParameter(key);
			int intVal = parseStringToInt(val);
			return intVal;
	}
	public static int parseStringToInt(String val) { // 호출할 땐 String, 리턴될 값은 int
		try {
			return Integer.parseInt(val);
		} catch(Exception e) {
			return 0;
		}
	}
	
	public static void openJsp(String title, String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(Const.TITLE, title);
		request.setAttribute(Const.PAGE, page);
		
		String jsp = "/WEB-INF/view/template.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
}
