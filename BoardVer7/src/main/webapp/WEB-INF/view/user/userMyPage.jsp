<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/res/css/userMyPage.css">
<c:choose>
	<c:when test="${empty sessionScope.loginUser.profileImg}">
		<c:set var="img" value="/res/img/no_profile.jpg"/>	
	</c:when>
	<c:otherwise>
		<c:set var="img" value="/res/img/user/${sessionScope.loginUser.iuser}/${sessionScope.loginUser.profileImg}"/>
	</c:otherwise>
</c:choose>
<div>
	<form id="frm" action="myPage" method="post" enctype="multipart/form-data" onsubmit="return imgChk();">
		이미지 변경 : <input type="file" name="profileImg" accept="image/*">
		<input type="submit" value="이미지 업로드">
	</form>
</div>
<div>
	<div>
		<img src="${img}">
	</div>
	
	<div>
		PK : ${sessionScope.loginUser.iuser}	
	</div>
	
	<div>
		ID : ${sessionScope.loginUser.uid}	
	</div>
	
	<div>
		NAME : ${sessionScope.loginUser.unm}	
	</div>
</div>
<script>
	var frmElem = document.querySelector('#frm');
	function imgChk() {
		if(frmElem.profileImg.files.length === 0){
			alert('이미지를 선택해 주세요.');
			return false;
		}
	}
</script>