<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: flicker03
  Date: 7/1/2024
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Title</th>
        <th>Catalog ID</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.title}</td>
            <td>${product.catalogId}</td>
            <td>${product.productStatus?"Active":"Inactive"}</td>
            <td>
                <a href="<%=request.getContextPath()%>/ProductController/initUpdate?productId=${product.productId}">Update</a>
                <a href="<%=request.getContextPath()%>/ProductController/delete?productId=${product.productId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/ProductController/initCreateProduct">Create New Product</a>
</body>
</html>
