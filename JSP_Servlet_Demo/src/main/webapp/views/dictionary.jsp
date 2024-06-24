<%--
  Created by IntelliJ IDEA.
  User: flicker03
  Date: 6/24/2024
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/Dictionary" method="post">
    <label for="input">Input</label>
    <input type="text" id="input" name="input"/><br>
    <input type="submit" value="Search"/>
</form>
</body>
</html>
