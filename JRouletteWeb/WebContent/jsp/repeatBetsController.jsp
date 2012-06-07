<%@ page import="com.rade.jeff.main.data.JRouletteBean" %>
<%@ page import="com.rade.jeff.main.JRouletteGame" %>
<%@ page import="com.rade.jeff.main.data.Bet" %>
<%
JRouletteGame game = (JRouletteGame) request.getSession().getAttribute("game");
JRouletteBean bean = (JRouletteBean) request.getSession().getAttribute("bean");
%>
<%=game.repeatBets(bean.getPlayer()) ? "T" : "F"%>