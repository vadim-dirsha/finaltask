<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container form-register">
    <h1 class="h3 mb-3 font-weight-normal text-center"><s:message code="str.register"/></h1>

    <sf:form method="POST" modelAttribute="user" class="form-register text-left col-12">

        <div class="form-group">
            <s:message code="str.enter_your_first_name" var="placeholder"/>
            <sf:label path="firstName" cssErrorClass="form-label text-danger" class="form-label" for="inputFirstName">
                <s:message code="str.first_name"/>
            </sf:label>
            <sf:input path="firstName" cssErrorClass="form-control  is-invalid" id="inputFirstName" class="form-control "
                   placeholder="${placeholder}" type="text"/>
            <sf:errors path="firstName" element="small" cssClass="help-block text-danger" />
        </div>
        <div class="form-group">
            <s:message code="str.enter_your_last_name" var="placeholder"/>
            <sf:label path="lastName" cssErrorClass="form-label text-danger" class="form-label" for="inputLastName" >
                <s:message code="str.last_name"/>
            </sf:label>
            <sf:input path="lastName" cssErrorClass="form-control  is-invalid" id="inputLastName" class="form-control "
                   placeholder="${placeholder}" type="text"/>
            <sf:errors path="lastName" element="small" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <s:message code="str.enter_your_username" var="placeholder"/>
            <sf:label path="username" cssErrorClass="form-label text-danger" class="form-label" for="inputUsername" >
                <s:message code="str.username"/>
            </sf:label>
            <sf:input path="username" cssErrorClass="form-control  is-invalid" id="inputUsername" class="form-control "
                      placeholder="${placeholder}" type="username"/>
            <sf:errors path="username" element="small" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <s:message code="str.enter_your_password" var="placeholder"/>
            <sf:label path="password" cssErrorClass="form-label text-danger" class="form-label" for="inputPassword" >
                <s:message code="str.password"/>
            </sf:label>
            <sf:input path="password" cssErrorClass="form-control  is-invalid" id="inputPassword" class="form-control "
                   placeholder="${placeholder}" required="" type="password"/>
            <sf:errors path="password" element="small" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <label class="form-label" for="selectRole" ><s:message code="str.role"/></label>
            <select id="selectRole" name="role" class="custom-select form-control ">
                <option disabled><s:message code="str.choose_a_role"/></option>
                <c:forTokens items="Professor,Student" delims = "," var="role">
                <option  value="${role}">
                    <c:out value = "${role}"/>
                </option>
                </c:forTokens>
            </select>
        </div>
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <button class="btn btn-dark btn-block m-1" type="submit" name="btnNext">
                    <s:message code="str.registration"/>
                </button>
            </div>
            <div class="col-3"></div>
        </div>
        <div class="row">
            <div class="col text-center">
                <p class="mt-5">
                    <s:message code="str.do_you_have_an_account"/>
                    <a href="<s:url value="/auth/register" />"><s:message code="str.login"/></a>
                </p>
            </div>
        </div>

        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </sf:form>

</div>
