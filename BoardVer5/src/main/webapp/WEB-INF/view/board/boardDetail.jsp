<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제목</title>
<script defer src="/res/js/boardDetail.js"></script>
<link rel="stylesheet" 
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
	.hidden { display: none; }
	.fa-heart { color: red; }
</style>
</head>
<body>
	<div><a href="list">리스트</a></div>
	<c:if test="${loginUser.iuser == data.iuser }">
	<div>
		<a href="del?iboard=${param.iboard}">삭제</a>
		<a href="mod?iboard=${param.iboard}">수정</a>
	</div>
	</c:if>
	<h1>
		디테일 페이지
		<c:if test="${data.isFav eq 0}">
			<a href="fav?iboard=${param.iboard}&fav=1"><i class="far fa-heart"></i></a>
		</c:if>
		<c:if test="${data.isFav eq 1}">
			<a href="fav?iboard=${param.iboard}&fav=0"><i class="fas fa-heart"></i></a>
		</c:if>
	</h1>
	<div>유저 pk : ${data.iuser} 작성자 : ${data.unm}</div>
	<div>
		제목 : ${data.title}
	</div>
	<div>
		내용 : ${data.ctnt}
	</div>
	
	<h3>댓글</h3>
	<div>
		<form id="insFrm" action="cmt" method="post">
			<input type="hidden" name="icmt" value="0">
			<input type="hidden" name="iboard" value="${data.iboard}">		
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글작성">
			</div>
		</form>
		
		<form id="updFrm" action="cmt" method="post" class="hidden">
			<input type="hidden" name="icmt" value="0">
			<input type="hidden" name="iboard" value="${data.iboard}">		
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글수정">
				<input type="button" value="수정취소" onclick="showInsFrm();">
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
						<input type="button" value="수정" 
						onclick="updCmt(${item.icmt},'${item.cmt.trim()}')">
						<!-- cmt를 따옴표로 감싸주는이유는 문자열이라서. -->
						<!-- 댓글의 엔터가 들어가면 에러가나는데 꼼수 trim()으로 엔터공백을 잘라버리면 해결은된다.. -->
						<button onclick="delCmt(${data.iboard},${item.icmt});">삭제</button>
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