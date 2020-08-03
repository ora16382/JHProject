var count;
var temp;
var ranArr;
var egg = document.getElementsByClassName("egg");
var start;
var timeDiv;
var time;
var clear;
var theNumber;
var failDiv ;
var failNumber;
var timeID, timeID2;
var descDiv;
var reset=false;
var tempVal;
var audioArr = ["chimes.mp3","clock.mp3"];
var audio = document.getElementById("audio");
var endaudio = document.getElementById("endaudio");
var clickaudio = document.getElementById("clickaudio");
var failaudio = document.getElementById("failaudio");
function start(){

	audio.src="../media/"+audioArr[0];
	audio.loop=false;
	audio.play();
	tempVal=false;
	failDiv = document.getElementById("failDiv");
	descDiv = document.getElementById("desc");
	clear = document.getElementById("clear");
	timeDiv= document.getElementById("timer");
	ranArr = new Array();
	ranArr = randNum(ranArr);
	document.getElementById("starter").style.visibility ="hidden" ;
	
	time = 10; //타이머
	failNumber=0; //실패횟수
	theNumber=8; //성공횟수
	for(var i=0; i<24; i++){
		egg[i].lastElementChild.src="../media/img1.gif";
		egg[i].lastElementChild.onclick=null;
		egg[i].lastElementChild.style.border="0px";
	}
	
	for(var i=0; i<ranArr.length; i++){
		egg[ranArr[i]].lastElementChild.src="../media/img2.gif";	
	}
	
	
	if(reset==true){ 
	var p = document.getElementById("p");
	document.body.removeChild(p);
	}
	
	failDiv.innerHTML = "실패수 : "+ failNumber;
	clear.innerHTML = "남은수 : "+theNumber;
	descDiv.innerHTML = "숨은 그림을 보세요.";
	timeID2 = setInterval("gameStart()",1000)
	timeDiv.innerHTML = "남은시간 : "+time--;
	timeID = setInterval("timer()",1000);
}

function gameStart(){ //게임 시작

	
	for(var i=0; i<ranArr.length; i++){
		egg[ranArr[i]].lastElementChild.src="../media/img1.gif";
		egg[ranArr[i]].lastElementChild.onclick= function(){
			clickaudio.play();
			this.src = "../media/img2.gif";
			clear.innerHTML="남은수 : "+--theNumber;
			if(theNumber<=0){ //성공했을때
			clearInterval(timeID);
			descDiv.innerHTML = "성공하셨습니다.";
			document.getElementById("starter").style.visibility ="visible" ;
			document.body.innerHTML+="<p id='p' style='position:absolute;  left:500px; top:300px;'>GAME CLEAR</p>";
			reset=true;
			audio.pause();
			endaudio.play();
			}
		};
	}
	
	for(var i=0; i<24; i++){
		var cc=0;
		for(var j=0; j<ranArr.length; j++){
			if(i==ranArr[j]) cc=1;
		}
		if(cc==0){ egg[i].lastElementChild.onclick=function(){
			failDiv.innerHTML="실패수 : "+ ++failNumber
			failaudio.play();
			if(failNumber>=5){ //실패했을때
				clearInterval(timeID);
				descDiv.innerHTML = "실패";
				document.getElementById("starter").style.visibility ="visible" ;
				document.body.innerHTML+="<p id='p' style='position:absolute;  left:500px; top:300px;'>GAME OVER</p>";
				reset=true;
				audio.pause();
				for(var i=0; i<ranArr.length; i++){
					egg[ranArr[i]].lastElementChild.src="../media/img2.gif";	
					egg[ranArr[i]].lastElementChild.style.border="1px solid red";
				}
			}	
		};
		}
	}
	tempVal = true;
	clearInterval(timeID2);
}

function timer(){
	if(tempVal) timeDiv.innerHTML = "남은시간 : "+time--;
	
	if(time<5){
		audio.src="../media/"+audioArr[1];
		audio.loop=true;
		audio.play();
	}
	
	if(time<0) {
		clearInterval(timeID);
		for(var i=0; i<ranArr.length; i++){
			egg[ranArr[i]].lastElementChild.src="../media/img2.gif";	
			egg[ranArr[i]].lastElementChild.style.border="1px solid red";
		}
		document.getElementById("starter").style.visibility ="visible" ;
		document.body.innerHTML+="<p id='p' style='position:absolute;  left:500px; top:300px;'>GAME OVER</p>";
		reset=true;
		audio.pause();
	}
}


function randNum(tempArr){
	count=0;
	temp=0;
	
	while(count<8){
	
		var num = Math.floor(Math.random()*24);
		
		for(var i=0; i<tempArr.length; i++){
		 if(tempArr[i]==num) temp=1;
		}
	
		if(temp==0){
		tempArr[count] = num;
		count++;
		}
		temp=0;
	}
	return tempArr;
}

