<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<c:import url="../head/head.jsp"/>
<body>
<header>
    <c:import url="../header/header.jsp"/>
</header>
<div class="container">
    <div class="columns mt-2">
        <div class="column is-2 ">
            <aside class="menu">
                <p class="menu-label">General</p>
                <ul class="menu-list">
                    <li><a class="mb-3" href="<c:url value="/dashboard/signOut"/>">Sign out</a></li>
                    <li><a>Settings</a></li>
                    <li><a>Other</a></li>
                </ul>
            </aside>
        </div>
        <div class="column is-10">
            <section class="hero is-link welcome is-small">
                <div class="hero-body">
                    <div class="container">
                        <h1 class="title">
                            Hello, ${user.email}
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

            <div class="columns">
                <div class="column">
                    <div class="card events-card">
                        <div class="card-content">
                            <div class="has-text-centered mb-5">
                                <p class="subtitle is-4">Your boards</p>
                            </div>
                            <div class="content">
                                <div class="columns">
                                    <div class="column is-9">
                                        <div class="control has-icons-right">
                                            <label>
                                                <input class="input is-rounded is-large" type="text" placeholder="">
                                            </label>
                                            <span class="icon is-medium is-right">
                                        <i class="fa fa-search"></i>
                                    </span>
                                        </div>
                                    </div>
                                    <div class="column is-3">
                                        <a class="button is-link is-outlined is-large is-rounded" href="<c:url value="/board"/>">
                                            new board
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <p class="card-header-title">Recently used boards</p>
                            <div class="card-table">
                                <div class="content">
                                    <table class="table is-fullwidth is-striped">
                                        <tbody>
                                        <tr>
                                            <td>
                                                <a class="ml-1 mb-3" href="/board/${user.id}">example table</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <a class="ml-1 mb-3">table name</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <a class="ml-1 mb-3">table name</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <a class="ml-1 mb-3">table name</a>
                                            </td>
                                        </tr>
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
</div>
</body>
</html>
