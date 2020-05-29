<%--
  Created by IntelliJ IDEA.
  User: mikhailshepelev
  Date: 29.05.2020
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--allow to use form--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
<%--student should match with parameter in constructor in showForm method--%>
<form:form action="processForm" modelAttribute="student">
<%--    firstName is property of Student class--%>
    First name: <form:input path="firstName"/>
    <br><br>
    Last name: <form:input path="lastName"/>
    <br><br>
<form:select path="country">
    <form:options items="${student.countryOptions}"/>
</form:select>
    <br><br>
Favourite Language:
    Java <form:radiobutton path="favoriteLanguage" value="Java"/>
    C# <form:radiobutton path="favoriteLanguage" value="C#"/>
    PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
    Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
    <br><br>
Operating Systems:
    Linux <form:checkbox path="operatingSystems" value="Linux"/>
    MacOS <form:checkbox path="operatingSystems" value="MacOS"/>
    Windows <form:checkbox path="operatingSystems" value="Windows"/>
    <br><br>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
