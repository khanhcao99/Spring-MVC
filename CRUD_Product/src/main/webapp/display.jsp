<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div align="center">
    <h1>List Product
    </h1>
    <button>
        <a style="text-decoration: none" href="/ProductManager/create">Create Product</a>
    </button>
    <br/><br>
    <form method="get" action="/ProductManager/search">
        <input value="${name}" type="text" name="search"  placeholder="Tìm kiếm sản phẩm">
        <button type="submit">Tìm kiếm</button>
    </form>
    <br>
    <table style="width: 600px" border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Amount</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach items="${requestScope['products']}" var="p">
            <tr>
                <th>${p.getId()}</th>
                <th>${p.getName()}</th>
                <th>${p.getAmount()}</th>
                <th> <button><a href="/ProductManager/edit-view/?id=${p.getId()}">Edit</a></button></th>
                <th> <button><a href="/ProductManager/delete-view/${p.getId()}">Delete</a></button></th>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>