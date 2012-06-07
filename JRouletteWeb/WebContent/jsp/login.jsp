	<%@ page import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter" %>
	<%@ page import="org.springframework.security.ui.AbstractProcessingFilter" %>
	<%@ page import="org.springframework.security.AuthenticationException" %>
	<head>
		<title>JRoulette - Free Casino Roulette Game</title>
		<link rel="stylesheet" href="styles/core.css" type="text/css" />
		<style type="text/css">
	        @import "js/dojo-release-1.5.0/dijit/themes/tundra/tundra.css"
        	@import "js/dojo-release-1.5.0/dojo/resources/dojo.css"
    	</style>
    	<script type="text/javascript" src="js/dojo-release-1.5.0/dojo/dojo.js" djConfig="parseOnLoad:true"></script>
    	<script type="text/javascript">
    		dojo.addOnLoad(
    				function validatePasswordChange(){ // FIXME p jserrors element won't go away after 
    					var email = dojo.byId('email');
    					var password = dojo.byId('password');
    					dojo.byId('jserrors').innerHTML = ''; //FIXME this should work, probably does

    					if(!lengthAtLeast(email,5)){
    						dojo.byId('jserrors').innerHTML = 'You must enter an email address';
    						console.log('!lengthAtLeast(email,5)');
    						return false;
    					} else if(!lengthAtLeast(password,6)){ //FIXME why does this still show?
    						dojo.byId('jserrors').innerHTML = 'Password must be at least 6 characters long!';
    						console.log('!lengthAtLeast(password,6)');
    						return false;
    					} else {
    						return true;
    						console.log('return true');
    					}

    					function lengthAtLeast(e,l){return e != null && e.value.length >= l;}
    				}
    		);
    	</script>
	</head>
	<body class="tundra">
		<%@ include file="/tiles/menu.jsp" %>
		<h1 align="center">Registration</h1>
		<br/>
		<br/>
		<div style="color:rgb(255,50,50);">
			<c:choose>
				<c:when test='${failedLoginAttempt == "1"}'>
					<p id="errors">No user with that email or password was incorrect  -  <a href="forgotPassword.htm">Forgot Password?</a></p>
					<p id="jserrors"></p>
				</c:when>
			</c:choose>
		</div>
		<br/>
		<br/>
		<div align="center">
			<!-- 
			<form method="post" onsubmit="return validatePasswordChange();">
				<div style="padding:5px;">Email: <input id="email" type="text" name="email" value="${email}"/></div>
				<div style="padding:5px;">Password: <input id="password" type="password" name="password" /></div>
				<div style="padding:5px;"><input type="submit" value="LOGIN"/></div>
			</form>
			 -->
			<form action="j_spring_security_check">
				<div style="padding:5px;">
					<label for="j_username">Email: </label>
					<input id="email" type="text" name="j_username" value="${email}"/>
				</div>
				<div style="padding:5px;">
					<label for="j_password">Password: </label>
					<input id="password" type="password" name="j_password" />
				</div>
				<div style="padding:5px;">
					<input type="checkbox" name="_spring_security_remember_me" />Remember me on this computer
				</div>
				<div style="padding:5px;">
					<input type="submit" value="LOGIN"/>
				</div>
			</form>
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