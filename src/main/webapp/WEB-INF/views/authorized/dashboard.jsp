<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<c:import url="../head/head.jsp"/>
<body>
<header>
    <c:import url="../header/header.jsp"/>
</header>
<div class="container">
    <div class="columns my-3">
        <div class="column is-2 ">
            <aside class="menu">
                <p class="menu-label">General</p>
                <ul class="menu-list">
                    <li><a class="mb-3" href="<c:url value="/logout"/>">Sign out</a></li>
                    <li><a href="<c:url value="/dashboard/settings"/>">Settings</a></li>
                    <li><a href="<c:url value="/dashboard/other"/>">Other</a></li>
                </ul>
            </aside>
        </div>
        <div class="column is-10">

            <c:if test="${param['error'] != null}">
                <article class="message is-danger mb-5">
                    <div class="message-body has-text-centered">
                        <div>
                            Failed to get current data from GitLab make sure url:
                            <strong class="mx-1">${user.gitLabUrl}</strong> is correct.
                        </div>
                        <div>
                            <a class="button is-rounded is-danger mt-4"
                               href="<c:url value="/gitlab_resources/update_resources"/>">
                                refresh connection
                            </a>
                        </div>
                    </div>
                </article>
            </c:if>

            <section class="hero is-link welcome is-small">
                <div class="hero-body">
                    <div class="container">
                        <h1 class="title">
                            Hello, ${user.name}
                        </h1>
                    </div>
                </div>
            </section>

            <section class="info-tiles mt-4">
                <div class="tile is-ancestor has-text-centered">
                    <div class="tile is-parent">
                        <article class="tile is-child box">
                            <p class="title">${boardsNb}</p>
                            <p class="subtitle">boards</p>
                        </article>
                    </div>
                    <div class="tile is-parent">
                        <article class="tile is-child box">
                            <p class="title">${projectsNb}</p>
                            <p class="subtitle">projects</p>
                        </article>
                    </div>
                    <div class="tile is-parent">
                        <article class="tile is-child box">
                            <p class="title">${issuesNb}</p>
                            <p class="subtitle">issues</p>
                        </article>
                    </div>
                </div>
            </section>

            <section class="hero is-light welcome is-small my-4">
                <div class="hero-body">
                    <div class="container has-text-centered">
                        <p class="title is-4">Your boards</p>
                    </div>
                </div>
            </section>

            <div class="columns">
                <div class="column">
                    <div class="card events-card">
                        <div class="card-content">

                            <div class="has-text-centered mb-5">
                                <p class="subtitle is-5">Find board</p>
                            </div>

                            <div class="content">
                                <form method="post" action="<c:url value="/dashboard/find"/>">
                                    <div class="field is-grouped is-grouped-centered">
                                        <div class="field">
                                            <label class="ml-3">
                                                <input class="input is-rounded" type="text" name="name"
                                                       placeholder="board's name" required>
                                            </label>
                                        </div>
                                        <div class="has-text-centered">
                                            <button type="submit" class="button is-link is-outlined is-rounded ml-4">
                                                find
                                            </button>
                                        </div>
                                    </div>
                                    <div>
                                        <c:if test="${board != null}">
                                            <p><a href="/board/${board.id}">${board.name}</a></p>
                                        </c:if>
                                    </div>
                                    <sec:csrfInput/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="column">
                    <div class="card events-card">
                        <div class="card-content">

                            <div class="has-text-centered mb-5">
                                <p class="subtitle is-5">Create new board</p>
                            </div>

                            <div class="content">
                                <form id="newBoard" method="post" action="<c:url value="/board"/>">
                                    <div class="field is-grouped is-grouped-centered">
                                        <div class="field">
                                            <label class="ml-3">
                                                <input class="input is-rounded" type="text" name="name"
                                                       placeholder="new board's name" required>
                                            </label>
                                        </div>
                                        <div class="has-text-centered">
                                            <button type="submit" class="button is-link is-outlined is-rounded ml-3">
                                                create
                                            </button>
                                        </div>
                                    </div>
                                    <sec:csrfInput/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="columns">

                <div class="column is-6">
                    <div class="card events-card">
                        <header class="card-header">
                            <p class="card-header-title">
                                recently updated
                            </p>
                        </header>
                        <div class="card-table">
                            <div class="content">
                                <table class="table is-fullwidth is-striped">
                                    <tbody>
                                    <c:forEach items="${recentlyUpdated}" var="board" varStatus="i">
                                        <tr>
                                            <td>${i.count}</td>
                                            <td><a href="/board/${board.id}">${board.name}</a></td>
                                            <td>${board.updatedAt}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="column is-6">
                    <div class="card events-card">
                        <header class="card-header">
                            <p class="card-header-title">
                                recently created
                            </p>
                        </header>
                        <div class="card-table">
                            <div class="content">
                                <table class="table is-fullwidth is-striped">
                                    <tbody>
                                    <c:forEach items="${recentlyCreated}" var="board" varStatus="i">
                                        <tr>
                                            <td>${i.count}</td>
                                            <td><a href="/board/${board.id}">${board.name}</a></td>
                                            <td>${board.createdAt}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/static/js/index.js"/>"></script>
</body>
</html>
