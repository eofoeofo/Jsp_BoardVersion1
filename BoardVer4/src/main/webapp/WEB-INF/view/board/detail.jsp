<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제목</title>
</head>
<body>
	<div><a href="list">리스트</a></div>
	<c:if test="${loginUser.iuser == data.iuser }">
	<div>
		<a href="/del?iboard=${param.iboard}">삭제</a>
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
	<div>
		작성일자 : ${data.regdt}
	</div>
</body>
</html>