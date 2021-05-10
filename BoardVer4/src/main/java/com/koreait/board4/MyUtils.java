package com.koreait.board4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static int getParamInt(String key, HttpServletRequest request) {
			String val = request.getParameter("key");
			int intVal = MyUtils.parseStringToInt(val);
			return intVal;
	}
	public static int parseStringToInt(String val) { // 호출할 땐 String, 리턴될 값은 int
		try {
			return Integer.parseInt(val);
		} catch(Exception e) {
			return 0;
		}
	}
	public static void openJsp(String fileNm, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/view/" + fileNm + ".jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
}
