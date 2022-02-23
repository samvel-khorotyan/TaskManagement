<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD TASK</title>
</head>
<body>

<h1>WELCOME ADD TASK</h1>

<%
    List<User> users = (List<User>) request.getAttribute("users");
%>

<div>
    <form action="/addTask" method="post">
        <input type="text" name="name" placeholder="name"><br>
        <textarea name="description" placeholder="description"></textarea><br>
        <input type="date" name="date"><br>
        <select name="status">
            <option value="NEW">NEW</option>
            <option value="IN_PROGRESS">IN_PROGRESS</option>
            <option value="FINISHED">FINISHED</option>
        </select><br>
        <select name="user_id">
            <%
                for (User user : users) {%>
            <option value="<%=user.getId()%>"><%=user.getName()%> <%=user.getSurname()%>
            </option>
            <% }
            %>
        </select><br>
        <input type="submit" value="ADD TASK">
    </form>
</div>

</body>
</html>
