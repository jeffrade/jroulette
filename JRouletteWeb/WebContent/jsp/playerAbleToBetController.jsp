<%@ page import="com.rade.jeff.main.data.JRouletteBean" %>
<%@ page import="com.rade.jeff.main.JRouletteGame" %>
<%@ page import="com.rade.jeff.main.data.Bet" %>
<%
JRouletteGame game = (JRouletteGame) request.getSession().getAttribute("game");
JRouletteBean bean = (JRouletteBean) request.getSession().getAttribute("bean");

boolean ableToBetAgain = game.isPlayerAbleToBet(bean.getPlayer());
%>
<%=String.valueOf(ableToBetAgain)%>