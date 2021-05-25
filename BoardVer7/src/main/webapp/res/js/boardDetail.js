var cmtFrmElem = document.querySelector('#cmtFrm');

function regCmt() {
	var cmtVal = cmtFrmElem.cmt.value;		
	console.log(cmtFrmElem.dataset.iboard);
	console.log(cmtVal);
	
	var param = {
		iboard: cmtFrmElem.dataset.iboard,
		cmt: cmtVal
	};
	regAjax(param);
}
// 서버가 등록해야할 자료를 전달하는 함수
function regAjax(param) {
	const init = {
		method: 'POST',
		body: new URLSearchParams(param)
	};
	fetch('cmtInsSel',init)
	// res는 브라우저에서 JSON형태로 문자열을 받는다, 받고 myJson에 보낸다.
	.then(function(res) {
		return res.json();
	})
	.then(function(myJson){
		console.log(myJson);
		
		switch(myJson.result){
			case 0:
				alert('등록 실패!');
			break;
			case 1:
				cmtFrmElem.cmt.value = '';
				alert('등록 완료!');
			break;
		}
	});
}
// 서버에게 댓글 리스트 자료를 요청하는 함수
function getListAjax() {
	var iboard = cmtFrmElem.dataset.iboard;
	fetch('cmtInsSel?iboard='+iboard)
	.then(function(res){
		return res.json();
	})
	.then(function(myJson){
		console.log(myJson);
	});
}

getListAjax();// 이 파일이 임포트 되면 함수 1회 호출