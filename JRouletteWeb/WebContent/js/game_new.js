var a=0;
var amt=-1;
function DHTMLSound(id,url) { //http://www.phon.ucl.ac.uk/home/mark/audio/play.htm
	dojo.byId(id).innerHTML="<embed src='"+url+"' hidden=true autostart=true loop=false>";
}
function init(){
	//dojo.fadeOut({node:dojo.byId("current_bet_box"),duration:1}).play();
	if(checkBrowser()){
		initGame();
	} else{ // try and play anyway
		//dojo.query("div#table").orphan(); // don't show table
		//disableGameButtons();
		//show('ie_browser_message');
		alert('JRoulette is best played with Google\'s Chrome or Safari');
		initGame();
	}
}
function initGame(){
	getRollHistory();
	getPlayerMoney();
	loadOddsRatioBoxes();
	dojoLoadMessageBox(); //TODO
	//turnOnTestBorder(); //TEMP to check div positions
}
function dojoLoadMessageBox(){
	//TODO don't store in session, probably a better way
	// create a JS object?  But how long does a JS object live (what happens when page is reloaded)?
	//store in a cookie?
}
function dojoAddOnLoad(){
	/*
	dojo.addOnLoad(
		function( ) {
			var e1 = dojo.byId("currentBetButton");
			var e1POS = dojo.coords("currentBetButton",true);
			var e2 = dojo.byId("current_bet_box");
			var handle = dojo.connect(e1, "onclick", 
			function(evt) {
				dojo.fadeOut({
					node:e1,
					duration:500,
					properties:{top:{start:e1POS.y,end:e1POS.y+15,unit:'px'}}
				}).play();
				dojo.fadeIn({
					node:e2,
					duration:500,
					delay:500,
					properties:{top:{start:e1POS.y-15,end:e1POS.y,unit:'px'}}
				}).play();
			});
		}		
	);
	dojo.addOnLoad(
		function( ) {
			var e1 = dojo.byId("currentBetButton");
			var e2 = dojo.byId("current_bet_box");
			var e2POS = dojo.coords("current_bet_box",true);
			var handle = dojo.connect(e2, "onclick", 
			function(evt) {
				dojo.fadeOut({
					node:e2,
					duration:500,
					properties:{top:{start:e2POS.y,end:e2POS.y+15,unit:'px'}}
				}).play();
				dojo.fadeIn({
					node:e1,
					duration:500,
					delay:500,
					properties:{top:{start:e2POS.y-15,end:e2POS.y,unit:'px'}}
				}).play();
			});
		}
	);
	*/
}
function appendMessage(s){
	//m = ': '+s+'\n'+dojo.byId("message-box").innerHTML;
	dojo.byId("message-box").innerHTML = ': '+s+'\n'+dojo.byId("message-box").innerHTML;
}
function getCloseButton(){
	return "<div id='closeX' class='relative right red hover' onclick='javascript:hideAll();'>X</div>";
}
function getBetCloseButton(){
	return "<div id='closeBetBox' class='relative smallfont right red hover'>X</div>";
}
function showByMouse(id){ //fix impl of this to show by mouse
	//console.log('showByMouse()');
	var d = dojo.byId(id);
	d.style.visibility="visible";
	var pos = dojo.coords(id.replace('Box',''), true);
	d.style.left=pos.x-400;
	d.style.top=pos.y-120;
}
function showByMouseRemove(id,str){ //fix impl of this to show by mouse
	//console.log('showByMouseRemove()');
	var d = dojo.byId(id.replace(str,''));
	d.style.visibility="visible";
	var pos = dojo.coords(id.replace('Box',''), true);
	d.style.left=pos.x-300;
	d.style.top=pos.y-120;
}
function showByBetId(id){
	//console.log('showByBetId()');
	var d = dojo.byId(id);
	d.style.visibility="visible";
	var pos = dojo.coords(id.replace('Box',''), true);
	d.style.left=pos.x-340;
	d.style.top=pos.y-140;
}

/*****************Controllers*****************/

function show(id){
	//if(id == "bet-message"){
		//console.log("in if block of show() for id " + id);
		//dojo.fadeIn({node:dojo.byId(id),duration:350}).play();
		//console.log("perfomed dojo.fadeIn");
		//alert('show(id): id == "bet-message".  Should not be the case as this functionality is gone'); //TODO remove this after knowing alert() never shows
	//} else {
		dojo.byId(id).style.visibility="visible";
	//}
}
function justShow(id){ //TODO phase this out
	show(id);
	//dojo.byId(id).style.visibility="visible";
}
function hide(id){
	dojo.byId(id).style.visibility="hidden";
}
function hideRemove(id,str){
	dojo.byId(id.replace(str,'')).style.visibility="hidden";
}
function spin(){
	hide('marker');
	DHTMLSound('sound-wheel','sounds/wheel.wav');
	show('wheel-spinning');
	setTimeout("spinExecute();hide('wheel-spinning');",9000);
}
function spinExecute(){
	spinWheel();
	clear(); //This single call should work when making new bets or doing a repeat bet
	playerAbleToBet();
}
function clearBets(){ //WORKAROUND: wrapper for clear()
	clear();
}
function deleteBets(){ //WORKAROUND: wrapper for delete_()
	delete_();
}
function repeat(){
	repeatBets();
}
function showBets(){
	getPlayerBets();
}
function chooseAmount(s){
	if(parseInt(s) <= parseInt(amt) && (parseInt(s)+a) <= parseInt(amt)){
		a+=s;
		appendMessage("$"+a); 
	} else{
		appendMessage("You do not have that much money");
	}
	dojo.byId('marker').style.visibility="hidden";
}
function placeBet(s){
	DHTMLSound('sound-coin','sounds/coin.wav');
	dojoPlaceBet(s.replace("bet",""),a);
	a=0; //reset choose amount
}

/*****************Dojo calls******************/

