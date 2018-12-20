<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <!-- navbar -->
<nav class="navbar navbar-expand-sm fixed-top bg-dark navbar-dark">
    <a class="navbar-brand" href="<spring:url value="/" />"><spring:message code="str.home"/></a>

    <div class="collapse navbar-collapse text-right" id="collapsibleNavbar">
        <sec:authorize access="isAuthenticated()">
            <span class="navbar-text"><spring:message code="str.welcome"/> <sec:authentication property="principal.username" />!</span>
        </sec:authorize>
        <ul class="navbar-nav">
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" data-value="logout"
                        href="<spring:url value="/auth/logout" />">
                        <spring:message code="str.logout"/>
                    </a>
                </li>
            </sec:authorize>
        </ul>
    </div>
</nav>


