<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container form-logout">
    <h1 class="h3 mb-3 font-weight-normal text-center"><spring:message code="str.confirm_logout"/></h1>

    <form class="form-logout" method="post" action="<spring:url value="/account/logout/processing" />" name="logoutForm">

        <button class="btn btn-dark btn-block" type="submit"><spring:message code="str.logout"/></button>

        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
</div>