function getPlayerBets(){
	dojo.xhrGet({
		url: 'jsp/getPlayerBetsController.jsp',
		load: showBetsLoader,
		error: showXhrError,
		content: {param: null}
	});
}
function delete_(){
	dojo.xhrGet({
		url: 'jsp/deleteBetsController.jsp',
		load: deleteBetsLoader,
		error: delete_XhrError,
		content: {param: null}
	});
}
function clear(){
	dojo.xhrGet({
		url: 'jsp/clearBetsController.jsp',
		load: clearBetsLoader, //does nothing, just part of game logic
		error: clearXhrError,
		content: {param: null}
	});
}
function repeatBets(){
	dojo.xhrGet({
		url: 'jsp/repeatBetsController.jsp',
		load: repeatBetsLoader,
		error: repeatBetsXhrError,
		content: {param: null}
	});
}
function spinWheel(){
	dojo.xhrGet({
		url: 'jsp/spinWheelController.jsp',
		load: spinLoader,
		error: spinWheelXhrError,
		content: {param: null}
	});
}
function playerAbleToBet(){
	dojo.xhrGet({
		url: 'jsp/playerAbleToBetController.jsp',
		load: playerAbleToBetLoader,
		error: playerAbleToBetXhrError,
		content: {param: null}
	});
}
function getRollHistory(){
	dojo.xhrGet({
		url: 'jsp/getHistoryBoardDataController.jsp',
		load: boardHistoryLoader,
		error: getRollHistoryXhrError,
		content: {param: null}
	});
}
function getPlayerMoney(){
	dojo.xhrGet({
		url: 'jsp/getPlayerMoneyController.jsp',
		load: playerMoneyLoader,
		error: getPlayerMoneyXhrError,
		content: {param: null}
	});
}
function dojoPlaceBet(bet, amt){
	dojo.xhrGet({
		url: 'jsp/placeBetController.jsp',
		load: placeBetLoader,
		error: dojoPlaceBetXhrError,
		content: {bet: bet, betAmount: amt}
	});
}
function dojoGetOddsAndPayout(){
	dojo.xhrGet({
		url: 'jsp/getOddsAndPayoutController.jsp',
		load: writeOddsRatioBoxesLoader,
		error: dojoGetOddsAndPayoutXhrError,
		content: {param: null}
	});
}

