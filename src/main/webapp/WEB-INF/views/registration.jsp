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
                        <li><a href="<c:url value="/"/>">Sign in</a></li>
                        <li class="is-active"><a href="<c:url value="/register"/>">Register</a></li>
                        <li><a href="<c:url value="/api/docs"/>">API Docs</a></li>
                    </ul>
                </div>
                <div class="levels">
                    <div id="register" class="level-item is-inline">
                        <form method="post" action="<c:url value="/register"/>">
                            <div class="field">
                                <label class="ml-3">Name
                                    <input class="input is-rounded" type="text" name="name" required>
                                </label>
                            </div>
                            <div class="field">
                                <label class="ml-3">Email
                                    <input class="input is-rounded" type="email" name="email" required>
                                </label>
                            </div>
                            <div class="field">
                                <label class="ml-3">Password
                                    <input class="input is-rounded" type="password" name="password" minlength="8"
                                           maxlength="30" required>
                                </label>
                            </div>
                            <div class="field">
                                <label class="ml-3">URL for GitLab
                                    <input class="input is-rounded" type="url" name="gitLabUrl" id="gitLabUrl" minlength="6"
                                           placeholder="e.g. https://192.168.0.16" required>
                                </label>
                            </div>
                            <div class="field">
                                <label class="ml-3">Personal access token
                                    <input class="input is-rounded" type="text" name="token" minlength="6"
                                           placeholder="e.g. aHd8rFL-84StBeYtVY4L" required>
                                </label>
                            </div>
                            <div class="field ml-4 mt-3">
                                <div class="control">
                                    You can generate a personal access token <a id="getToken"
                                                                                href="">here</a>
                                </div>
                            </div>
                            <div class="field ml-1 mt-5">
                                <div class="control">
                                    <label class="checkbox">
                                        <input type="checkbox" required>
                                        I agree to the <a href="<c:url value="/terms-conditions"/>">terms and conditions</a>
                                    </label>
                                </div>
                            </div>
                            <div class="has-text-centered">
                                <button type="submit" class="button is-link is-outlined is-rounded">
                                    register
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
</body>
</html>
