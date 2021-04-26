<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.koreait.board.*" %>
 <%
 	List<BoardVO> list = (List<BoardVO>) request.getAttribute("data"); //빼낼땐 키 값만 받는다
 	// 형변환 해주는 이유는 setAttribute로 설정한 값을 getAttribute로 받을 때 무슨 타입인지 모른다.
 	// 그래서 object로 받고, object로 받으면 Arraylist의 기능을 쓸 수 없게됨(add,get,size)
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
	table, th, td {
		border: 1px solid black;
		border-collaspse: collapse;
		}
</style>
</head>
<body>
	<h1>리스트</h1>
	<div>
		<a href="/write">글쓰기</a>
	</div>
	
	<div>
		<table>
			<tr>
				<th>NO</th>
				<th>제목</th>
			</tr>
			<% 
				for(int i=0; i<list.size(); i++) {
					BoardVO vo = list.get(i);
			%>
			<tr>
				<td><%=i %></td>
				<td><a href="/detail?no=<%=i %>">
				<%=vo.getTitle() %></a></td>
			</tr>
			<% } %>
		</table>
	</div>
</body>
</html>
