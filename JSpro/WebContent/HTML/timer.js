var count = 0;
var timerID = null;

onmessage = function (e){
	if(e.data=="start"){
		if(timerID !=null) return;
		timerID = setInterval(mycallback,1000);
	}
	
	else if(e.data=="stop"){
		if(timerID ==null) return;
		
		clearInterval(timerID);
		close();
	}
}

function mycallback(){
	count++;
	postMessage(count);
}