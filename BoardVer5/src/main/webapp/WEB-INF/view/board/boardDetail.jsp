<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제목</title>
<script defer src="/res/js/boardDetail.js"></script>
</head>
<body>
	<div><a href="list">리스트</a></div>
	<c:if test="${loginUser.iuser == data.iuser }">
	<div>
		<a href="del?iboard=${param.iboard}">삭제</a>
		<a href="mod?iboard=${param.iboard}">수정</a>
	</div>
	</c:if>
	<div>디테일 페이지</div>
	<div>유저 pk : ${data.iuser} 작성자 : ${data.unm}</div>
	<div>
		제목 : ${data.title}
	</div>
	<div>
		내용 : ${data.ctnt}
	</div>
	
	<h3>댓글</h3>
	<div>
		<form action="cmt" method="post">
			<input type="hidden" name="iboard" value="${data.iboard}">		
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글작성">
			</div>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>
			</tr>
			<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.cmt}</td>
				<td>${item.unm}</td>
				<td>${item.regdate}</td>
				<td>
					<c:if test="${loginUser.iuser == item.iuser }">
						<input type="button" value="수정">
						<!-- <a href="cmt?icmt=${item.icmt}&iboard=${requestScope.data.iboard}"> -->
						<button onclick="delCmt(${data.iboard},${item.icmt});">삭제</button></a>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		작성일자 : ${data.regdt}
	</div>
</body>
</html>