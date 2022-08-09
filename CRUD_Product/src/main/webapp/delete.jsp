<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/8/2022
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>Xóa sản phẩm</h1>
    <h2><a href="/ProductManager">Quay trở lại</a></h2>
    <form method="post" >
        <table style="width: auto" border="1">
            <tr>
                <td>Id</td>
                <td><input name="id" type="text" value= '${requestScope["product"].getId()}' readonly></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input  name="name" type="text" value='${requestScope["product"].getName()}' readonly></td>
            </tr>
            <tr>
                <td>Amount</td>
                <td><input name="amount" type="text" value='${requestScope["product"].getAmount()}' readonly></td>
            </tr>
            <tr>
                <td>
                    <input value="Xóa" type="submit">
                </td>
                <td>
                    Bạn có chắc chắn muốn xóa ?
                </td>
            </tr>
        </table>
    </form>
    <h2>
        <c:if test='${requestScope["message"] != null}'>
            ${requestScope["message"]}
        </c:if>
    </h2>
</div>
</body>
</html>
