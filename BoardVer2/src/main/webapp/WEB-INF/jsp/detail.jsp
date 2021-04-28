<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String name = "홍길동";
	pageContext.setAttribute("name","A");
	request.setAttribute("name","B");
	session.setAttribute("name","C");
	application.setAttribute("name","D");
%>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
<%--  스크립트릿 안 쓰고 EL식으로 ! ${키값.주소값} 여기서 vo는 서블릿의 키값을 써야한다! 
	  EL식은 4개의 내장객체로 setAttribute 된 것만 쓸수있다. 자바처럼 변수찍는게 아니야  
	  4개의 내장 객체중 만약 name값이 같은 경우에 EL식으로 불러온다면, 우선순위가 높은것만 부른다! 마치 if-else처럼--%>
	<%--<div>내장객체 : ${ name}</div>--%>
	<div>쿼리스트링 받는 법 : EL식 + param.no ${param.no}</div>
	<div>제목 : ${vo.title}</div>
	<div>${vo.ctnt}</div>
	<div>
		<form action="/del" method="post">
			<input type="hidden" name="no" value="${param.no}">
			<input type="submit" value="삭제">
		</form>
		<a href="/mod?no=${param.no}"><button>수정</button></a>
	</div>
</body>
</html>