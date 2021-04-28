<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정하기</h1>
	<div><a href="/list">돌아가기</a></div>
	
	<form action="/mod" method="post" >
	<input type="hidden" name="no" value="${param.no}">
		<div>
			제목 : <input type="text" name="title" value="${vo.title}">
		</div>
		<div>
			내용 : <textarea name="ctnt" rows="10" cols="10">${vo.ctnt}</textarea>
		</div>
		<div>
			<input type="submit" value="수정하기">
		</div>
	</form>
</body>
</html>