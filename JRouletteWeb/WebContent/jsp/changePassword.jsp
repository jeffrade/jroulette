	<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>
	<head>
		<title>JRoulette - Free Casino Roulette Game</title>
		<link rel="stylesheet" href="styles/core.css" type="text/css" />
		<style type="text/css">
	        @import "js/dojo-release-1.5.0/dijit/themes/tundra/tundra.css"
        	@import "js/dojo-release-1.5.0/dojo/resources/dojo.css"
    	</style>
    	<script type="text/javascript" src="js/dojo-release-1.5.0/dojo/dojo.js" djConfig="parseOnLoad:true"></script>
    	<script type="text/javascript" src="js/validation.js"></script>
    	<script type="text/javascript">
    		dojo.addOnLoad(
    				function validatePasswordChange(){
    					var passwordField = dojo.byId('password');
    					var newPasswordField = dojo.byId('newPassword'); 
    					var retypeNewPasswordField = dojo.byId('verifyNewPassword');
    					
    					if(!lengthAtLeast(passwordField,6)){
    						dojo.byId('errors').innerHTML = 'Your current password must be 6 characters long';
    						console.log('!lengthAtLeast(passwordField,6)');
    						return false;
    					} else if(!lengthAtLeast(newPasswordField,6)){
    						dojo.byId('errors').innerHTML = 'Current Password must be at least 6 characters long!';
    						console.log('!lengthAtLeast(newPasswordField,6)');
    						return false;
    					} else if(!equal(newPasswordField,retypeNewPasswordField)){
    						dojo.byId('errors').innerHTML = 'Password fields do not match';
    						console.log('!equal(newPasswordField,retypeNewPasswordField)');
    						return false;
    					} else {
    						return true;
    					}
    					
    					function equal(e1,e2){return e1 != null && e2 != null && e1.value == e2.value;}
    					function lengthAtLeast(e,l){return e != null && e.value.length >= l;}
    				}
    		);
    	</script>
	</head>
	<body class="tundra">
		<%@ include file="/tiles/menu.jsp" %>
		<h1 align="center">Change Password</h1>
		<br/>
		<div style="color:rgb(255,50,50);">
			<c:choose>
				<c:when test='${ERROR_MESSAGES != null}'>
					<p id="errors">${ERROR_MESSAGES}</p>
				</c:when>
			</c:choose>
		</div>
		<br/>
		<br/>
		<div align="center">
			<form id="changePasswordForm" name="ChangePassword" method="post" action="changePasswordSubmit.htm" onsubmit="return validatePasswordChange();">
				<div style="padding:8px;">
					User Name: <input id="user-name" type="text" name="email" value="${userName}" disabled="disabled"/>
				</div>
				<div style="padding:8px;">
					Password: <input id="password" type="password" name="password" />
           		</div>
				<div style="padding:8px;">
					New Password: <input id="newPassword" type="password" name="newPassword" />
				</div>
				<div style="padding:8px;">
					Retype New Password: <input id="verifyNewPassword" type="password" name="verifyNewPassword" />
				</div>
				<div style="padding:5px;"><input type="submit" value="SUBMIT"/></div>
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