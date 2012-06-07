<%@ page import="com.rade.jeff.main.data.JRouletteBean" %>
<%@ page import="com.rade.jeff.main.JRouletteGame" %>
<%@ page import="java.util.List" %>
<%
	JRouletteGame game = (JRouletteGame) request.getSession().getAttribute("game");
	JRouletteBean bean = (JRouletteBean) request.getSession().getAttribute("bean");
	
	List<String> nl = game.getNumberHistoryList(bean.getCasino());
	StringBuilder message = new StringBuilder();
	for(String n : nl){
		if("37".equals(n)){
			message.append("00");	
		} else{
			message.append(n.trim());	
		}
		message.append("|");
	}
%>
<%=message%>