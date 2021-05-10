package com.koreait.board3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static int parseStringToInt(String strNum) {
		try {
			return Integer.parseInt(strNum);
		} catch(Exception e) {
			return 0;
		}
		// try catch를  쓰는 이유는 문자열을 파싱할 땐 에러가 안나지만, 문자열과 숫자가 섞인것을 파싱할 때
		// 에러가 나기 때문에 try catch를 하는거다.
		// 에러가 나면 0이 나올거임
	}
	public static int getParamInt(String iboard, HttpServletRequest request) {
		String strVal= request.getParameter(iboard);
		int intVal = parseStringToInt(strVal);
		return intVal;
		
//		return parseStringToInt(request.getParameter(strVal)); 한줄로 줄이기 가능
	}
	
	// 멤버 필드 없으면 걍 static붙이셈
	public static void openJsp(String fileNm, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/view/" + fileNm + ".jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		// throws에 forward에서 했기 때문에 빨간줄 뜸
	}
}
