<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div>
	<form id="cmtFrm" data-iboard="${param.iboard}" onsubmit="return false;">
		<input type="text" id="cmt">
		<input type="button" value="댓글달기" onclick="regCmt();">
	</form>
</div>
<div id="cmtList"></div>

<script src="/res/js/boardDetail.js"></script>