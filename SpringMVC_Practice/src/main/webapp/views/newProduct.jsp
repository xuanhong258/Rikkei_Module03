<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: flicker03
  Date: 7/1/2024
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Product</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/ProductController/createProduct" method="post">
    <label for="productId">Product ID</label>
    <input type="text" id="productId" name="productId" value="${productNew.productId}">
    <span style="color: red"><c:if test="${productId}"></c:if>${productId}</span><br>
    <label for="productName">Product Name</label>
    <input type="text" id="productName" name="productName" value="${productNew.productName}">
    <span style="color: red"><c:if test="${productName}"></c:if>${productName}</span><br>
    <label for="price">Price</label>
    <input type="text" id="price" name="price" value="${productNew.price}">
    <span style="color: red"><c:if test="${price}"></c:if>${price}</span><br>
    <label for="title">Title</label>
    <input type="text" id="title" name="title" value="${productNew.title}"><br>
    <label for="catalogId">Catalog ID</label>
    <select id="catalogId" name="catalogId">
        <c:forEach items="${categoriesList}" var="catalog">
            <option value="${catalog.catalogId}" ${catalog.catalogId==productNew.catalogId?'selected':''}>${catalog.catalogName}</option>
        </c:forEach>
    </select><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="productStatus" value="true" ${productNew.productStatus?'checked':''}><label for="active">Active</label>
    <input type="radio" id="inActive" name="productStatus" value="false" ${productNew.productStatus?'':'checked'}><label for="inActive">Inactive</label><br>
    <input type="submit" value="Create">
</form>
</body>
</html>
