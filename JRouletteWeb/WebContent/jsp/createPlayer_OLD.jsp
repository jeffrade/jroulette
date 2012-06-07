<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>
	<head>
		<title>JRoulette - Free Casino Roulette Game</title>
		<link rel="stylesheet" href="styles/core.css" type="text/css" />
		<style type="text/css">
	        @import "js/dojo-release-1.5.0/dijit/themes/tundra/tundra.css"
        	@import "js/dojo-release-1.5.0/dojo/resources/dojo.css"
    	</style>
	</head>
	<body class="tundra">
		<%@ include file="/tiles/menu.jsp" %>
		<h1 align="center">Registration</h1>
		<br/>
		<br/>
		<br/>
		<form method="post" onsubmit="return validateCreatePlayer(this);">
			<div style="padding:5px;"><h3>Create Your Game</h3></div>
			<div style="padding:5px;">User Name:&nbsp;<input type="text" name="userName" value="${userName}" size="20" maxlength="20" disabled="disabled"/></div>
			<div style="padding:5px;">Email:&nbsp;<input type="text" name="email" value="${email}" size="20" maxlength="50" disabled="disabled"/></div>
			<div style="padding:5px;">Money:&nbsp;<input type="text" name="money" size="20" maxlength="20"/></div>
		    <div style="padding:5px;">
		        American<input type="radio" name="table_amer" value="AMERICAN" checked="checked"/>
		        &nbsp;
		    	European (Coming Soon)<input type="radio" name="table_euro" value="EUROPEAN" disabled="disabled"/>
			</div>
		    <div style="padding:5px;"><input type="submit" value="SUBMIT"/></div>
		</form>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<%@include file="/tiles/footer.jsp"%>
	</body>