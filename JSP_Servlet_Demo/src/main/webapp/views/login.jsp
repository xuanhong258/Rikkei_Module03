<%--
  Created by IntelliJ IDEA.
  User: flicker03
  Date: 6/24/2024
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="<%=request.getContextPath()%>/LoginValidate" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username"/><br>
        <label for="password">Password</label>
        <input type="text" id="password" name="password"/><br>
        <input type="submit" value="Login"/>
    </form>

    <p>${error}</p>
</body>
</html>
