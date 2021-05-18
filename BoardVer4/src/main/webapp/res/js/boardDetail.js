var updFrmElem = document.querySelector("#updFrm");

function delCmt(iboard,icmt) {
	if(confirm('삭제 하시겠어요?')){
		location.href=`/board/cmt?icmt=${icmt}&iboard=${iboard}`;
	}
}
function updCmt(icmt,cmt) {
	updFrm.icmt.value = icmt;
	updFrm.cmt.value = cmt;
	
	insFrm.className = 'hidden';
	updFrm.className = '';
}
function showInsFrm() {
	insFrm.className = '';
	updFrm.className = 'hidden';
}