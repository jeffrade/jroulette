<%@ page import="com.rade.jeff.main.data.JRouletteBean" %>
<%@ page import="com.rade.jeff.main.JRouletteGame" %>
<%@ page import="com.rade.jeff.main.data.Bet" %>
<%
JRouletteGame game = (JRouletteGame) request.getSession().getAttribute("game");
JRouletteBean bean = (JRouletteBean) request.getSession().getAttribute("bean");

int amount = Integer.valueOf(request.getParameter("betAmount").toString()).intValue();
String betName = request.getParameter("bet").toString().trim();

Bet bet = game.getBet(bean.getPlayer().getPlayerBank().getTotalMoney(), betName, amount, bean.getNumberWheelCount());
game.makeBet(bean.getPlayer(), bet);

StringBuilder message = new StringBuilder("You placed $");
message.append(amount);
message.append(" on ");
message.append(betName);
System.out.println(message.toString());
%>
<%=message.toString()%>