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
		<h1 align="center"><spring:message code="playerBean.title"/></h1>
		<br/>
		<br/>
		<br/>
		<form method="post" name="roulettePlayer">
			<div class="clearBoth align_center">
				<input type="text" name="userName" value="${userName}" size="20" maxlength="20" disabled="disabled"/>
			</div>
			<div class="clearBoth align_center">
				<input type="text" name="email" value="${email}" size="20" maxlength="50" disabled="disabled"/>
			</div>
			<div class="clearBoth align_center">
				<fmt:message key="playerBean.money"/>
	           	<spring:bind path="playerBean.money">
	            	<input type="text" name="money" value="<c:out value="${status.value}"/>" size="20" maxlength="20" />
	               	<font color="red"><c:out value="${status.errorMessage}"/></font>
	           	</spring:bind>
			</div>
		    <div class="clearBoth align_center">
		    	<fmt:message key="playerBean.table"/>
				<spring:bind path="playerBean.table">
		        	American<input type="radio" name="table" value="AMERICAN" checked="checked"/>
		            &nbsp;
		            European (Coming Soon)<input type="radio" name="table" value="EUROPEAN" disabled="disabled"/>
		            <font color="red"><c:out value="${status.errorMessage}"/></font>
				</spring:bind>
			</div>
		    <div class="clearBoth align_center"><input class="hover" type="submit" value="<fmt:message key="personBean.submit"/>"/></div>
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