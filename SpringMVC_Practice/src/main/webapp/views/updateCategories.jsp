<%--
  Created by IntelliJ IDEA.
  User: flicker03
  Date: 6/28/2024
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Categories</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/CategoriesController/update" method="post">
    <label for="catalogId">Catalog ID</label>
    <input type="text" id="catalogId" name="catalogId" value="${catalogUpdate.catalogId}" readonly><br>
    <label for="catalogName">Catalog Name</label>
    <input type="text" id="catalogName" name="catalogName" value="${catalogUpdate.catalogName}"><br>
    <label for="description">Description</label>
    <input type="text" id="description" name="description" value="${catalogUpdate.description}"><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="catalogStatus" value="true" ${catalogUpdate.catalogStatus?"checked":""}>
    <label for="active">Active</label>
    <input type="radio" id="inActive" name="catalogStatus" value="false" ${catalogUpdate.catalogStatus?"":"checked"}>
    <label for="inActive">Inactive</label><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
