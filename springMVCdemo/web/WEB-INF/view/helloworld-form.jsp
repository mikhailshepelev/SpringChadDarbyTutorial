<%--
  Created by IntelliJ IDEA.
  User: mikhailshepelev
  Date: 25.05.2020
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World - Input Form</title>
</head>
<body>
<%--action calls method with related path from "RequestMapping" annotation--%>
<%--this is not correct to append to start hello/ because its
relative path the the controller hello request mapping--%>
<form action="processFormVersionThree" method="GET">
    <input type="text" name="studentName"
    placeholder="What's your name?"/>
    <input type="submit"/>
</form>
</body>
</html>
