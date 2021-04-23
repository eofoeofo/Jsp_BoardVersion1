<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글쓰기</h1>
	<!-- action은 폼태그 안에 있는 값?들을 가지고 갈 경로 --> 
	<form action ="/write" method="post">
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			내용 : <textarea name="ctnt" rows="10" cols="10"></textarea>
		</div>
		<div>
			<input type="submit" value="글쓰기">
		</div>
	</form>

</body>
</html>