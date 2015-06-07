<%-- 
    Document   : index.jsp
    Created on : Jun 8, 2015, 12:08:21 AM
    Author     : zsvitalyos
--%>

<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="edu.bbu.bibliospring.backend.model.User" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<jsp:useBean id="users" scope="request" class="Collection<User>" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h1>Users</h1>
        <table>
            <tr>
                <th>Id</th>
                <th>User Name</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Password</th>
                <th>Delete</th>
            </tr>

            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.userName}"/></td>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td><c:out value="${user.password}"/></td>
                    <td><button onclick="location.href='${context}/controller?action=delete&id=${user.id}'">Delete me!</button></td>
                </tr>
            </c:forEach>
        </table>

        <form action="${context}/controller">
            <input type="hidden" name="action" value="insert" />

            First name: <input type="text" name="firstName"> <br>
            Last name: <input type="text" name="lastName"> <br>
            User name: <input type="text" name="userName"> <br>
            Password: <input type="password" name="password"> <br>
            <input type="submit" value="add"/>
        </form>
    </body>
</html>
