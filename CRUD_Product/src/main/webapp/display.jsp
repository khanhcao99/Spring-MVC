<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>List Product
</h1>
<a style="text-decoration: none" href="create.jsp">Create Product</a>
<br/><br>
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
            <th><a href="/ProductManager/edit-view&id=${requestScope["p"].getId()}">Edit</a></th>
            <th><a href="/ProductManager/delete">Delete</a></th>
        </tr>
    </c:forEach>

</table>
</body>
</html>