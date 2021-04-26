<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.koreait.board.*" %>
 <%
 	String no = request.getParameter("no"); //빼낼땐 키 값만 받는다  // 
 	BoardVO vo = (BoardVO) request.getAttribute("data"); // 형변환하는 이유는 object이기 때문에
 	// getAttribute는 setAttribute가 사용됐을때 쓴다.
 %>
 <!--<div><%=request.getParameter("no") %></div>
		<div>${param.no }</div>  EL식 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table>
		<h1>디테일단<%=no %></h1>
		<div>제목 :<%=vo.getTitle() %> </div>
		<div>
			<form action="/del" method="post">
				<input type="hidden" name="no" value="<%=no %>">
				<input type="submit" value="삭제">
			</form>
			
			<!-- <a href="/del?no=<%=no %>"><button>삭제</button></a> 
			GET방식 삭제방법!!!-->
		</div>
		<div><%=vo.getCtnt() %> </div>
		</table>
</body>
</html>