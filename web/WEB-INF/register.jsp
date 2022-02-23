<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REGISTER</title>
</head>
<body>

<h1>WELCOME REGISTER</h1>

<div>
    <form action="/register" method="post" enctype="multipart/form-data">
        <input type="text" name="name" placeholder="name"><br>
        <input type="text" name="surname" placeholder="surname"><br>
        <input type="email" name="email" placeholder="email"><br>
        <input type="password" name="password" placeholder="password"><br>
        <input type="file" name="image"/> <br>
        <select name="type">
            <option value="USER">USER</option>
            <option value="ADMIN">ADMIN</option>
        </select><br>
        <input type="submit" value="REGISTER">
    </form>
</div>

</body>
</html>
