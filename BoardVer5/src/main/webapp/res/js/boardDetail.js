// 주소값 얻어오는 방법
var insFrmElem = document.querySelector('#insFrm');
var updFrmElem = document.querySelector('#updFrm');


// 댓글 삭제
function delCmt(iboard,icmt){
	// EL식 아닙니다. 그래서 jsp파일에서 쓰게되면 EL식으로 인식하니까 조심하십쇼, 해결법은 /${}
	console.log(`iboard : ${iboard}, icmt : ${icmt}`)
	
	if(confirm('삭제 하시겠습니까?')){
		location.href= `/board/cmt?icmt=${icmt}&iboard=${iboard}`;
	} // location은 get방식으로 간다.
}


// 댓글 수정
function updCmt(icmt,cmt){
	console.log('icmt : %d', icmt);
	console.log('cmt : %s', cmt);
	updFrm.icmt.value = icmt;
	updFrm.cmt.value = cmt;
	
	insFrm.className = 'hidden';
	updFrm.className = '';
}

function showInsFrm() {
	insFrm.className = '';
	updFrm.className = 'hidden';
}