<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<div class="errMsg">${errMsg}</div>
		<div>
			<form action="login" method="post">
				<div><input type="text" name="uid" placeholder="아이디" value="aaa"></div>
				<div><input type="password" name="upw" placeholder="비밀번호" value="123"></div>
				<div>
					<input type="submit" value="Login">
				</div>
			</form>
		</div>
	<div>
		<a href="join">회원가입</a>
	</div>
</div>
