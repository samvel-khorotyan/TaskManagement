<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CHANGE TASK</title>
</head>
<body>

<h1>WELCOME CHANGE TASK</h1>

<%
    String id = request.getParameter("id");
%>

<div>
    <form action="/changeTask?id=<%=id%>" method="post">
        <input type="text" name="name"><br>
        <input type="text" name="description"><br>
        <input type="date" name="deadline"><br>
        <input type="text" name="userId"><br>
        <input type="text" name="status"><input type="submit" value="ok">
    </form>
</div>

</body>
</html>
