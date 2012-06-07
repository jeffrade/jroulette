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
		<h1 align="center">Change Password</h1>
		<br/>
		<div style="color:rgb(255,50,50);">
			<c:choose>
				<c:when test='${ERROR_MESSAGES != null}'>
					<p>${ERROR_MESSAGES}</p>
				</c:when>
			</c:choose>
		</div>
		<br/>
		<br/>
		<div align="center">
			<form method="post" name="ChangePassword">
				<div style="padding:8px;">User Name: <input type="text" name="email" value="${userName}" disabled="disabled"/></div>
				<div style="padding:8px;">
					<fmt:message key="user2.password" />
					<spring:bind path="user2.password" >
						<input type="password" name="password" value="<c:out value="${status.value}"/>" />
	               		<font color="red"><c:out value="${status.errorMessage}"/></font>
	           		</spring:bind>
           		</div>
				<div style="padding:8px;">
					<fmt:message key="user2.newPassword" />
           			<spring:bind path="user2.newPassword" >
						<input type="password" name="newPassword" value="<c:out value="${status.value}"/>" />
               			<font color="red"><c:out value="${status.errorMessage}"/></font>
           			</spring:bind>
				</div>
				<div style="padding:8px;">
					<fmt:message key="user2.verify.newPassword" />
					<spring:bind path="user2.verifyNewPassword" >	
						<input type="password" name="verifyNewPassword" value="<c:out value="${status.value}"/>" />
						<font color="red"><c:out value="${status.errorMessage}"/></font>
					</spring:bind>
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