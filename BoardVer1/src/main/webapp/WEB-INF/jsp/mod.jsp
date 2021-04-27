<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.koreait.board.*" %>
<%
 	String no = request.getParameter("no"); //빼낼땐 키 값만 받는다  // 
 	BoardVO vo = (BoardVO)request.getAttribute("data"); // 형변환하는 이유는 object이기 때문에
 	
 	// getAttribute는 setAttribute가 사용됐을때 쓴다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<h1>글수정</h1>
	<!-- action은 폼태그 안에 있는 값?들을 가지고 갈 경로 --> 
	<form action ="/mod" method="post"> <!-- submit을 누르면 /write에 post방식으로 넘어감 -->
		<input type="hidden" name="no" value="<%=no%>">
		<div>
		<div><%=vo.getTitle() %></div>
			제목 : <input type="text" name="title" value="<%=vo.getTitle() %> "><!-- name은 key값  -->
		</div>
		<div>
			내용 : <textarea name="ctnt" rows="10" cols="10"><%=vo.getCtnt() %></textarea>
		</div>
		<div>
			<input type="submit" value="글수정">
		</div>
	</form>
</body>
</html>