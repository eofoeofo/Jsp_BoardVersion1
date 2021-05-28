package com.koreait.board7.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDTO param = new BoardDTO();
		final int recordCnt = 5;
		int cPage = MyUtils.getParamInt("cPage", request);
		if(cPage == 0) {
			cPage = 1;
		}
		int startIdx = (cPage - 1) * recordCnt; 
		param.setStartIdx(startIdx);
		param.setRecordCnt(recordCnt);
		
		int searchType = MyUtils.getParamInt("searchType", request);
		String searchText = request.getParameter("searchText");
		// select박스 선택이 되었고, 값이 null이 아니고, 공백이 아닌 무언가가 입력이 되었을 때
		if(searchType != 0 && searchText != null && !searchText.equals("")) {
			param.setSearchType(searchType);
			param.setSearchText(searchText);
		}
		request.setAttribute("pagingCnt", BoardDAO.selPagingCnt(param));
		request.setAttribute("list", BoardDAO.selBoardList(param));
		MyUtils.openJsp("리스트", "board/boardList", request, response);
	}
}