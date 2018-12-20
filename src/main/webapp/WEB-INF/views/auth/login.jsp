<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container form-login">
    <h1 class="h3 mb-3 font-weight-normal text-center"><spring:message code="str.please_login"/></h1>

    <form class="form-login" method="post" action="<spring:url value="/account/login/processing" />" name="loginForm">
        <div class="form-group">
            <label for="inputUsername" class="sr-only"><spring:message code="str.username"/></label>
            <input id="inputUsername" class="form-control" name="username"
                   placeholder="<spring:message code="str.enter_your_username"/>" required="" autofocus="" type="username">
        </div>
        <div class="form-group">
            <label for="inputPassword" class="sr-only"><spring:message code="str.password"/></label>
            <input id="inputPassword" class="form-control" name="password"
                   placeholder="<spring:message code="str.enter_your_password"/>" required="" type="password">
        </div>
        <button class="btn btn-dark btn-block" type="submit"><spring:message code="str.login"/></button>

        <p>
            <spring:message code="str.you_do_not_have_an_account" />
            <a href="<spring:url value="/auth/register"/>" ><spring:message code="str.register"/></a>
        </p>

        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
</div>
