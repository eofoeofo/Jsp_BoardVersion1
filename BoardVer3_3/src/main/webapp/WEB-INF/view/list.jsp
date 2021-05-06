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
	<h1>글쓰기</h1>
	<a href="/signup"><h1>회원가입</h1></a>
	<div>
		<a href="/write">글 작성</a>
	</div>
	<table>
		<tr>
			<td>NO</td>
			<td>제목</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr onclick="moveToDetail(${item.iboard});">
				<td>${item.iboard}</td>
				<td>${item.title}</td>
				<td>${item.regdt}</td>
				<td>${item.cnt}</td>
			</tr>
		</c:forEach>
	</table>
	<script>
		function moveToDetail(iboard) {
			console.log("iboard : %d" + iboard);
			location.href = '/detail?iboard='+iboard;
		}
	</script>
</body>
</html>