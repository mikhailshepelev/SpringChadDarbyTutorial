<%--
  Created by IntelliJ IDEA.
  User: mikhailshepelev
  Date: 09.06.2020
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Customers</title>
<%--    reference our style sheet--%>
    <link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">

<%--            put new button: Add customer--%>
            <input type="button" value="Add Customer"
            onclick="window.location.href='showFormForAdd'; return false;"
            class="add-button"/>

<%--            add out html table here--%>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
<%--                loop over and print our customers--%>
                <c:forEach var="tempCustomer" items="${customers}">
<%--                    construct an "update" link with customer id--%>
                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>
                    <%--                    construct an "update" link with customer id--%>
                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>
                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                        <td>
<%--                            display the update link--%>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                            onclick="if (!(confirm('Are you sure want to delete this customer?'))) return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
