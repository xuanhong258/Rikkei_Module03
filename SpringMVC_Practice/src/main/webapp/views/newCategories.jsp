<%--
  Created by IntelliJ IDEA.
  User: flicker03
  Date: 6/28/2024
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Categories</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/CategoriesController/create" method="post">
        <label for="catalogName">Catalog Name</label>
        <input type="text" id="catalogName" name="catalogName"><br>
        <label for="description">Description</label>
        <input type="text" id="description" name="description"><br>
        <label for="active">Status</label>
        <input type="radio" id="active" name="catalogStatus" value="true" checked><label for="active">Active</label>
        <input type="radio" id="inActive" name="catalogStatus" value="false"><label for="inActive">Inactive</label><br>
        <input type="submit" value="Create">
    </form>
</body>
</html>