/*******************Loaders*******************/
function playerMoneyLoader(response, ioArgs){
	amt = parseInt(response);
	return response;
}
function showBetsLoader(response, ioArgs){
	if(response.indexOf('$') != -1){
		dojo.byId('current_bet_box').innerHTML=getBetCloseButton()+response;
	} else{
		dojo.byId('current_bet_box').innerHTML="No Bets"/*+getBetCloseButton()*/;
	}
	return response;
}
function playerAbleToBetLoader(response, ioArgs){
	if(response.indexOf('f') != -1){
		disableGameButtons();
		show("game_over_box");
	}
	return response;
}
function placeBetLoader(response, ioArgs) {
	appendMessage(response.toString().trim()+'');
	showBets();
	return response;
}
function putMarkerOnNumber(id){
	var e = dojo.byId(id); //TODO might be able to remove this once stable
	var p = dojo.coords(id, true);
	if(e != null && p != null){
		//console.log('putMarkerOnNumber(): setting marker position on '+id+'. Position [x,y]=['+p.x+','+p.y+']');
		dojo.byId('marker').style.visibility="visible";
		dojo.byId('marker').style.left=p.x;//
		dojo.byId('marker').style.top=p.y-20;//
		//console.log(dojo.byId('marker').style.left + ", " + dojo.byId('marker').style.top);
	}
}
function spinLoader(response, ioArgs) {//response=|SpinResult|bet_1 [Won Lost]\n...bet_i [Won Lost]\n|PlayerMoney
	var arr = response.split("|");
	var num = parseInt(arr[1].trim());
	var id = getBetBoxId(num);
	putMarkerOnNumber(id);
	if(arr[arr.length-2].indexOf("bet") != -1){
		appendMessage(arr[arr.length-2].toString().trim()+'');
	}
	amt = parseInt(arr[arr.length-1]);
	getRollHistory();
	showBets();
	//console.log('player_money innerText=' + dojo.byId("player_money").innerText); // comes up undefined in FF4
	//console.log('player_money innerHTML=' + dojo.byId("player_money").innerHTML); // shows in FF4 and Chrome
	var mE = dojo.byId("player_money");
	if(mE != null){
		var iText = mE.innerHTML;
		if(iText != null){
			var aAmt = iText.split("$");
			var sAmt = aAmt[1].trim();
			var iAmt = parseInt(sAmt);
			//console.log('iAmt,amt:' + iAmt+','+amt);
			if(iAmt < amt){
				console.log('in if block to play sound');
				DHTMLSound('sound-win','sounds/chaching.wav');
			}else{
				DHTMLSound('sound-win','sounds/lost.wav');
			}
		}
	}
	dojo.byId("player_money").innerHTML = "Money:&nbsp;$"+amt; //This must be executed last
	return response;
}
function clearBetsLoader(response, ioArgs) {
	//KEEP, but does nothing
	return response;
}
function deleteBetsLoader(response, ioArgs){
	a = 0; //reset choose amount
	if(response.indexOf('T') != -1){
		appendMessage('All Bets Deleted');
	} else{
		appendMessage('No Bets To Delete');
	}
	showBets();
	return response;
}
function repeatBetsLoader(response, ioArgs){
	if(response.indexOf('T') != -1){
		a=0;
		appendMessage('Bets Placed');
		showBets();
	}
	return response;
}
function writeOddsRatioBoxesLoader(response, ioArgs){
	//console.log("in writeOddsRatioBoxesLoader()");
	var arr = response.split('|');
	
	for(var i=0; i < arr.length; i++){
		//console.log("in for loop");
		var a = arr[i].split('<br/>');
		if(dojo.byId(a[0].trim()+'Box') != null){
			//console.log("in if statement, setting id " + a[0].trim()); 
			dojo.byId(a[0].trim()+'Box').innerHTML=arr[i];
		}
	}
	
	return response;
}
function boardHistoryLoader(response, ioArgs){
	var a = response.split("|");
	if(a[0].indexOf('R') != -1){
		dojo.byId('hbnum1').innerHTML = a[0].substring(4,6);
		dojo.byId('hbzer1').innerHTML = '&nbsp;';
		dojo.byId('hbclr1').innerHTML = '&nbsp;';
	} else if(a[0].indexOf('B') != -1){
		dojo.byId('hbnum1').innerHTML = '&nbsp;';
		dojo.byId('hbzer1').innerHTML = '&nbsp;';
		dojo.byId('hbclr1').innerHTML = a[0].substring(4,6);
	} else if(a[0].indexOf('G') != -1){
		dojo.byId('hbnum1').innerHTML = '&nbsp;';
		dojo.byId('hbzer1').innerHTML = a[0].substring(4,6);
		dojo.byId('hbclr1').innerHTML = '&nbsp;';
	} else {
		dojo.byId('hbnum1').innerHTML = '&nbsp;';
		dojo.byId('hbzer1').innerHTML = '&nbsp;';
		dojo.byId('hbclr1').innerHTML = '&nbsp;';
	}
	if(a[1].indexOf('R') != -1){
		dojo.byId('hbnum2').innerHTML = a[1].substring(1,5);
		dojo.byId('hbzer2').innerHTML = '&nbsp;';
		dojo.byId('hbclr2').innerHTML = '&nbsp;';
	} else if(a[1].indexOf('B') != -1){
		dojo.byId('hbnum2').innerHTML = '&nbsp;';
		dojo.byId('hbzer2').innerHTML = '&nbsp;';
		dojo.byId('hbclr2').innerHTML = a[1].substring(1,5);
	} else if(a[1].indexOf('G') != -1){
		dojo.byId('hbnum2').innerHTML = '&nbsp;';
		dojo.byId('hbzer2').innerHTML = a[1].substring(1,5);
		dojo.byId('hbclr2').innerHTML = '&nbsp;';
	} else {
		dojo.byId('hbnum2').innerHTML = '&nbsp;';
		dojo.byId('hbzer2').innerHTML = '&nbsp;';
		dojo.byId('hbclr2').innerHTML = '&nbsp;';
	}
	if(a[2].indexOf('R') != -1){
		dojo.byId('hbnum3').innerHTML = a[2].substring(1,3);
		dojo.byId('hbzer3').innerHTML = '&nbsp;';
		dojo.byId('hbclr3').innerHTML = '&nbsp;';
	} else if(a[2].indexOf('B') != -1){
		dojo.byId('hbnum3').innerHTML = '&nbsp;';
		dojo.byId('hbzer3').innerHTML = '&nbsp;';
		dojo.byId('hbclr3').innerHTML = a[2].substring(1,3);
	} else if(a[2].indexOf('G') != -1){
		dojo.byId('hbnum3').innerHTML = '&nbsp;';
		dojo.byId('hbzer3').innerHTML = a[2].substring(1,3);
		dojo.byId('hbclr3').innerHTML = '&nbsp;';
	} else {
		dojo.byId('hbnum3').innerHTML = '&nbsp;';
		dojo.byId('hbzer3').innerHTML = '&nbsp;';
		dojo.byId('hbclr3').innerHTML = '&nbsp;';
	}
	if(a[3].indexOf('R') != -1){
		dojo.byId('hbnum4').innerHTML = a[3].substring(1,3);
		dojo.byId('hbzer4').innerHTML = '&nbsp;';
		dojo.byId('hbclr4').innerHTML = '&nbsp;';
	} else if(a[3].indexOf('B') != -1){
		dojo.byId('hbnum4').innerHTML = '&nbsp;';
		dojo.byId('hbzer4').innerHTML = '&nbsp;';
		dojo.byId('hbclr4').innerHTML = a[3].substring(1,3);
	} else if(a[3].indexOf('G') != -1){
		dojo.byId('hbnum4').innerHTML = '&nbsp;';
		dojo.byId('hbzer4').innerHTML = a[3].substring(1,3);
		dojo.byId('hbclr4').innerHTML = '&nbsp;';
	} else {
		dojo.byId('hbnum4').innerHTML = '&nbsp;';
		dojo.byId('hbzer4').innerHTML = '&nbsp;';
		dojo.byId('hbclr4').innerHTML = '&nbsp;';
	}
	if(a[4].indexOf('R') != -1){
		dojo.byId('hbnum5').innerHTML = a[4].substring(1,3);
		dojo.byId('hbzer5').innerHTML = '&nbsp;';
		dojo.byId('hbclr5').innerHTML = '&nbsp;';
	} else if(a[4].indexOf('B') != -1){
		dojo.byId('hbnum5').innerHTML = '&nbsp;';
		dojo.byId('hbzer5').innerHTML = '&nbsp;';
		dojo.byId('hbclr5').innerHTML = a[4].substring(1,3);
	} else if(a[4].indexOf('G') != -1){
		dojo.byId('hbnum5').innerHTML = '&nbsp;';
		dojo.byId('hbzer5').innerHTML = a[4].substring(1,3);
		dojo.byId('hbclr5').innerHTML = '&nbsp;';
	} else {
		dojo.byId('hbnum5').innerHTML = '&nbsp;';
		dojo.byId('hbzer5').innerHTML = '&nbsp;';
		dojo.byId('hbclr5').innerHTML = '&nbsp;';
	}
	if(a[5].indexOf('R') != -1){
		dojo.byId('hbnum6').innerHTML = a[5].substring(1,3);
		dojo.byId('hbzer6').innerHTML = '&nbsp;';
		dojo.byId('hbclr6').innerHTML = '&nbsp;';
	} else if(a[5].indexOf('B') != -1){
		dojo.byId('hbnum6').innerHTML = '&nbsp;';
		dojo.byId('hbzer6').innerHTML = '&nbsp;';
		dojo.byId('hbclr6').innerHTML = a[5].substring(1,3);
	} else if(a[5].indexOf('G') != -1){
		dojo.byId('hbnum6').innerHTML = '&nbsp;';
		dojo.byId('hbzer6').innerHTML = a[5].substring(1,3);
		dojo.byId('hbclr6').innerHTML = '&nbsp;';
	} else {
		dojo.byId('hbnum6').innerHTML = '&nbsp;';
		dojo.byId('hbzer6').innerHTML = '&nbsp;';
		dojo.byId('hbclr6').innerHTML = '&nbsp;';
	}
	if(a[6].indexOf('R') != -1){
		dojo.byId('hbnum7').innerHTML = a[6].substring(1,3);
		dojo.byId('hbzer7').innerHTML = '&nbsp;';
		dojo.byId('hbclr7').innerHTML = '&nbsp;';
	} else if(a[6].indexOf('B') != -1){
		dojo.byId('hbnum7').innerHTML = '&nbsp;';
		dojo.byId('hbzer7').innerHTML = '&nbsp;';
		dojo.byId('hbclr7').innerHTML = a[6].substring(1,3);
	} else if(a[6].indexOf('G') != -1){
		dojo.byId('hbnum7').innerHTML = '&nbsp;';
		dojo.byId('hbzer7').innerHTML = a[6].substring(1,3);
		dojo.byId('hbclr7').innerHTML = '&nbsp;';
	} else {
		dojo.byId('hbnum7').innerHTML = '&nbsp;';
		dojo.byId('hbzer7').innerHTML = '&nbsp;';
		dojo.byId('hbclr7').innerHTML = '&nbsp;';
	}
	if(a[7].indexOf('R') != -1){
		dojo.byId('hbnum8').innerHTML = a[7].substring(1,3);
		dojo.byId('hbzer8').innerHTML = '&nbsp;';
		dojo.byId('hbclr8').innerHTML = '&nbsp;';
	} else if(a[7].indexOf('B') != -1){
		dojo.byId('hbnum8').innerHTML = '&nbsp;';
		dojo.byId('hbzer8').innerHTML = '&nbsp;';
		dojo.byId('hbclr8').innerHTML = a[7].substring(1,3);
	} else if(a[7].indexOf('G') != -1){
		dojo.byId('hbnum8').innerHTML = '&nbsp;';
		dojo.byId('hbzer8').innerHTML = a[7].substring(1,3);
		dojo.byId('hbclr8').innerHTML = '&nbsp;';
	} else {
		dojo.byId('hbnum8').innerHTML = '&nbsp;';
		dojo.byId('hbzer8').innerHTML = '&nbsp;';
		dojo.byId('hbclr8').innerHTML = '&nbsp;';
	}
	if(a[8].indexOf('R') != -1){
		dojo.byId('hbnum9').innerHTML = a[8].substring(1,3);
		dojo.byId('hbzer9').innerHTML = '&nbsp;';
		dojo.byId('hbclr9').innerHTML = '&nbsp;';
	} else if(a[8].indexOf('B') != -1){
		dojo.byId('hbnum9').innerHTML = '&nbsp;';
		dojo.byId('hbzer9').innerHTML = '&nbsp;';
		dojo.byId('hbclr9').innerHTML = a[8].substring(1,3);
	} else if(a[8].indexOf('G') != -1){
		dojo.byId('hbnum9').innerHTML = '&nbsp;';
		dojo.byId('hbzer9').innerHTML = a[8].substring(1,3);
		dojo.byId('hbclr9').innerHTML = '&nbsp;';
	} else {
		dojo.byId('hbnum9').innerHTML = '&nbsp;';
		dojo.byId('hbzer9').innerHTML = '&nbsp;';
		dojo.byId('hbclr9').innerHTML = '&nbsp;';
	}
	if(a[9].indexOf('R') != -1){
		dojo.byId('hbnum10').innerHTML = a[9].substring(1,3);
		dojo.byId('hbzer10').innerHTML = '&nbsp;';
		dojo.byId('hbclr10').innerHTML = '&nbsp;';
	} else if(a[9].indexOf('B') != -1){
		dojo.byId('hbnum10').innerHTML = '&nbsp;';
		dojo.byId('hbzer10').innerHTML = '&nbsp;';
		dojo.byId('hbclr10').innerHTML = a[9].substring(1,3);
	} else if(a[9].indexOf('G') != -1){
		dojo.byId('hbnum10').innerHTML = '&nbsp;';
		dojo.byId('hbzer10').innerHTML = a[9].substring(1,3);
		dojo.byId('hbclr10').innerHTML = '&nbsp;';
	} else {
		dojo.byId('hbnum10').innerHTML = '&nbsp;';
		dojo.byId('hbzer10').innerHTML = '&nbsp;';
		dojo.byId('hbclr10').innerHTML = '&nbsp;';
	}
	if(a[10].indexOf('R') != -1){
		dojo.byId('hbnum11').innerHTML = a[10].substring(1,3);
		dojo.byId('hbzer11').innerHTML = '&nbsp;';
		dojo.byId('hbclr11').innerHTML = '&nbsp;';
	} else if(a[10].indexOf('B') != -1){
		dojo.byId('hbnum11').innerHTML = '&nbsp;';
		dojo.byId('hbzer11').innerHTML = '&nbsp;';
		dojo.byId('hbclr11').innerHTML = a[10].substring(1,3);
	} else if(a[10].indexOf('G') != -1){
		dojo.byId('hbnum11').innerHTML = '&nbsp;';
		dojo.byId('hbzer11').innerHTML = a[10].substring(1,3);
		dojo.byId('hbclr11').innerHTML = '&nbsp;';
	} else {
		dojo.byId('hbnum11').innerHTML = '&nbsp;';
		dojo.byId('hbzer11').innerHTML = '&nbsp;';
		dojo.byId('hbclr11').innerHTML = '&nbsp;';
	}
	if(a[11].indexOf('R') != -1){
		dojo.byId('hbnum12').innerHTML = a[11].substring(1,3);
		dojo.byId('hbzer12').innerHTML = '&nbsp;';
		dojo.byId('hbclr12').innerHTML = '&nbsp;';
	} else if(a[11].indexOf('B') != -1){
		dojo.byId('hbnum12').innerHTML = '&nbsp;';
		dojo.byId('hbzer12').innerHTML = '&nbsp;';
		dojo.byId('hbclr12').innerHTML = a[11].substring(1,3);
	} else if(a[11].indexOf('G') != -1){
		dojo.byId('hbnum12').innerHTML = '&nbsp;';
		dojo.byId('hbzer12').innerHTML = a[11].substring(1,3);
		dojo.byId('hbclr12').innerHTML = '&nbsp;';
	} else {
		dojo.byId('hbnum12').innerHTML = '&nbsp;';
		dojo.byId('hbzer12').innerHTML = '&nbsp;';
		dojo.byId('hbclr12').innerHTML = '&nbsp;';
	}
	if(a[12].indexOf('R') != -1){
		dojo.byId('hbnum13').innerHTML = a[12].substring(1,3);
		dojo.byId('hbzer13').innerHTML = '&nbsp;';
		dojo.byId('hbclr13').innerHTML = '&nbsp;';
	} else if(a[12].indexOf('B') != -1){
		dojo.byId('hbnum13').innerHTML = '&nbsp;';
		dojo.byId('hbzer13').innerHTML = '&nbsp;';
		dojo.byId('hbclr13').innerHTML = a[12].substring(1,3);
	} else if(a[12].indexOf('G') != -1){
		dojo.byId('hbnum13').innerHTML = '&nbsp;';
		dojo.byId('hbzer13').innerHTML = a[12].substring(1,3);
		dojo.byId('hbclr13').innerHTML = '&nbsp;';
	} else {
		dojo.byId('hbnum13').innerHTML = '&nbsp;';
		dojo.byId('hbzer13').innerHTML = '&nbsp;';
		dojo.byId('hbclr13').innerHTML = '&nbsp;';
	}
	if(a[13].indexOf('R') != -1){
		dojo.byId('hbnum14').innerHTML = a[13].substring(1,3);
		dojo.byId('hbzer14').innerHTML = '&nbsp;';
		dojo.byId('hbclr14').innerHTML = '&nbsp;';
	} else if(a[13].indexOf('B') != -1){
		dojo.byId('hbnum14').innerHTML = '&nbsp;';
		dojo.byId('hbzer14').innerHTML = '&nbsp;';
		dojo.byId('hbclr14').innerHTML = a[13].substring(1,3);
	} else if(a[13].indexOf('G') != -1){
		dojo.byId('hbnum14').innerHTML = '&nbsp;';
		dojo.byId('hbzer14').innerHTML = a[13].substring(1,3);
		dojo.byId('hbclr14').innerHTML = '&nbsp;';
	} else {
		dojo.byId('hbnum14').innerHTML = '&nbsp;';
		dojo.byId('hbzer14').innerHTML = '&nbsp;';
		dojo.byId('hbclr14').innerHTML = '&nbsp;';
	}
	if(a[14].indexOf('R') != -1){ //most recent spin
		dojo.byId('hbnum15').innerHTML = a[14].substring(1,3);
		dojo.byId('hbzer15').innerHTML = '&nbsp;';
		dojo.byId('hbclr15').innerHTML = '&nbsp;';
	} else if(a[14].indexOf('B') != -1){
		dojo.byId('hbnum15').innerHTML = '&nbsp;';
		dojo.byId('hbzer15').innerHTML = '&nbsp;';
		dojo.byId('hbclr15').innerHTML = a[14].substring(1,3);
	} else if(a[14].indexOf('G') != -1){
		dojo.byId('hbnum15').innerHTML = '&nbsp;';
		dojo.byId('hbzer15').innerHTML = a[14].substring(1,3);
		dojo.byId('hbclr15').innerHTML = '&nbsp;';
	} else{
		dojo.byId('hbnum15').innerHTML = '&nbsp;';
		dojo.byId('hbzer15').innerHTML = '&nbsp;';
		dojo.byId('hbclr15').innerHTML = '&nbsp;';
	}
	return response;
}

