<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER.JSP</title>
</head>

<body>

<h1>WELCOME USER JSP</h1>

<%
    User user = (User) session.getAttribute("user");
%>
Welcome<%=user.getName()%><% if (user.getPictureUrl() != null) { %>
<img src="/image?path=<%=user.getPictureUrl()%>" width="100"/><br> <%}%>

<a href="/getAllTasksByUserId">GET MY TASKS</a>

</body>
</html>
