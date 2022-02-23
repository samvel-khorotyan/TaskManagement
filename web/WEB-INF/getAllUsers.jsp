<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GET ALL USERS</title>
</head>
<body>

<h1>WELCOME GET ALL USERS</h1>

<%
    List<User> users = (List<User>) request.getAttribute("users");
%>

<div>
    <table border="1">
        <tr>
            <th>name</th>
            <th>surname</th>
            <th>email</th>
            <th>type</th>
            <th>change user</th>
            <th>delete</th>
        </tr>

        <%
            for (User user : users) {%>
        <tr>
            <td><%=user.getName()%>
            </td>
            <td><%=user.getSurname()%>
            </td>
            <td><%=user.getEmail()%>
            </td>
            <td><%=user.getUserType().name()%>
            </td>
            <td><a href="/changeUserMediator?id=<%=user.getId()%>">change user</a>
            </td>
            <td><a href="/deleteUser?id=<%=user.getId()%>">delete</a>
            </td>
        </tr>

        <%}%>
    </table>
</div>

</body>
</html>
