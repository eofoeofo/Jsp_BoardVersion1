<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form action="/signup" method="post" name="userInfo" onsubmit="return checkValue()">
	<table>
		<tr>
			<td id="title">아이디</td>
			<td>
				<input type="text" name="id" maxlength="50" onkeydown="inputIdChk()">
				<input type="button" value="중복확인" onclick="openIdChk()" >
				<input type="hidden" name="idDuplication" value="idUncheck">
			</td>
		</tr>
		<tr>
			<td id="title">비밀번호</td>
			<td>
				<input type="password" name="password" maxlength="50">
			</td>
		</tr>
		<tr>
			<td id="title">비밀번호 확인</td>
			<td>
				<input type="password" name="passwordcheck" maxlength="50">
			</td>
		</tr>
		<tr>
			<td id="title">이름</td>
			<td>
				<input type="text" name="usernm" maxlength="50">
			</td>
		</tr>
		<tr>
			<td id="title">성별</td>
			<td>
				<input type="radio" name="gender" value="남">남
				<input type="radio" name="gender" value="여">여
			</td>
		</tr>
		<tr>
			<td id="title">생일</td>
			<td>
				<input type="text" name="birthyy" maxlength="4" placeholder="년(4자)" size="6">
				<select name="birthmm">
					<option value="">월</option>
					<option value="01">1</option>
					<option value="02">2</option>
					<option value="03">3</option>
					<option value="04">4</option>
					<option value="05">5</option>
					<option value="06">6</option>
					<option value="07">7</option>
					<option value="08">8</option>
					<option value="09">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select>
				<input type="text" name="birthdd" maxlength="2" placeholder="일" size="4">
			</td>
		</tr>
		<tr>
			<td id="title">이메일</td>
			<td>
				<input type="text" name="email1" maxlength="50">@
				<select name="email2">
					<option>naver.com</option>
					<option>daum.net</option>
					<option>gamil.com</option>
					<option>nate.com</option>
				</select>
			</td>
		</tr>
		<tr>
			<td id="title">휴대전화</td>
			<td>
				<input type="text" name="phone">
			</td>
		</tr>
		<tr>
			<td id="title">주소</td>
			<td>
				<input type="text" name="address" size="50">
			</td>
		</tr>
	</table>
	<br>
		<input type="submit" value="가입"/>
		<input type="button" value="취소">
	</form>
	<script>
		function checkValue() {
			if(!document.userInfo.id.value){
				alert("아이디를 입력하세요");
				return false;
			} 
			if(!document.userInfo.password.value){
				alert("비밀번호를 입력하세요");
				return false;
			}
			if(document.userInfo.password.value != document.userInfo.passwordcheck.value){
				alert("비밀번호를 동일하게 입력하세요.");
				return false;
			}
			if(form.idDuplication.value != "idCheck"){
				alert("아이디 중복 체크를 해 주세요.");
				return false;
			}
		}
		function openIdChk() {
			window.name = "parentForm";
			window.open('/chk',
						"chkForm", "width=500, height=300, resizable=no,scrollbars=no");
		}
		function inputIdChk() {
			documnet.userInfo.idDuplication.value = "idUncheck";
		}
	</script>
</body>
</html>