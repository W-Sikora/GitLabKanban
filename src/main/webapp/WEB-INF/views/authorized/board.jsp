<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<c:import url="../head/head.jsp"/>
<body>

<header>
    <c:import url="../header/header.jsp"/>
</header>

<section class="hero has-background-light">
    <div class="hero-body">
        <div class="container">
            <div class="field is-grouped">
                <label for="mainForm"></label>
                <input id="mainForm" class="input is-rounded is-large mr-3">


                <p class="control">
                    <button type="submit" class="button is-success is-rounded is-outlined is-large">
                        <i class="fa fa-search"></i>
                    </button>
                </p>
                <p class="control">
                    <button type="reset" class="button is-danger is-rounded is-outlined is-large">
                        <i class="fa fa-times"></i>
                    </button>
                </p>
            </div>
            <div class="field is-grouped is-grouped-centered">
                <a class="button is-success is-outlined is-rounded mt-2">add column</a>
            </div>
        </div>
    </div>
</section>

<div class="container">
    <div class="columns">
        <div class="column">

            <section class="container mt-3">
                <div class="level-item">
                    <div class="columns is-multiline is-centered cards-container">
                        <c:forEach items="${columns}" var="column">
                            <div class="column is-narrow">
                                <article class="message is-primary">
                                    <div class="message-header">
                                        <p>${column}</p>
                                        <button class="delete" aria-label="delete"></button>
                                    </div>
                                    <div class="message-body">
                                        <c:forEach items="${issues}" var="issue">
                                            <section>
                                                <div class="board-item">
                                                    <div class="board-item-content">
                                                        <div class="card my-5">
                                                            <div class="card-header has-background-white-ter">
                                                                <p class="card-header-title">
                                                                    <c:set value="${issue.title.length()}"
                                                                           var="titleLen"/>
                                                                    <a href="${issue.webUrl}">
                                                                        <c:out value="${titleLen > 40 ? issue.title.substring(0, 40).concat('...') : issue.title}"/>
                                                                    </a>
                                                                </p>
                                                            </div>
                                                            <div class="card-content">
                                                                <div class="content">
                                                                    <c:set value="${issue.description.length()}"
                                                                           var="descriptionLen"/>
                                                                    <c:out value="${descriptionLen > 300 ? issue.description.substring(0, 300).concat('...') : issue.description}"/>
                                                                    <hr class="my-3">
                                                                    <fmt:parseDate value="${issue.updatedAt}"
                                                                                   pattern="yyyy-MM-dd'T'HH:mm"
                                                                                   var="updatedAt"
                                                                                   type="date"/>
                                                                    <fmt:formatDate pattern="HH:mm - dd.MM.yyyy"
                                                                                    value="${updatedAt}"
                                                                                    var="updatedAt"/>
                                                                    <span class="mr-2">${updatedAt}</span>
                                                                    <a class="mr-2"
                                                                       href="${issue.author.webUrl}">@${issue.author.userName}</a>
                                                                    <a class="ml-2">${issue.upVotes} <i
                                                                            class="fa fa-thumbs-o-up"
                                                                            aria-hidden="true"></i></a>
                                                                    <a class="ml-2">${issue.downVotes} <i
                                                                            class="fa fa-thumbs-o-down"
                                                                            aria-hidden="true"></i></a>
                                                                </div>
                                                            </div>
                                                            <div class="card-footer">
                                                                <p class="card-footer-item">
                                                                    <a class="mr-4"
                                                                       href="${issue.milestone.webUrl}">${issue.milestone.title}</a>
                                                                    <c:forEach items="${issue.labels}" var="label">
                                                                        <a class="tag is-link mr-2"
                                                                           style="background-color: ${label.backgroundColor}; color: ${label.textColor}">
                                                                                ${label.name}</a>
                                                                    </c:forEach>
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </section>
                                        </c:forEach>
                                    </div>
                                </article>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section>

        </div>
    </div>
</div>
</body>
</html>
