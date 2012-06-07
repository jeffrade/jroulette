<%@ page import="com.rade.jeff.main.data.JRouletteBean" %>
<%@ page import="com.rade.jeff.main.JRouletteGame" %>
<%
JRouletteGame game = (JRouletteGame) request.getSession().getAttribute("game");
JRouletteBean bean = (JRouletteBean) request.getSession().getAttribute("bean");
%>
<%=game.getOddsAndPayoutString(bean.getNumberWheelCount()) %>
<!-- game.getOddsAndPayoutString(request.getParameter("b").toString(), bean.getNumberWheelCount()) -->