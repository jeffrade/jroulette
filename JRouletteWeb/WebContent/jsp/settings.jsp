	<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>
	<head>
		<title>JRoulette - Free Casino Roulette Game</title>
		<link rel="stylesheet" href="styles/core.css" type="text/css" />
		<style type="text/css">
	        @import "js/dojo-release-1.5.0/dijit/themes/tundra/tundra.css"
        	@import "js/dojo-release-1.5.0/dojo/resources/dojo.css"
    	</style>
    	<script type="text/javascript" src="js/dojo-release-1.5.0/dojo/dojo.js" djConfig="parseOnLoad:true"></script>
	</head>
	<body class="tundra">
		<%@ include file="/tiles/menu.jsp" %>
		<h1 align="center">Account Settings</h1>
		<br/>
		<br/>
		<br/>
		<div align="center">
			<a href="changePasswordPage.htm">Change</a>&nbsp;Password
			<br/>
			<br/>
			<c:choose>
				<c:when test='${IS_ACTIVE == "1"}'>
					<a href="activate.htm?active=0">Deactivate</a>&nbsp;Account
				</c:when>
				<c:otherwise>
					<a href="activate.htm?active=1">Activate</a>&nbsp;Account
				</c:otherwise>
			</c:choose>
			<br/>
			<br/>
			<c:choose>
				<c:when test='${SEND_EMAILS == "1"}'>
					<a href="sendEmailPref.htm?se=0">Unsubscribe</a>&nbsp;from email
				</c:when>
				<c:otherwise>
					<a href="sendEmailPref.htm?se=1">Subscribe</a>&nbsp;to email
				</c:otherwise>
			</c:choose>
		</div>
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
		<br/>
		<br/>
		<br/>
		<%@include file="/tiles/footer.jsp"%>
	</body>