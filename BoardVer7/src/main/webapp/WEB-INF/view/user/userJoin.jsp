<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- on은 이벤트 
    onsubmit은 항상 return이 필요하고, false를 주면 트리거가 작동되지 않는다. -->
    <!-- 
    유일할땐 id, 종복된 여러개를 쓸땐 class
     -->
<form id="frm" action="join" method="post" onsubmit="return frmChk();">
	<div>
		<input type="text" name="uid" placeholder="아이디">
		<input type="button" id="btnChkId" value="ID중복체크">	
	</div>
	<div id="chkUidResult"></div>
	<div>
		<input type="password" name="upw" placeholder="비밀번호">
	</div>
	<div>
		<input type="password" id="chkUpw" placeholder="비밀번호 확인">
	</div>
	<div>
		성별 :
		<label>남<input type="radio" name="gender" value="0" checked></label>
		<label>여<input type="radio" name="gender" value="1"></label>
	</div>
	<div>
		<input type="text" name="unm" placeholder="이름">
	</div>
	<div>
		<input type="submit" value="회원가입">
		<input type="reset" value="초기화">
	</div>
	<script src="/res/js/userJoin.js"></script>
</form>