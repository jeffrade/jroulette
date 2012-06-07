	<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>
	<head>
		<title>JRoulette - Free Casino Roulette Game</title>
		<link rel="stylesheet" href="styles/core.css" type="text/css" />
		<link rel="stylesheet" href="styles/table_new.css" type="text/css" />
		<link rel="stylesheet" href="styles/game_new.css" type="text/css" />
		<style type="text/css">
	        @import "js/dojo-release-1.5.0/dijit/themes/tundra/tundra.css"
        	@import "js/dojo-release-1.5.0/dojo/resources/dojo.css"
    	</style>
		<script type="text/javascript" src="js/game_new.js"></script>
		<script type="text/javascript" src="js/dojo-release-1.5.0/dojo/dojo.js" djConfig="parseOnLoad:true"></script>
		<script type="text/javascript"> 
        	dojo.require("dojo.parser"); // Is this needed?
        	dojoAddOnLoad();
		</script>
	</head>
	<body class="tundra" onLoad="javascript:init();">
	<%@ include file="/tiles/menu.jsp" %>
	<div id="table" class='relative'>
		<img id="table-image" src="images/roulette-table.gif" class="relative"/>
		<div id="game_over_box" class="relative hidden brown_border white black_bg align_center">
			<div class="white clear_both">GAME OVER</div>
			<a id="game_over_box_quick" href="javascript:window.location='quick_new.htm';" class="relative no_decor white">Quick Play</a>&nbsp;&nbsp;&nbsp;
			<a id="game_over_box_custom" href="create.htm" class="relative no_decor white">Create Game</a>&nbsp;&nbsp;&nbsp;
			<a id="game_over_box_quit" href="thanks.htm" class="relative no_decor white">Quit</a>
		</div>
		<div id="history_board_box" class="brown_border absolute"><%@ include file="history_board.jsp" %></div>	
		<textarea id="message-box" class="brown_border absolute" readonly="readonly" style="resize:none;">&nbsp;</textarea>
		<div id="current_bet_box" class="absolute align_center black_bg brown_border white big_margin largefont valign_center">&nbsp;</div>
		<!-- Bets -->
		<div id="betRED" class="colorSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="REDBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betBLACK" class="colorSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="BLACKBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		
		<div id="betONE_4_SIXLINE" class="three6col sixline_row intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="ONE_4_SIXLINEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFOUR_7_SIXLINE" class="six9col sixline_row intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FOUR_7_SIXLINEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSEVEN_10_SIXLINE" class="nine12col sixline_row intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SEVEN_10_SIXLINEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTEN_13_SIXLINE" class="twelve15col sixline_row intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TEN_13_SIXLINEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTEEN_16_SIXLINE" class="fifteen18col sixline_row intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTEEN_16_SIXLINEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSIXTEEN_19_SIXLINE" class="eighteen21col sixline_row intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SIXTEEN_19_SIXLINEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betNINETEEN_22_SIXLINE" class="twentyone24col sixline_row intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="NINETEEN_22_SIXLINEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_TWO_25_SIXLINE" class="twentyfour27col sixline_row intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_TWO_25_SIXLINEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_FIVE_28_SIXLINE" class="twentyseven30col sixline_row intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_FIVE_28_SIXLINEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_EIGHT_31_SIXLINE" class="thirty33col sixline_row intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_EIGHT_31_SIXLINEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTY_ONE_34_SIXLINE" class="thirtythree36col sixline_row intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div> 
		<div id="THIRTY_ONE_34_SIXLINEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		 
		<div id="betODDS" class="colorSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="ODDSBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betEVENS" class="colorSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="EVENSBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		
		<div id="betZERO" class="numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="ZEROBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betDOUBLE_ZERO" class="numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="DOUBLE_ZEROBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betBOTH_ZEROS" class="horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="BOTH_ZEROSBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		
		<div id="betFIRST_18" class="colorSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FIRST_18Box" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betLAST_18" class="colorSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="LAST_18Box" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		 
		<div id="betFIRST_DOZEN" class="dozenbetsrow firstdozencol dozenbetsize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FIRST_DOZENBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSECOND_DOZEN" class="dozenbetsrow seconddozencol dozenbetsize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SECOND_DOZENBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRD_DOZEN" class="dozenbetsrow thirddozencol dozenbetsize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRD_DOZENBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		
		<div id="betFIRST_COLUMN" class="columnbetscol row3 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FIRST_COLUMNBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSECOND_COLUMN" class="columnbetscol row2 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SECOND_COLUMNBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRD_COLUMN" class="columnbetscol row1 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRD_COLUMNBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		
		<div id="betONE" class="col3 row1 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="ONEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWO" class="col3 row2 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWOBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHREE" class="col3 row3 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THREEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFOUR" class="col6 row1 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FOURBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFIVE" class="col6 row2 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FIVEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSIX" class="col6 row3 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SIXBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSEVEN" class="col9 row1 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SEVENBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betEIGHT" class="col9 row2 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="EIGHTBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betNINE" class="col9 row3 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="NINEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTEN" class="col12 row1 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TENBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betELEVEN" class="col12 row2 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="ELEVENBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWELVE" class="col12 row3 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWELVEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTEEN" class="col15 row1 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTEENBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFOURTEEN" class="col15 row2 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FOURTEENBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFIFTEEN" class="col15 row3 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FIFTEENBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSIXTEEN" class="col18 row1 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SIXTEENBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSEVENTEEN" class="col18 row2 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SEVENTEENBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betEIGHTEEN" class="col18 row3 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="EIGHTEENBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betNINETEEN" class="col21 row1 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="NINETEENBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY" class="col21 row2 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTYBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_ONE" class="col21 row3 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_ONEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_TWO" class="col24 row1 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_TWOBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_THREE" class="col24 row2 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_THREEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_FOUR" class="col24 row3 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_FOURBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_FIVE" class="col27 row1 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_FIVEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_SIX" class="col27 row2 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_SIXBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_SEVEN" class="col27 row3 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_SEVENBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_EIGHT" class="col30 row1 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_EIGHTBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_NINE" class="col30 row2 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_NINEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTY" class="col30 row3 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTYBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHRITY_ONE" class="col33 row1 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THRITY_ONEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHRITY_TWO" class="col33 row2 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THRITY_TWOBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHRITY_THREE" class="col33 row3 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THRITY_THREEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHRITY_FOUR" class="col36 row1 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THRITY_FOURBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHRITY_FIVE" class="col36 row2 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THRITY_FIVEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHRITY_SIX" class="col36 row3 numSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THRITY_SIXBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		
		<div id="betONE_TWO_SPLIT" class="rowOne2 col3 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="ONE_TWO_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWO_THREE_SPLIT" class="rowTwo3 col3 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWO_THREE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div> 
		<div id="betONE_FOUR_SPLIT" class="rowi1 three6col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="ONE_FOUR_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWO_FIVE_SPLIT" class="rowi2 three6col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWO_FIVE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHREE_SIX_SPLIT" class="rowi3 three6col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THREE_SIX_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFOUR_FIVE_SPLIT" class="rowOne2 col6 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FOUR_FIVE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFIVE_SIX_SPLIT" class="rowTwo3 col6 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FIVE_SIX_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSEVEN_EIGHT_SPLIT" class="rowOne2 col9 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SEVEN_EIGHT_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betEIGHT_NINE_SPLIT" class="rowTwo3 col9 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="EIGHT_NINE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTEN_ELEVEN_SPLIT" class="rowOne2 col12 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TEN_ELEVEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betELEVEN_TWELVE_SPLIT" class="rowTwo3 col12 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="ELEVEN_TWELVE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTEEN_FOURTEEN_SPLIT" class="rowOne2 col15 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTEEN_FOURTEEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFOURTEEN_FIFTEEN_SPLIT" class="rowTwo3 col15 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FOURTEEN_FIFTEEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSIXTEEN_SEVENTEEN_SPLIT" class="rowOne2 col18 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SIXTEEN_SEVENTEEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSEVENTEEN_EIGHTEEN_SPLIT" class="rowTwo3 col18 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SEVENTEEN_EIGHTEEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betNINTEEN_TWENTY_SPLIT" class="rowOne2 col21 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="NINTEEN_TWENTY_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_TWENTY_ONE_SPLIT" class="rowTwo3 col21 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_TWENTY_ONE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_TWO_TWENTY_THREE_SPLIT" class="rowOne2 col24 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_TWO_TWENTY_THREE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_THREE_TWENTY_FOUR_SPLIT" class="rowTwo3 col24 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_THREE_TWENTY_FOUR_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_FIVE_TWENTY_SIX_SPLIT" class="rowOne2 col27 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_FIVE_TWENTY_SIX_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_SIX_TWENTY_SEVEN_SPLIT" class="rowTwo3 col27 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_SIX_TWENTY_SEVEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_EIGHT_TWETNY_NINE_SPLIT" class="rowOne2 col30 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_EIGHT_TWETNY_NINE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_NINE_THIRTY_SPLIT" class="rowTwo3 col30 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_NINE_THIRTY_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTY_ONE_THIRTY_THRITY_TWO_SPLIT" class="rowOne2 col33 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTY_ONE_THIRTY_THRITY_TWO_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHRITY_TWO_THIRTY_THREE_SPLIT" class="rowTwo3 col33 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THRITY_TWO_THIRTY_THREE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHRITY_FOUR_THIRTY_FIVE_SPLIT" class="rowOne2 col36 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THRITY_FOUR_THIRTY_FIVE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTY_FIVE_THIRTY_SIX_SPLIT" class="rowTwo3 col36 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTY_FIVE_THIRTY_SIX_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFOUR_SEVEN_SPLIT" class="rowi1 six9col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FOUR_SEVEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFIVE_EIGHT_SPLIT" class="rowi2 six9col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FIVE_EIGHT_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSIX_NINE_SPLIT" class="rowi3 six9col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SIX_NINE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSEVEN_TEN_SPLIT" class="rowi1 nine12col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SEVEN_TEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betEIGHT_ELEVEN_SPLIT" class="rowi2 nine12col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="EIGHT_ELEVEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betNINE_TWELVE_SPLIT" class="rowi3 nine12col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="NINE_TWELVE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTEN_THIRTEEN_SPLIT" class="rowi1 twelve15col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TEN_THIRTEEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betELEVEN_FOURTEEN_SPLIT" class="rowi2 twelve15col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="ELEVEN_FOURTEEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWELVE_FIFTEEN_SPLIT" class="rowi3 twelve15col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWELVE_FIFTEEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTEEN_SIXTEEN_SPLIT" class="rowi1 fifteen18col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTEEN_SIXTEEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFOURTEEN_SEVENTEEN_SPLIT" class="rowi2 fifteen18col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FOURTEEN_SEVENTEEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFIFTEEN_EIGHTEEN_SPLIT" class="rowi3 fifteen18col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FIFTEEN_EIGHTEEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSIXTEEN_NINETEEN_SPLIT" class="rowi1 eighteen21col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SIXTEEN_NINETEEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSEVENTEEN_TWENTY_SPLIT" class="rowi2 eighteen21col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SEVENTEEN_TWENTY_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betEIGHTEEN_TWENTY_ONE_SPLIT" class="rowi3 eighteen21col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="EIGHTEEN_TWENTY_ONE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betNINETEEN_TWENTY_TWO_SPLIT" class="rowi1 twentyone24col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="NINETEEN_TWENTY_TWO_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_TWENTY_THREE_SPLIT" class="rowi2 twentyone24col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_TWENTY_THREE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_ONE_TWENTY_FOUR_SPLIT" class="rowi3 twentyone24col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_ONE_TWENTY_FOUR_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_TWO_TWENTY_FIVE_SPLIT" class="rowi1 twentyfour27col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_TWO_TWENTY_FIVE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_THREE_TWENTY_SIX_SPLIT" class="rowi2 twentyfour27col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_THREE_TWENTY_SIX_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_FOUR_TWENTY_SEVEN_SPLIT" class="rowi3 twentyfour27col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_FOUR_TWENTY_SEVEN_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_FIVE_TWENTY_EIGHT_SPLIT" class="rowi1 twentyseven30col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_FIVE_TWENTY_EIGHT_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_SIX_TWENTY_NINE_SPLIT" class="rowi2 twentyseven30col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_SIX_TWENTY_NINE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_SEVEN_THIRTY_SPLIT" class="rowi3 twentyseven30col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_SEVEN_THIRTY_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_EIGHT_THIRTY_ONE_SPLIT" class="rowi1 thirty33col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_EIGHT_THIRTY_ONE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_NINE_THRITY_TWO_SPLIT" class="rowi2 thirty33col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_NINE_THRITY_TWO_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTY_THIRTY_THREE_SPLIT" class="rowi3 thirty33col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTY_THIRTY_THREE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTY_ONE_THIRTY_FOUR_SPLIT" class="rowi1 thirtythree36col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTY_ONE_THIRTY_FOUR_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTY_TWO_THIRTY_FIVE_SPLIT" class="rowi2 thirtythree36col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTY_TWO_THIRTY_FIVE_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTY_THREE_THIRTY_SIX_SPLIT" class="rowi3 thirtythree36col verSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTY_THREE_THIRTY_SIX_SPLITBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		
		<div id="betONE_TWO_THREE_STREET" class="sixline_row col3 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="ONE_TWO_THREE_STREETBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFOUR_FIVE_SIX_STREET" class="sixline_row col6 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FOUR_FIVE_SIX_STREETBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSEVEN_EIGHT_NINE_STREET" class="sixline_row col9 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SEVEN_EIGHT_NINE_STREETBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTEN_ELEVEN_TWELVE_STREET" class="sixline_row col12 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TEN_ELEVEN_TWELVE_STREETBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTEEN_FOURTEEN_FIFTEEN_STREET" class="sixline_row col15 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTEEN_FOURTEEN_FIFTEEN_STREETBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSIXTEEN_SEVENTEEN_EIGHTEEN_STREET" class="sixline_row col18 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SIXTEEN_SEVENTEEN_EIGHTEEN_STREETBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betNINETEEN_TWENTY_TWENTY_ONE_STREET" class="sixline_row col21 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="NINETEEN_TWENTY_TWENTY_ONE_STREETBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_TWO_TWENTY_THREE_TWENTY_FOUR_STREET" class="sixline_row col24 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_TWO_TWENTY_THREE_TWENTY_FOUR_STREETBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_FIVE_TWENTY_SIX_TWENTY_SEVEN_STREET" class="sixline_row col27 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_FIVE_TWENTY_SIX_TWENTY_SEVEN_STREETBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_EIGHT_TWENTY_NINE_THIRTY_STREET" class="sixline_row col30 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_EIGHT_TWENTY_NINE_THIRTY_STREETBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTY_ONE_THIRTY_TWO_THIRTY_THREE_STREET" class="sixline_row col33 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTY_ONE_THIRTY_TWO_THIRTY_THREE_STREETBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTY_FOUR_THRITY_FIVE_THIRTY_SIX_STREET" class="sixline_row col36 horSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTY_FOUR_THRITY_FIVE_THIRTY_SIX_STREETBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		
		<div id="betONE_2_4_5_CORNER" class="rowOne2 three6col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="ONE_2_4_5_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWO_3_5_6_CORNER" class="rowTwo3 three6col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWO_3_5_6_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFOUR_5_7_8_CORNER" class="rowOne2 six9col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FOUR_5_7_8_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFIVE_6_8_9_CORNER" class="rowTwo3 six9col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FIVE_6_8_9_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSEVEN_8_10_11_CORNER" class="rowOne2 nine12col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SEVEN_8_10_11_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betEIGHT_9_11_12_CORNER" class="rowTwo3 nine12col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="EIGHT_9_11_12_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTEN_11_13_14_CORNER" class="rowOne2 twelve15col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TEN_11_13_14_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betELEVEN_12_14_15_CORNER" class="rowTwo3 twelve15col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="ELEVEN_12_14_15_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTEEN_14_16_17_CORNER" class="rowOne2 fifteen18col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTEEN_14_16_17_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betFOURTEEN_15_17_18_CORNER" class="rowTwo3 fifteen18col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="FOURTEEN_15_17_18_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSIXTEEN_17_19_20_CORNER" class="rowOne2 eighteen21col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SIXTEEN_17_19_20_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betSEVENTEEN_18_20_21_CORNER" class="rowTwo3 eighteen21col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="SEVENTEEN_18_20_21_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betNINETEEN_20_22_23_CORNER" class="rowOne2 twentyone24col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="NINETEEN_20_22_23_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_21_23_24_CORNER" class="rowTwo3 twentyone24col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_21_23_24_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_TWO_23_25_26_CORNER" class="rowOne2 twentyfour27col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_TWO_23_25_26_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_THREE_24_26_27_CORNER" class="rowTwo3 twentyfour27col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_THREE_24_26_27_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_FIVE_26_28_29_CORNER" class="rowOne2 twentyseven30col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_FIVE_26_28_29_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_SIX_27_29_30_CORNER" class="rowTwo3 twentyseven30col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_SIX_27_29_30_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_EIGHT_29_31_32_CORNER" class="rowOne2 thirty33col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_EIGHT_29_31_32_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTWENTY_NINE_30_32_33_CORNER" class="rowTwo3 thirty33col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TWENTY_NINE_30_32_33_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTY_ONE_32_34_35_CORNER" class="rowOne2 thirtythree36col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTY_ONE_32_34_35_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTHIRTY_TWO_33_35_36_CORNER" class="rowTwo3 thirtythree36col intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="THIRTY_TWO_33_35_36_CORNERBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betZERO_1_2_BASKET" class="intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="ZERO_1_2_BASKETBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betZERO_00_2_BASKET" class="intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="ZERO_00_2_BASKETBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betDOUBLE_ZERO_2_3_BASKET" class="intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="DOUBLE_ZERO_2_3_BASKETBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<div id="betTOPLINE" class="intSize hover absolute" onclick="javascript:placeBet(this.id)" onmouseover="javascript:showByMouseRemove(this.id+'Box','bet')" onmouseout="javascript:hideRemove(this.id+'Box','bet')"></div>
		<div id="TOPLINEBox" class="hidden black_bg brown_border white medfont align_center valign_center absolute"></div>
		<!-- Buttons -->
		<div id="chip_buttons" class="relative">
			<img src="images/blue-chip.gif" class="chip hover" onclick="javascript:chooseAmount(1);"/>
			<img src="images/red-chip.gif" class="chip hover" onclick="javascript:chooseAmount(5);"/>
			<img src="images/black-chip.gif" class="chip hover" onclick="javascript:chooseAmount(10);"/>
			<img src="images/green-chip.gif" class="chip hover" onclick="javascript:chooseAmount(25);"/>
			<img src="images/yellow-chip.gif" class="chip hover" onclick="javascript:chooseAmount(100);"/>
		</div>
		<div id="game_buttons" class="relative">
			<table>
				<tr>
					<!-- 
					<td><div id="spinButton" class="game-button brown_border" onclick="javascript:spin();" >Spin</div></td>					
					<td><div id="repeatButton" class="game-button brown_border" onclick="javascript:repeat();" >Repeat Bets</div></td>
					<td><div id="clearButton" class="game-button brown_border" onclick="javascript:deleteBets();" >Clear Bets</div></td>
					-->
					<td>
						<img id="spinButton" class="hover" src="images/spin.png" onmouseover="this.src='images/spin-mo.png';" onmouseout="this.src='images/spin.png';" onclick="javascript:spin();" />
						<img id="repeatButton" class="hover" src="images/repeat.png" onmouseover="this.src='images/repeat-mo.png';" onmouseout="this.src='images/repeat.png';" onclick="javascript:repeat();" />
						<img id="clearButton" class="hover" src="images/clear.png" onmouseover="this.src='images/clear-mo.png';" onmouseout="this.src='images/clear.png';" onclick="javascript:deleteBets();" />
						<img id="newGameButton" class="hover" src="images/new.png" onmouseover="this.src='images/new-mo.png';" onmouseout="this.src='images/new.png';" onclick="javascript:window.location='jroulette.htm?g=new';" />
					</td>
				</tr>
				<tr>
					<td>
						<div id="player_name" class="brown_border" style="color:white;padding:5px;margin-bottom:5px;">Player:&nbsp;<c:out value="${bean.player.name}"/></div>
						<div id="player_money" class="brown_border" style="color:white;padding:5px;margin-bottom:5px;">Money:&nbsp;$<c:out value="${bean.player.playerBank.totalMoney}"/></div>
					</td>
					<!-- 
					<td><div id="newGameButton" class="game-button brown_border" onclick="javascript:window.location='jroulette.htm?g=new';">New Game</div></td>
					<td>&nbsp;</td>
					-->
				</tr>
			</table>
		</div>
		<img id="wheel-spinning" class="absolute brown_border" src="images/animated-roulette-wheel-black.gif"/>
	</div><!-- ############ End of "table" div ############ -->
	<div id="marker" class="absolute" style="visibility:hidden;">
		<img id="marker-img" src="images/marker3.gif" height="31.73" width="13" /><!-- needs to stay outside of table div -->
	</div>
	<div align="center"> 
    	<h4 style="margin:2px;padding:2px;">Partners</h4> 
        <p style="margin:1px;padding:1px;"><a href=" http://thunderstruck2.org" target="_new">thunderstruck 2 slot</a></p> 
        <p style="margin:1px;padding:1px;"><a href="http://www.casinosdiary.com" target="_new" title="A complete source for information latest news and reviews of online casinos.">Online Casino USA</a></p> 
        <p style="margin:1px;padding:1px;"><a href="http://italiano.thebonuscasinos.com" target="_new" title="Choose the best online casino sites.We provides you complete information about online casino gaming and online casinos reviews and online poker rooms on the internet.">casino</a></p> 
    </div> 
	<span id="sound-wheel"></span>
	<span id="sound-coin"></span>
	<span id="sound-win"></span>
	<br/>
	<br/>
	<%@include file="/tiles/footer-table.jsp"%>
	<!-- 
	<div id="ie_browser_message" class="hidden brown_border white black_bg" style="font-size:15px;width:400px;height:100px;">
		<p>Sorry, but this game is not supported in Internet Explorer at the moment.</p>
		<p>Please try another browser, like <a href="http://mozilla.com/firefox" target="_new">FireFox</a> or <a href="http://www.google.com/chrome" target="_new">Google's Chrome</a></p>
	</div>
	-->