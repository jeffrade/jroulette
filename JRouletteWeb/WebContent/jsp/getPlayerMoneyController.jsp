<%@ page import="com.rade.jeff.main.data.JRouletteBean" %>
<%
JRouletteBean bean = (JRouletteBean) request.getSession().getAttribute("bean");
%>
<%=bean.getPlayer().getPlayerBank().getTotalMoney()%>