/*****************init Loaders****************/
function loadOddsRatioBoxes(){
	dojoGetOddsAndPayout();
}

/*******************Errors********************/
function spinWheelXhrError(response, ioArgs) {console.log('spinWheelXhrError: Error when retrieving data from the server! ' + response);return response;}
function delete_XhrError(response, ioArgs) {console.log('delete_XhrError: Error when retrieving data from the server! ' + response);return response;}
function dojoPlaceBetXhrError(response, ioArgs) {console.log('dojoPlaceBetXhrError: Error when retrieving data from the server! ' + response);return response;}
function getPlayerMoneyXhrError(response, ioArgs) {console.log('getPlayerMoneyXhrError: Error when retrieving data from the server! ' + response);return response;}
function getRollHistoryXhrError(response, ioArgs) {console.log('getRollHistoryXhrError: Error when retrieving data from the server! ' + response);return response;}
function playerAbleToBetXhrError(response, ioArgs) {console.log('playerAbleToBetXhrError: Error when retrieving data from the server! ' + response);return response;}
function repeatBetsXhrError(response, ioArgs) {console.log('repeatBetsXhrError: Error when retrieving data from the server! ' + response);return response;}
function clearXhrError(response, ioArgs) {console.log('clearXhrError: Error when retrieving data from the server! ' + response);return response;}
function showXhrError(response, ioArgs) {console.log('showXhrError: Error when retrieving data from the server! ' + response);return response;}
function dojoGetOddsAndPayoutXhrError(response, ioArgs) {console.log('dojoGetOddsAndPayoutXhrError: Error when retrieving data from the server! ' + response);return response;}
function loadOddsRatioBoxesXhrError(response, ioArgs) {console.log('loadOddsRatioBoxesXhrError: Error when retrieving data from the server! ' + response);return response;}
function checkBrowser(){
	if(dojo.isIE || dojo.isFF){
		return false;
	} else{
		return true;
	}
	/*if(dojo.isChrome){
		alert('This is a Chrome browser');
	} else if(dojo.isFF){
		alert('This is a FireFox browser');
	} else if(dojo.isSafari){
		alert('This is a Safari browser');
	} else if(dojo.isOpera){
		alert('This is a Opera browser');
	} else if(dojo.isIE){
		alert('This is an Internet Explorer browser');
	} else{
		alert('Browser not detected');
	}*/
}
function disableGameButtons(){
	dojo.query("div.hover").orphan(); //remove all buttons
}
function getBetBoxId(i){
	var names = ['betZERO',
	             'betONE',
	             'betTWO',
	             'betTHREE',
	             'betFOUR',
	             'betFIVE',
	             'betSIX',
	             'betSEVEN',
	             'betEIGHT',
	             'betNINE',
	             'betTEN',
	             'betELEVEN',
	             'betTWELVE',
	             'betTHIRTEEN',
	             'betFOURTEEN',
	             'betFIFTEEN',
	             'betSIXTEEN',
	             'betSEVENTEEN',
	             'betEIGHTEEN',
	             'betNINETEEN',
	             'betTWENTY',
	             'betTWENTY_ONE',
	             'betTWENTY_TWO',
	             'betTWENTY_THREE',
	             'betTWENTY_FOUR',
	             'betTWENTY_FIVE',
	             'betTWENTY_SIX',
	             'betTWENTY_SEVEN',
	             'betTWENTY_EIGHT',
	             'betTWENTY_NINE',
	             'betTHIRTY',
	             'betTHRITY_ONE',
	             'betTHRITY_TWO',
	             'betTHRITY_THREE',
	             'betTHRITY_FOUR',
	             'betTHRITY_FIVE',
	             'betTHRITY_SIX',
	             'betDOUBLE_ZERO'];
	var id = names[i];
	return id;
}
function turnOnTestBorder(){
	var ids = ['betBLACK',
	           'betBOTH_ZEROS',
	           'betDOUBLE_ZERO_2_3_BASKET',
	           'betDOUBLE_ZERO',
	           'betEIGHT_9_11_12_CORNER',
	           'betEIGHT_ELEVEN_SPLIT',
	           'betEIGHT_NINE_SPLIT',
	           'betEIGHT',
	           'betEIGHTBox',
	           'betEIGHTEEN_TWENTY_ONE_SPLIT',
	           'betEIGHTEEN_TWENTY_ONE_SPLITBox',
	           'betEIGHTEEN',
	           'betEIGHTEENBox',
	           'betELEVEN_12_14_15_CORNER',
	           'betELEVEN_12_14_15_CORNERBox',
	           'betELEVEN_FOURTEEN_SPLIT',
	           'betELEVEN_FOURTEEN_SPLITBox',
	           'betELEVEN_TWELVE_SPLIT',
	           'betELEVEN_TWELVE_SPLITBox',
	           'betELEVEN',
	           'betELEVENBox',
	           'betEVENS',
	           'betEVENSBox',
	           'betFIFTEEN_EIGHTEEN_SPLIT',
	           'betFIFTEEN_EIGHTEEN_SPLITBox',
	           'betFIFTEEN',
	           'betFIFTEENBox',
	           'betFIRST_18',
	           'betFIRST_18Box',
	           'betFIRST_COLUMN',
	           'betFIRST_COLUMNBox',
	           'betFIRST_DOZEN',
	           'betFIRST_DOZENBox',
	           'betFIVE_6_8_9_CORNER',
	           'betFIVE_6_8_9_CORNERBox',
	           'betFIVE_EIGHT_SPLIT',
	           'betFIVE_EIGHT_SPLITBox',
	           'betFIVE_SIX_SPLIT',
	           'betFIVE_SIX_SPLITBox',
	           'betFIVE',
	           'betFIVEBox',
	           'betFOUR_5_7_8_CORNER',
	           'betFOUR_5_7_8_CORNERBox',
	           'betFOUR_7_SIXLINE',
	           'betFOUR_7_SIXLINEBox',
	           'betFOUR_FIVE_SIX_STREET',
	           'betFOUR_FIVE_SIX_STREETBox',
	           'betFOUR_FIVE_SPLIT',
	           'betFOUR_FIVE_SPLITBox',
	           'betFOUR_SEVEN_SPLIT',
	           'betFOUR_SEVEN_SPLITBox',
	           'betFOUR',
	           'betFOURBox',
	           'betFOURTEEN_15_17_18_CORNER',
	           'betFOURTEEN_15_17_18_CORNERBox',
	           'betFOURTEEN_FIFTEEN_SPLIT',
	           'betFOURTEEN_FIFTEEN_SPLITBox',
	           'betFOURTEEN_SEVENTEEN_SPLIT',
	           'betFOURTEEN_SEVENTEEN_SPLITBox',
	           'betFOURTEEN',
	           'betFOURTEENBox',
	           'betLAST_18',
	           'betLAST_18Box',
	           'betNINE_TWELVE_SPLIT',
	           'betNINE_TWELVE_SPLITBox',
	           'betNINE',
	           'betNINEBox',
	           'betNINETEEN_20_22_23_CORNER',
	           'betNINETEEN_20_22_23_CORNERBox',
	           'betNINETEEN_22_SIXLINE',
	           'betNINETEEN_22_SIXLINEBox',
	           'betNINETEEN_TWENTY_TWENTY_ONE_STREET',
	           'betNINETEEN_TWENTY_TWENTY_ONE_STREETBox',
	           'betNINETEEN_TWENTY_TWO_SPLIT',
	           'betNINETEEN_TWENTY_TWO_SPLITBox',
	           'betNINETEEN',
	           'betNINETEENBox',
	           'betNINTEEN_TWENTY_SPLIT',
	           'betNINTEEN_TWENTY_SPLITBox',
	           'betODDS',
	           'betODDSBox',
	           'betONE_2_4_5_CORNER',
	           'betONE_2_4_5_CORNERBox',
	           'betONE_4_SIXLINE',
	           'betONE_4_SIXLINEBox',
	           'betONE_FOUR_SPLIT',
	           'betONE_FOUR_SPLITBox',
	           'betONE_TWO_SPLIT',
	           'betONE_TWO_SPLITBox',
	           'betONE_TWO_THREE_STREET',
	           'betONE_TWO_THREE_STREETBox',
	           'betONE',
	           'betONEBox',
	           'betRED',
	           'betREDBox',
	           'betSECOND_COLUMN',
	           'betSECOND_COLUMNBox',
	           'betSECOND_DOZEN',
	           'betSECOND_DOZENBox',
	           'betSEVEN_10_SIXLINE',
	           'betSEVEN_10_SIXLINEBox',
	           'betSEVEN_8_10_11_CORNER',
	           'betSEVEN_8_10_11_CORNERBox',
	           'betSEVEN_EIGHT_NINE_STREET',
	           'betSEVEN_EIGHT_NINE_STREETBox',
	           'betSEVEN_EIGHT_SPLIT',
	           'betSEVEN_EIGHT_SPLITBox',
	           'betSEVEN_TEN_SPLIT',
	           'betSEVEN_TEN_SPLITBox',
	           'betSEVEN',
	           'betSEVENBox',
	           'betSEVENTEEN_18_20_21_CORNER',
	           'betSEVENTEEN_18_20_21_CORNERBox',
	           'betSEVENTEEN_EIGHTEEN_SPLIT',
	           'betSEVENTEEN_EIGHTEEN_SPLITBox',
	           'betSEVENTEEN_TWENTY_SPLIT',
	           'betSEVENTEEN_TWENTY_SPLITBox',
	           'betSEVENTEEN',
	           'betSEVENTEENBox',
	           'betSIX_NINE_SPLIT',
	           'betSIX_NINE_SPLITBox',
	           'betSIX',
	           'betSIXBox',
	           'betSIXTEEN_17_19_20_CORNER',
	           'betSIXTEEN_17_19_20_CORNERBox',
	           'betSIXTEEN_19_SIXLINE',
	           'betSIXTEEN_19_SIXLINEBox',
	           'betSIXTEEN_NINETEEN_SPLIT',
	           'betSIXTEEN_NINETEEN_SPLITBox',
	           'betSIXTEEN_SEVENTEEN_EIGHTEEN_STREET',
	           'betSIXTEEN_SEVENTEEN_EIGHTEEN_STREETBox',
	           'betSIXTEEN_SEVENTEEN_SPLIT',
	           'betSIXTEEN_SEVENTEEN_SPLITBox',
	           'betSIXTEEN',
	           'betSIXTEENBox',
	           'betTEN_11_13_14_CORNER',
	           'betTEN_11_13_14_CORNERBox',
	           'betTEN_13_SIXLINE',
	           'betTEN_13_SIXLINEBox',
	           'betTEN_ELEVEN_SPLIT',
	           'betTEN_ELEVEN_SPLITBox',
	           'betTEN_ELEVEN_TWELVE_STREET',
	           'betTEN_ELEVEN_TWELVE_STREETBox',
	           'betTEN_THIRTEEN_SPLIT',
	           'betTEN_THIRTEEN_SPLITBox',
	           'betTEN',
	           'betTENBox',
	           'betTHIRD_COLUMN',
	           'betTHIRD_COLUMNBox',
	           'betTHIRD_DOZEN',
	           'betTHIRD_DOZENBox',
	           'betTHIRTEEN_14_16_17_CORNER',
	           'betTHIRTEEN_14_16_17_CORNERBox',
	           'betTHIRTEEN_16_SIXLINE',
	           'betTHIRTEEN_16_SIXLINEBox',
	           'betTHIRTEEN_FOURTEEN_FIFTEEN_STREET',
	           'betTHIRTEEN_FOURTEEN_FIFTEEN_STREETBox',
	           'betTHIRTEEN_FOURTEEN_SPLIT',
	           'betTHIRTEEN_FOURTEEN_SPLITBox',
	           'betTHIRTEEN_SIXTEEN_SPLIT',
	           'betTHIRTEEN_SIXTEEN_SPLITBox',
	           'betTHIRTEEN',
	           'betTHIRTEENBox',
	           'betTHIRTY_FIVE_THIRTY_SIX_SPLIT',
	           'betTHIRTY_FIVE_THIRTY_SIX_SPLITBox',
	           'betTHIRTY_FOUR_THRITY_FIVE_THIRTY_SIX_STREET',
	           'betTHIRTY_FOUR_THRITY_FIVE_THIRTY_SIX_STREETBox',
	           'betTHIRTY_ONE_32_34_35_CORNER',
	           'betTHIRTY_ONE_32_34_35_CORNERBox',
	           'betTHIRTY_ONE_34_SIXLINE',
	           'betTHIRTY_ONE_34_SIXLINEBox',
	           'betTHIRTY_ONE_THIRTY_FOUR_SPLIT',
	           'betTHIRTY_ONE_THIRTY_FOUR_SPLITBox',
	           'betTHIRTY_ONE_THIRTY_THRITY_TWO_SPLIT',
	           'betTHIRTY_ONE_THIRTY_THRITY_TWO_SPLITBox',
	           'betTHIRTY_ONE_THIRTY_TWO_THIRTY_THREE_STREET',
	           'betTHIRTY_ONE_THIRTY_TWO_THIRTY_THREE_STREETBox',
	           'betTHIRTY_THIRTY_THREE_SPLIT',
	           'betTHIRTY_THIRTY_THREE_SPLITBox',
	           'betTHIRTY_THREE_THIRTY_SIX_SPLIT',
	           'betTHIRTY_THREE_THIRTY_SIX_SPLITBox',
	           'betTHIRTY_TWO_33_35_36_CORNER',
	           'betTHIRTY_TWO_33_35_36_CORNERBox',
	           'betTHIRTY_TWO_THIRTY_FIVE_SPLIT',
	           'betTHIRTY_TWO_THIRTY_FIVE_SPLITBox',
	           'betTHIRTY',
	           'betTHIRTYBox',
	           'betTHREE_SIX_SPLIT',
	           'betTHREE_SIX_SPLITBox',
	           'betTHREE',
	           'betTHREEBox',
	           'betTHRITY_FIVE',
	           'betTHRITY_FIVEBox',
	           'betTHRITY_FOUR_THIRTY_FIVE_SPLIT',
	           'betTHRITY_FOUR_THIRTY_FIVE_SPLITBox',
	           'betTHRITY_FOUR',
	           'betTHRITY_FOURBox',
	           'betTHRITY_ONE',
	           'betTHRITY_ONEBox',
	           'betTHRITY_SIX',
	           'betTHRITY_SIXBox',
	           'betTHRITY_THREE',
	           'betTHRITY_THREEBox',
	           'betTHRITY_TWO_THIRTY_THREE_SPLIT',
	           'betTHRITY_TWO_THIRTY_THREE_SPLITBox',
	           'betTHRITY_TWO',
	           'betTHRITY_TWOBox',
	           'betTOPLINE',
	           'betTOPLINEBox',
	           'betTWELVE_FIFTEEN_SPLIT',
	           'betTWELVE_FIFTEEN_SPLITBox',
	           'betTWELVE',
	           'betTWELVEBox',
	           'betTWENTY_21_23_24_CORNER',
	           'betTWENTY_21_23_24_CORNERBox',
	           'betTWENTY_EIGHT_29_31_32_CORNER',
	           'betTWENTY_EIGHT_29_31_32_CORNERBox',
	           'betTWENTY_EIGHT_31_SIXLINE',
	           'betTWENTY_EIGHT_31_SIXLINEBox',
	           'betTWENTY_EIGHT_THIRTY_ONE_SPLIT',
	           'betTWENTY_EIGHT_THIRTY_ONE_SPLITBox',
	           'betTWENTY_EIGHT_TWENTY_NINE_THIRTY_STREET',
	           'betTWENTY_EIGHT_TWENTY_NINE_THIRTY_STREETBox',
	           'betTWENTY_EIGHT_TWETNY_NINE_SPLIT',
	           'betTWENTY_EIGHT_TWETNY_NINE_SPLITBox',
	           'betTWENTY_EIGHT',
	           'betTWENTY_EIGHTBox',
	           'betTWENTY_FIVE_26_28_29_CORNER',
	           'betTWENTY_FIVE_26_28_29_CORNERBox',
	           'betTWENTY_FIVE_28_SIXLINE',
	           'betTWENTY_FIVE_28_SIXLINEBox',
	           'betTWENTY_FIVE_TWENTY_EIGHT_SPLIT',
	           'betTWENTY_FIVE_TWENTY_EIGHT_SPLITBox',
	           'betTWENTY_FIVE_TWENTY_SIX_SPLIT',
	           'betTWENTY_FIVE_TWENTY_SIX_SPLITBox',
	           'betTWENTY_FIVE_TWENTY_SIX_TWENTY_SEVEN_STREET',
	           'betTWENTY_FIVE_TWENTY_SIX_TWENTY_SEVEN_STREETBox',
	           'betTWENTY_FIVE',
	           'betTWENTY_FIVEBox',
	           'betTWENTY_FOUR_TWENTY_SEVEN_SPLIT',
	           'betTWENTY_FOUR_TWENTY_SEVEN_SPLITBox',
	           'betTWENTY_FOUR',
	           'betTWENTY_FOURBox',
	           'betTWENTY_NINE_30_32_33_CORNER',
	           'betTWENTY_NINE_30_32_33_CORNERBox',
	           'betTWENTY_NINE_THIRTY_SPLIT',
	           'betTWENTY_NINE_THIRTY_SPLITBox',
	           'betTWENTY_NINE_THRITY_TWO_SPLIT',
	           'betTWENTY_NINE_THRITY_TWO_SPLITBox',
	           'betTWENTY_NINE',
	           'betTWENTY_NINEBox',
	           'betTWENTY_ONE_TWENTY_FOUR_SPLIT',
	           'betTWENTY_ONE_TWENTY_FOUR_SPLITBox',
	           'betTWENTY_ONE',
	           'betTWENTY_ONEBox',
	           'betTWENTY_SEVEN_THIRTY_SPLIT',
	           'betTWENTY_SEVEN_THIRTY_SPLITBox',
	           'betTWENTY_SEVEN',
	           'betTWENTY_SEVENBox',
	           'betTWENTY_SIX_27_29_30_CORNER',
	           'betTWENTY_SIX_27_29_30_CORNERBox',
	           'betTWENTY_SIX_TWENTY_NINE_SPLIT',
	           'betTWENTY_SIX_TWENTY_NINE_SPLITBox',
	           'betTWENTY_SIX_TWENTY_SEVEN_SPLIT',
	           'betTWENTY_SIX_TWENTY_SEVEN_SPLITBox',
	           'betTWENTY_SIX',
	           'betTWENTY_SIXBox',
	           'betTWENTY_THREE_24_26_27_CORNER',
	           'betTWENTY_THREE_24_26_27_CORNERBox',
	           'betTWENTY_THREE_TWENTY_FOUR_SPLIT',
	           'betTWENTY_THREE_TWENTY_FOUR_SPLITBox',
	           'betTWENTY_THREE_TWENTY_SIX_SPLIT',
	           'betTWENTY_THREE_TWENTY_SIX_SPLITBox',
	           'betTWENTY_THREE',
	           'betTWENTY_THREEBox',
	           'betTWENTY_TWENTY_ONE_SPLIT',
	           'betTWENTY_TWENTY_ONE_SPLITBox',
	           'betTWENTY_TWENTY_THREE_SPLIT',
	           'betTWENTY_TWENTY_THREE_SPLITBox',
	           'betTWENTY_TWO_23_25_26_CORNER',
	           'betTWENTY_TWO_23_25_26_CORNERBox',
	           'betTWENTY_TWO_25_SIXLINE',
	           'betTWENTY_TWO_25_SIXLINEBox',
	           'betTWENTY_TWO_TWENTY_FIVE_SPLIT',
	           'betTWENTY_TWO_TWENTY_FIVE_SPLITBox',
	           'betTWENTY_TWO_TWENTY_THREE_SPLIT',
	           'betTWENTY_TWO_TWENTY_THREE_SPLITBox',
	           'betTWENTY_TWO_TWENTY_THREE_TWENTY_FOUR_STREET',
	           'betTWENTY_TWO_TWENTY_THREE_TWENTY_FOUR_STREETBox',
	           'betTWENTY_TWO',
	           'betTWENTY_TWOBox',
	           'betTWENTY',
	           'betTWENTYBox',
	           'betTWO_3_5_6_CORNER',
	           'betTWO_3_5_6_CORNERBox',
	           'betTWO_FIVE_SPLIT',
	           'betTWO_FIVE_SPLITBox',
	           'betTWO_THREE_SPLIT',
	           'betTWO_THREE_SPLITBox',
	           'betTWO',
	           'betTWOBox',
	           'betZERO_00_2_BASKET',
	           'betZERO_00_2_BASKETBox',
	           'betZERO_1_2_BASKET',
	           'betZERO_1_2_BASKETBox',
	           'betZERO',
	           'betZEROBox'
	           ];
	for(var i = 0; i < ids.length; i++){
		if(dojo.byId(ids[i]) != null){
			dojo.byId(ids[i]).style.border='1px solid white';
		}
	}
}

	/*** Dojo The Definite Guide, p26 ***/
	//var handle = dojo.connect(
	//		dojo.byId("s1"), //context
	//		"onmouseover", //event
	//		null, //context
	//		function(evt) {console.log("mouseover event", evt);} //event
	//		);
	//dojo.disconnect(handle); //avoid memory leak
	
	/*** Dojo The Definite Guide, p27 ***/
	//dojo.query("div"); //find all of the div elements in the DOM
	//dojo.query("div#d2"); //check for the existence of a div with id=d2
	//dojo.query(".blue"); //returns a list of elements that have the blue class applied.
	//dojo.addClass("s1", "blue"); //add the blue class to the SPAN
	//dojo.query("span.blue"); //returns only span elements with the blue class applied

	//dojo.removeClass("node", "css_class1 css_class2 css_classn");

	/*** Dojo The Definite Guide, p56 ***/
	//dojo.style("myId", {
	//height : "100px",
	//width : "100px",
	//border : "1px green"
	//});

	/*** Dojo The Definite Guide, p57 ***/
	//dojo.style(/*DomNode|String*/ node, /*String?|Object?*/style, on a node. /*String?*/value); 
	//dojo.hasClass(/*DomNode*/node, /*String*/classString);
	//dojo.addClass(/*DomNode*/node, /*String*/classString); 
	//dojo.removeClass(/*DomNode*/node, /*String*/classString); 
	//dojo.toggleClass(/*DomNode*/node, /*String*/classString);

	/*** Dojo The Definite Guide, p63 ***/
	//dojo.cookie("foo","bar", {expires : 30});
	//set a foo/bar key-value pair to expire 30 days from now
	//dojo.cookie("foo"); //get back the value for foo, which is bar

	/*** Dojo The Definite Guide, p82 ***/
	//dojo.fromJson(/*String*/ json); //Returns Object
	//dojo.toJson(/*Object*/ json, /*Boolean?*/ prettyPrint); //Returns String
	
	/*
		Syntax Meaning Example
		* Any element dojo.query("*")
		E Elements of type E dojo.query("div")
		.C Elements with class C dojo.query(".baz")
		E.C Elements of type E having class C dojo.query("div.baz")
		#ID Element with ID ID dojo.query("#quux")
		E#ID Element of type E with ID ID dojo.query("div#quux)
		[A] Elements with attribute A dojo.query("[foo]")
		E[A] Elements of type E with attribute A dojo.query("div[foo]")
		[A="V"] Elements with attribute A having value “V” dojo.query("[foo='bar']")
		E[A~='V'] Elements of type E having a list of space separated dojo.query("div[foo~='bar']")
		          attributes, one of which is exactly equal to “V” 
		E[A^='V'] Elements of type E having an attribute that begins with “V” dojo.query("div[foo^='bar']")
		E[A$='V'] Elements of type E having an attribute that ends with “V” dojo.query("div[foo$='bar']")
		E[A*='V'] Elements of type E having an attribute that contains the dojo.query("div[foo*='bar']")
		          substring “V” 
		, Boolean OR dojo.query("div,span.baz")
		E > F Element F is a child of element E dojo.query("div > span")
		E F Element F is an arbitrary descendant of element E dojo.query("E F")
		
		function Message(){
			this._m='test message works!';
			this.getMessage=this._m;
		}
		
		function doSomething(){
			var message = new Message(); console.log("mesage... " + message.getMessage); Dojo the Definite Guide, p.71
		}

		
	 */
	
	/* ...the onsubmit handler must return false when the event handler is executing. *
	 * This informs the browser that the form should not be submitted back to the     *
	 * server, which would trigger a full-page refresh and interrupt our JavaScript   *
	 * programming of the form. (from Ajax In Action, p.474)                          */
