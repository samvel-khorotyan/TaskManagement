<%@ page import="model.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GET ALL TASKS</title>
</head>
<body>

<h1>WELCOME GET ALL TASKS</h1>

<%
    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
%>

<div>
    <table border="1">
        <tr>
            <th>name</th>
            <th>description</th>
            <th>deadline</th>
            <th>user_id</th>
            <th>status</th>
            <th>change status</th>
            <th>change task</th>
            <th>delete task</th>
        </tr>

        <%for (Task task : tasks) {%>
        <tr>
            <td><%=task.getName()%>
            </td>
            <td><%=task.getDescription()%>
            </td>
            <td><%=task.getDeadline()%>
            </td>
            <td><%=task.getUserId()%>
            </td>
            <td><%=task.getTaskStatus().name()%>
            </td>
            <td>
                <form action="/changeTaskStatus" method="post">
                    <input type="hidden" name="taskId" value="<%=task.getId()%>">
                    <select name="status">
                        <option value="NEW">NEW</option>
                        <option value="IN_PROGRESS">IN_PROGRESS</option>
                        <option value="FINISHED">FINISHED</option>
                    </select><input type="submit" value="ok">
                </form>
            </td>
            <td>
                <a href="/taskMediator?id=<%=task.getId()%>">change task</a>
            </td>
            <td>
                <a href="/taskMediator?id=<%=task.getId()%>">delete</a>
            </td>
        </tr>
        <%}%>
    </table>
</div>

</body>
</html>
