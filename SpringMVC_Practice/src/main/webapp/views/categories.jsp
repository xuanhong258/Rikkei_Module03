<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: flicker03
  Date: 6/28/2024
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Categories</title>
</head>
<body>
    <table border="1">
        <thead>
            <tr>
                <th>Categories ID</th>
                <th>Categories Name</th>
                <th>Description</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${categoriesList}" var="catalog">
                <tr>
                    <td>${catalog.catalogId}</td>
                    <td>${catalog.catalogName}</td>
                    <td>${catalog.description}</td>
                    <td>${catalog.catalogStatus?"Active":"Inactive"}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/CategoriesController/initUpdate?catalogId=${catalog.catalogId}">Update</a>
                        <a href="<%=request.getContextPath()%>/CategoriesController/delete?catalogId=${catalog.catalogId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<%=request.getContextPath()%>/CategoriesController/initCreate">Create New Categories</a>
</body>
</html>
