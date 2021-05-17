function delCmt(iboard,icmt){
	// EL식 아닙니다. 그래서 jsp파일에서 쓰게되면 EL식으로 인식하니까 조심하십쇼, 해결법은 /${}
	console.log(`iboard : ${iboard}, icmt : ${icmt}`)
	
	if(confirm('삭제 하시겠습니까?')){
		location.href= `/board/cmt?icmt=${icmt}&iboard=${iboard}`;
	}
}