<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">
    <h1>Home</h1>
    <a href="<c:url value="auth/login" />">Login</a> |
    <a href="<c:url value="auth/register" />">Register</a> |
    <a href="<c:url value="auth/logout" />">Logout</a> |
    <sec:authorize access="isAuthenticated()">
        <sec:authorize access="hasRole('Student')">
            <a class="navbar-brand" href="<spring:url value="Student" />"><spring:message code="str.profile"/></a>
        </sec:authorize>

        <sec:authorize access="hasRole('Professor')">
            <a class="navbar-brand" href="<spring:url value="Professor" />"><spring:message
                    code="str.profile"/></a>
        </sec:authorize>
    </sec:authorize>
</div>