<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
  table,th,td{
    border: 1px solid black;
    border-collapse: collapse;
  }
  .record { cursor: pointer; }
  .record:hover { background-color: #ecf0f1; }
</style>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<div>로그인 성공</div>
	<div>${loginUser.unm}님 (${loginUser.uid}) 환영합니다. <a href="/user/logout">LOGOUT</a></div>
	<div>
		<a href="write">글쓰기</a>
	</div>
	<div>
		<table>
			<tr>
				<td>NO</td>
				<td>제목</td>
				<td>작성일자</td>
				<td>작성자</td>
			</tr>
			<c:forEach items="${list}" var="item" > <!-- itmes엔 컬렉션들(arraylist,배열)만 들어올수있다 -->
			<!-- jstl을 안써주면 그냥 문자값이 된다. --> <!-- 페이지컨텍스트에 item이란 이름으로 VO의 객체마다마다 주소값을 가지게된다 -->
			<!-- database의 저장된 값을 그냥 가져오는 단이다. -->
			<tr class="record" onclick="moveToDetail(${item.iboard});">
				<td>${item.iboard}</td>
				<td>${item.title}</td>
				<td>${item.regdt}</td>
				<td>${item.unm}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<script>
		function moveToDetail(iboard) {
			console.log('dd');
			location.href = "/board/detail?iboard="+iboard;
		}
	</script>
</body>
</html>