<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<div><a href="/list">리스트</a></div>
	<div>${param.iboard}</div>
	<form action="mod" method="post">
		<input type="hidden" name="iboard" value="${param.iboard}">
			<div>
				제목 : <input type="text" name="title" value="${data.title }">
			</div>
			<div>
				내용 : <textarea name="ctnt" >${data.ctnt }</textarea>
			</div>
			<div>
			<input type="submit" value="등록">
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>