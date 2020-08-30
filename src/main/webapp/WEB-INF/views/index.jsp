<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
                        <li class="is-active"><a href="<c:url value="/"/>">Sign in</a></li>
                        <li><a href="<c:url value="/register"/>">Register</a></li>
                        <li><a href="<c:url value="/api/docs"/>">API Docs</a></li>
                    </ul>
                </div>
                <div class="levels">
                    <c:if test="${param['error'] != null}">
                        <article class="message is-danger">
                            <div class="message-body">
                                Wrong username or password
                            </div>
                        </article>
                    </c:if>
                    <div class="level-item is-inline">
                        <form method="post" action="/login">
                            <div class="field">
                                <label class="ml-3">Email
                                    <input class="input is-rounded" type="email" name="email" id="email" required>
                                </label>
                            </div>
                            <div class="field">
                                <label class="ml-3">Password
                                    <input class="input is-rounded" type="password" name="password" id="password"
                                           minlength="8" maxlength="30" required>
                                </label>
                            </div>
                            <div class="field ml-3 mt-4">
                                <div class="control">
                                    <a href="<c:url value="/signIn/forgot"/>">
                                        Forgot your password?
                                    </a>
                                </div>
                            </div>
                            <div class="has-text-centered">
                                <button type="submit" class="button is-link is-outlined is-rounded">
                                    sign in
                                </button>
                            </div>
                            <sec:csrfInput/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="<c:url value="/static/js/index.js"/>"></script>
</body>
</html>
