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
        <div style="width: calc(150px + 40%); margin: auto">
            <div class="tabs is-centered mt-6 mb-5">
                <ul>
                    <li id="signInTab" class="is-active"><a>Sign in</a></li>
                    <li id="registerTab"><a>Register</a></li>
                </ul>
            </div>
            <div class="levels">
                <div id="signIn" class="level-item">
                    <form method="post" action="<c:url value="/signIn"/>">
                        <div class="field">
                            <label class="ml-3">Email
                                <input class="input is-rounded" type="email" name="email" required>
                            </label>
                        </div>
                        <div class="field">
                            <label class="ml-3">Password
                                <input class="input is-rounded" type="password" name="password" minlength="8"
                                       maxlength="30"
                                       required>
                            </label>
                        </div>
                        <div class="field ml-3 mt-5">
                            <div class="control">
                                <a href="#">
                                    Forgot your password?
                                </a>
                            </div>
                        </div>
                        <div class="has-text-centered">
                            <button type="submit" class="button is-primary is-outlined is-rounded">
                                Sign in
                            </button>
                        </div>
                    </form>
                </div>
                <div id="register" class="level-item">
                    <form method="post" action="<c:url value="/register"/>">
                        <div class="field">
                            <label class="ml-3">Email
                                <input class="input is-rounded" type="email" name="email" required>
                            </label>
                        </div>
                        <div class="field">
                            <label class="ml-3">Password
                                <input class="input is-rounded" type="password" name="password" minlength="8"
                                       maxlength="30"
                                       required>
                            </label>
                        </div>
                        <div class="field">
                            <label class="ml-3">Personal access token
                                <input class="input is-rounded" type="text" name="token" required>
                            </label>
                        </div>
                        <div class="field ml-4 mt-3">
                            <div class="control">
                                You can generate a personal access token <a
                                    href="https://192.168.0.16/profile/personal_access_tokens">here</a>
                            </div>
                        </div>
                        <div class="field ml-1 mt-5">
                            <div class="control">
                                <label class="checkbox">
                                    <input type="checkbox" required>
                                    I agree to the <a href="#">terms and conditions</a>
                                </label>
                            </div>
                        </div>
                        <div class="has-text-centered">
                            <button type="submit" class="button is-primary is-outlined is-rounded">
                                Register
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="<c:url value="/static/js/index.js"/>"></script>
</body>
</html>
