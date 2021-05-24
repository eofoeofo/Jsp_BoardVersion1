<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>로그인 성공하셨습니다</div>
<!-- 불필요 하게 참조 할 필요 없이 바로 sessionScope에 담긴 값을 쓰려는 뜻 -->
<div>
	<a href="write">글쓰기</a> 
</div>
<div>
	<div>
		<form action="list" method="get">
			<div>
				
				<input type="search" name="search">
				<input type="submit" name="검색">
			</div>
		</form>
	</div>
	<table>
		<tr>
			<td>NO</td>
			<td>제목</td>
			<td>작성일자</td>
			<td>작성자</td>
		</tr>
		<c:forEach items="${list}" var="item">
		<tr class="record" onclick="moveToDetail(${item.iboard});">
			<td>${item.iboard}</td>
			<td>${item.title}</td>
			<td>${item.regdt}</td>
			<td>${item.unm}</td>
		</c:forEach>
	</table>
	<div>
		<c:forEach begin="1" end="${requestScope.totalPage}" var="cnt">
			<a href="list?page=${cnt}&search=${param.search}"><span>${cnt}</span></a>
		</c:forEach>
	</div>
</div>
<script>
function moveToDetail(iboard) {
	location.href="/board/detail?iboard="+iboard;
}
</script>