<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
An error occured!
<br/>
<br/>
<b>Message:</b>
<br/>
<c:out value="${exception.message}"/>
<br/>
<br/>
<b>Stack:</b>
<pre><c:out value="${exception.stackTrace}"/></pre>