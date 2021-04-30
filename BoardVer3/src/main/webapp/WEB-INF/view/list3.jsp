<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
  table {
    width: 100%;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
  }
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
				<tr>
					<td>${item.iboard}</td>
					<td>${item.title}</td>				
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>