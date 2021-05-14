<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<div>로그인 성공하셨습니다</div>
	<div>${loginUser.unm}님 (${loginUser.uid})환영합니다!</div>
	<div>
		<a href="write">글쓰기</a> <a href="/user/logout">LOGOUT</a>
	</div>
	<div>
		<table>
			<tr>
				<td>NO</td>
				<td>제목</td>
				<td>작성일자</td>
				<td>작성자</td>
			</tr>
			<c:forEach items="${list}" var="item">
			<tr class="record" onclick="moveToDetail(${item.iboard});">
				<td>${item.iboard}</td>
				<td>${item.title}</td>
				<td>${item.regdt}</td>
				<td>${item.unm}</td>
			</c:forEach>
		</table>
	</div>
	<script>
		function moveToDetail(iboard) {
			location.href="/board/detail?iboard="+iboard;
		}
	</script>
</body>
</html>