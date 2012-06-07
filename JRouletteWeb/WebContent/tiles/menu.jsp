<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>
<div id="menu">
	<a class="menu-item" href="index.htm">Home</a>
	<a class="menu-item" href="play.htm">Play</a>
	<c:choose>
		<c:when test='${isRegistered == "1"}'>
			<a class="menu-item" href="create.htm">Create Game</a>
		</c:when>
	</c:choose>
	<a class="menu-item" href="howtoplay.htm">How To Play</a>
	<a class="menu-item" href="info.htm?type=news">News</a>
	<a class="menu-item" href="info.htm?type=strategy">Learn</a>
	<a class="menu-item" href="support.htm">Support</a>
	<a class="menu-item" href="about.htm">About</a>
	<c:choose>
		<c:when test='${isRegistered == "1" && JROULETTE_USER != null}'>
			<a class="menu-item" href="logout.htm">Sign Out</a>
			<a href="settings.htm" style="color:white;font-size:13px;padding-left:0px;margin:0px;">(${JROULETTE_USER.userName})</a>
			<!-- TODO: need logic to substring userName if too long -->
		</c:when>
		<c:otherwise>
			<a class="menu-item" href="signin.htm">Sign In</a>
		</c:otherwise>
	</c:choose>
	
</div>
<div align="left" id="social-box">
	<div class="social-site-item" style="clear:both;padding-top:2px;padding-bottom:2px;">
		<iframe src="http://platform.twitter.com/widgets/tweet_button.html"
			allowtransparency="true"
			frameborder="0" 
			scrolling="no" 
			style="height:25px;">
		</iframe>
	</div>
	<div class="social-site-item" style="clear:both;padding-top:2px;padding-bottom:2px;">
		<iframe src="http://www.facebook.com/plugins/like.php?href=jroulette.net"
			scrolling="no" 
			frameborder="0" 
			style="border:none;height:30px;">
		</iframe>
	</div>
</div>