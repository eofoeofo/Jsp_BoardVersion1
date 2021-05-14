<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="write" method="post">
			<input type="hidden" name="iboard" value="${param.iboard}">
			<div>
				<input type="text" name="title" value="${data.title}">
			</div>
			<div>
				<textarea name="ctnt" >${data.ctnt}</textarea>
			</div>
			<div>
				<input type="submit" value="글쓰기">
				<input type="reset" value="초기화">
			</div>
		</form>
	</div>
</body>
</html>