<% 
	request.getSession().setAttribute("isRegistered", "0");
	request.getSession().setAttribute("JROULETTE_USER", null);
	request.getSession().invalidate(); 
%>
<script type="text/javascript">
	window.location='index.htm';
</script>