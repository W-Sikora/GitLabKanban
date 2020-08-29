<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<c:import url="head/head.jsp"/>
<body>

<header>
    <c:import url="header/header.jsp"/>
</header>

<section>
    <div class="container">
        <div class="columns">
            <div class="column is-three-fifths is-offset-one-fifth">
                <div class="tabs is-centered mt-6 mb-5">
                    <ul>
                        <li><a href="<c:url value="/"/>">Sign in</a></li>
                        <li><a href="<c:url value="/register"/>">Register</a></li>
                        <li class="is-active"><a href="<c:url value="/api/docs"/>">API Docs</a></li>
                    </ul>
                </div>
                <div class="levels">
                    <div class="level-item is-inline">
                        <c:import url="coming_soon.jsp"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
