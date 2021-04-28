<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/write">글쓰기</a>
	<%--EL식이 있다는건 내장객체다 var는 pageContext 값이 박힐 키값. --%>
	<c:forEach var="i" begin="1" end="5"> <%-- end="종료값" --%>
	<div>${i}</div>
	</c:forEach>
	<table>
	<tr>
		<td>NO</td>
		<td>제목</td>
	</tr>
	<c:forEach var="item" items="${list}" varStatus="status"> <%--varStatus는 인덱스 값! --%>
	<tr>
		<td>${status.count}</td>
		<td><a href="/detail?no=${status.index}">${item.title}</a></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>