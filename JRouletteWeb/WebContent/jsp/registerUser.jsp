	<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>
	<head>
		<title>JRoulette - Free Casino Roulette Game</title>
		<link rel="stylesheet" href="styles/core.css" type="text/css" />
		<style type="text/css">
	        @import "js/dojo-release-1.5.0/dijit/themes/tundra/tundra.css"
        	@import "js/dojo-release-1.5.0/dojo/resources/dojo.css"
    	</style>
    	<script type="text/javascript" src="js/register.js"></script>
    	<script type="text/javascript" src="js/dojo-release-1.5.0/dojo/dojo.js" djConfig="parseOnLoad:true"></script>
	</head>
	<body class="tundra">
		<%@ include file="/tiles/menu.jsp" %>
		<h1 align="center"><spring:message code="user.title" /></h1>
		<div style="color:rgb(255,50,50);">
			<c:choose>
				<c:when test='${ERROR_MESSAGES != null}'>
					<p>${ERROR_MESSAGES}</p>
				</c:when>
			</c:choose>
		</div>
		<br/>
		<div align="center">
			<form name="JRouletteWebUser" method="post">
				<div style="padding:8px;">
					<fmt:message key="user.first.name" />
		        	<spring:bind path="user.firstName">
		        		<input type="text" name="firstName" value="<c:out value="${status.value}"/>" size="20" maxlength="20"/>
		            	<font color="red"><c:out value="${status.errorMessage}"/></font>
		        	</spring:bind>
	        	</div>
				<div style="padding-top:8px;padding-bottom:8px;">
					<fmt:message key="user.last.name" />
		        	<spring:bind path="user.lastName">
		        		<input type="text" name="lastName" value="<c:out value="${status.value}"/>" size="20" maxlength="20"/>
		            	<font color="red"><c:out value="${status.errorMessage}"/></font>
		        	</spring:bind>
	        	</div>
				<div style="padding-bottom:8px;padding-top:8px;">
					<fmt:message key="user.user.name" />
           			<spring:bind path="user.userName">
						<input id="userName" type="text" name="userName" value="<c:out value="${status.value}"/>"/>
						<font color="red"><c:out value="${status.errorMessage}"/></font>
					</spring:bind>
					<br/>
					<img class="hover" src="images/check-availability.png" onmouseover="this.src='images/check-availability-mo.png';" onmouseout="this.src='images/check-availability.png';" onclick="javascript:userNameAvailable();" style="padding-left:3px;padding-right:3px;position:relative;top:8px;padding:3px;margin:0px;" />
					<span id="usrNameInd" style="padding-left:3px;padding-right:3px;"></span>
				</div>
				<div style="padding:8px;">
					<fmt:message key="user.email" />
           			<spring:bind path="user.email">
               			<input type="text" name="email" value="<c:out value="${status.value}"/>"/>
               			<font color="red"><c:out value="${status.errorMessage}"/></font>
           			</spring:bind>
               	</div>
				<div style="padding:8px;">
					<fmt:message key="user.verify.email" />
           			<spring:bind path="user.verifyEmail">
						<input type="text" name="verifyEmail" value="<c:out value="${status.value}"/>" />
               			<font color="red"><c:out value="${status.errorMessage}"/></font>
           			</spring:bind>
               	</div>
				<div style="padding:8px;">
					<fmt:message key="user.password" />
           			<spring:bind path="user.password" >
						<input type="password" name="password" value="<c:out value="${status.value}"/>" />
               			<font color="red"><c:out value="${status.errorMessage}"/></font>
           			</spring:bind>
				</div>
				<div style="padding:8px;">
					<fmt:message key="user.verify.password" />
					<spring:bind path="user.verifyPassword" >	
						<input type="password" name="verifyPassword" value="<c:out value="${status.value}"/>" />
						<font color="red"><c:out value="${status.errorMessage}"/></font>
					</spring:bind>
				</div>
				<div style="padding:3px;">
					<input type="checkbox" name="sendEmails" /><span style="font-size:12px;">&nbsp;Yes, I would like to receive coupons from your live casino affiliates</span>
				</div>
				<div style="padding:8px;">
					<input type="submit" value="<fmt:message key="user.submit"/>"/>
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