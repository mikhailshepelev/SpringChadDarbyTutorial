<%--
  Created by IntelliJ IDEA.
  User: mikhailshepelev
  Date: 25.05.2020
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Spring MVC Demo - Home Page</h2>

<hr>

<a href="${pageContext.request.contextPath}/hello/showForm">Hello World form</a>
<br><br>
<a href="${pageContext.request.contextPath}/student/showForm">Student form</a>
<br><br>
<a href="${pageContext.request.contextPath}/customer/showForm">Customer form</a>

</body>
</html>
