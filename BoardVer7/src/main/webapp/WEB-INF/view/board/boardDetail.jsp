<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/res/css/boardDetail.css">
<div>
	<a href="#" onclick="goBack();">돌아가기</a>
</div>
<h1>${data.title}</h1>
<div>
	글번호 : ${data.iboard}
</div>
<div>
	작성자 : ${data.writerNm} | 작성일 : ${data.regdt}
</div>
<div>
	<c:out value="${data.ctnt}"/>
</div>
<c:if test="${not empty sessionScope.loginUser}">
	<div>
		<form id="cmtFrm" onsubmit="return false;">
			<input type="text" id="cmt">
			<input type="button" value="댓글달기" onclick="regCmt();">
		</form>
	</div>
</c:if>
<div id="cmtList" data-login_user_pk="${sessionScope.loginUser.iuser}" data-iboard="${param.iboard}"></div>

<div id="modal" class="displayNone">
	<div class="modal_content">
		<form id="cmtUpdFrm" action="#"> <!-- return false;와 같은 기능 -->
			<input type="hidden" id="icmt">
			<input type="text" id="cmt">
		</form>
		<input type="button" value="댓글 수정" onclick="updAjax();">
		<input type="button" value="취소" onclick="closeUpdModal();">
	</div>
</div>

<script src="/res/js/boardDetail.js"></script>