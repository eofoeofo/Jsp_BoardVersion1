<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
  table,th,td{
    border: 1px solid black;
    border-collapse: collapse;
  }
  .record { cursor: pointer; }
  .record:hover { background-color: #ecf0f1; }
</style>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<div>
		<a href="/write3">글쓰기</a>
	</div>
	<div>
		<table>
			<tr>
				<td>NO</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
			
			<c:forEach items="${list}" var="item">
				<tr class="record" onclick="moveToDetail(${item.iboard});"> <!-- 이벤트, 클릭 시 값과 함께 넘어간다 -->
					<td>${item.iboard}</td>
					<td>${item.title}</td>				
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script>
		function moveToDetail(iboard) {
			console.log('iboard : %d',iboard);
			location.href = '/detail3?iboard='+iboard;
		}
	</script>
</body>
</html>