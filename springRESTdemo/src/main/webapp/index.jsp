<%--
  Created by IntelliJ IDEA.
  User: mikhailshepelev
  Date: 17.07.2020
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring REST DEMO</title>
</head>
<body>
<h3>Spring REST Demo</h3>
<hr>
<a href="${pageContext.request.contextPath}/test/hello">Hello</a>
<br><br>
<a href="${pageContext.request.contextPath}/api/students">Get All Students</a>
</body>
</html>
