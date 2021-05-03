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
				<td>체크</td>
			</tr>
			
			<c:forEach items="${list}" var="item">
			<!-- onclick를 사용하는 이유는 한번에 a태그로 감쌀 수 없기 때문입니다 -->
				<tr class="record" onclick="moveToDetail(${item.iboard});"> <!-- 이벤트, 클릭 시 값과 함께 넘어간다 -->
					<td>${item.iboard}</td>
					<td>${item.title}</td>				
					<td>${item.regdt}</td>
				</tr>
					<td>
						<form action="/checkDel" method="get">
							<input type="checkbox" name="iboard?iboard=${param.iboard}">
						</form>
					</td>
			</c:forEach>
		</table>
	</div>
	<div>
		<a href="/checkDel">삭제</a>
	</div>
	<script>
		function moveToDetail(iboard) {
			console.log('iboard : %d',iboard);
			location.href = '/detail3?iboard='+iboard;
		}
	</script>
</body>
</html>