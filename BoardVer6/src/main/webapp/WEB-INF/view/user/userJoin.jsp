<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<div>
		<a href="login">LOGIN</a>
	</div>
	<form id="frm" action="join" method="post">
		<div>
			<input type="text" name="uid" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="upw" placeholder="비밀번호">
		</div>
		<div>
			<input type="text" name="unm" placeholder="이름">
		</div>
		<div>
			성별 :
			<label>남<input type="radio" name="gender" value="0" checked></label>
			<label>여<input type="radio" name="gender" value="1"></label>
		</div>
	</form>
	<input type="button" value="회원가입" onclick="join();">
	<script>
		function join() {
			var frmElem = document.querySelector('#frm');
			var uid = frmElem.uid.value;
			// input type의 value는 input type안에 적혀 있는 값이다. 
			var upw = frmElem.upw.value;
			var unm = frmElem.unm.value;
			var gender = frmElem.gender.value;
			
			// 자바스크립트의 객체 담당
			// 왼쪽은 필드명:값
			var param2 = {
					uid: uid,
					upw: upw,
					unm: unm,
					gender: gender
			}
			// 변수명과 멤버필드명이 같으면 알아서 매칭된다.
			var param = {uid,upw,unm,gender};
			console.log(param);
			console.log(param2);
			ajax(param);
		}
		// JSON.stringify는 객체를 문자열로 변환해주는 기능.
		// JSON.pasre는 반대로 문자열을 객체로 변환하는것
		// JSON get방식 -- 자바스크립트 안에서 통신 // 서버와 JSON형태로 주고 받는다.
		// 브라우저 get방식 -- html
		function ajax(param){
			const init = {
				method: 'POST',
				body: new URLSearchParams(param) // 문자열이 쿼리스트링처럼 만들어진뒤에 보내는듯
			    //body: JSON.stringify(param)
			}
			// 내가 응답을 날리는 행위
			fetch('/user/join',init)
			.then(function(res) {
				return res.json(); // 객체화
			})
			.then(function(myJson){ // 응답이 들어오는 구간(객체로 들어옴)
				console.log(myJson); // 서블릿의 pw append를 가르킴
				console.log(myJson.result);
				switch(myJson.result){
				case 0:
					alert('회원가입 실패');
					break;
				case 1:
					location.href ='/user/login';
					break;
				}
			});
		}
	</script>
</div>