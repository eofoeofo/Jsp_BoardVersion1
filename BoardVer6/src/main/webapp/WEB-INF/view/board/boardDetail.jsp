<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<a href="list">리스트로 돌아가기</a>
</div>
<h1 id="title"></h1>
<div>
	글번호 : <span id="iboard"></span>
</div>
<div>
	작성자 : <span id="unm"></span>
	작성일 : <span id="regdt"></span>
</div>
<div id="ctnt"></div>

<script>
	function ajax(iboard) {
		console.log('iboard : ' + iboard);
		const param = { iboard }
		const init = {
			method: 'POST',
			body: new URLSearchParams(param) 
		}
		fetch('/board/detail', init)
		.then(function(res) {
			return res.json(); 
		})
		.then(function(myJson){
			console.log(myJson);
			setData(myJson);
		});
	}
	function setData(data) {
		var iboardElem = document.querySelector('#iboard'); // span의 주소값얻기
		var titleElem = document.querySelector('#title');
		var regdtElem = document.querySelector('#regdt');
		var ctntElem = document.querySelector('#ctnt');
		iboardElem.innerText = data.iboard;
		titleElem.innerText = data.title;
		regdtElem.innerText = data.title;
		ctntElem.innerText = data.title;
	}
	
	ajax(${param.iboard});
</script>