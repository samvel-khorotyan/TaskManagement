<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CHANGE USER JSP</title>
</head>
<body>

<h1>WELCOME CHANGE USER JSP</h1>

<%
    String id = request.getParameter("id");
%>

<div>
    <form action="/changeUser?id=<%=id%>" method="post">
        <input type="text" name="name" placeholder="name"><br>
        <input type="text" name="surname" placeholder="surname"><br>
        <input type="email" name="email" placeholder="email"><br>
        <input type="password" name="password" placeholder="password"><br>
        <select name="type">
            <option value="USER">USER</option>
            <option value="ADMIN">ADMIN</option>
        </select><br>
        <input type="submit" value="change">
    </form>
</div>

</body>
</html>
