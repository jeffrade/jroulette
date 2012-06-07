<%@ page import="com.rade.jeff.main.data.JRouletteBean" %>
<%@ page import="com.rade.jeff.main.JRouletteGame" %>
<%
	JRouletteGame game = (JRouletteGame) request.getSession().getAttribute("game");
	JRouletteBean bean = (JRouletteBean) request.getSession().getAttribute("bean");
	String m = game.getColorAndNumberHistory(bean.getCasino());
%>
<%=m%>