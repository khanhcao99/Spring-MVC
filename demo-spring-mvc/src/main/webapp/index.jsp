<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Xin Chào Anh Khánh Đẹp Zai
</h1>
<h2>
    ${requestScope['name']}

</h2>
<form action="/demo2" method="post">
    <input type="text" name="id">
    <button type="submit">Click</button>
</form>
</body>
</html>