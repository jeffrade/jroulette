<%@ page import="com.rade.jeff.main.data.JRouletteBean" %>
<%@ page import="com.rade.jeff.main.JRouletteGame" %>
<%@ page import="java.util.List" %>
<%
	JRouletteGame game = (JRouletteGame) request.getSession().getAttribute("game");
	JRouletteBean bean = (JRouletteBean) request.getSession().getAttribute("bean");
	
	List<String> cl = game.getColorHistoryList(bean.getCasino());
	StringBuilder message = new StringBuilder();
	for(String c : cl){
		message.append(c.trim());
		message.append("|");
	}
%>
<%=message%>