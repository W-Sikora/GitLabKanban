<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<header>
    <c:import url="header.jsp"/>
</header>

<section class="hero has-background-light">
    <div class="hero-body">
        <div class="container">
            <%--            <form method="get" action="/board/filter">--%>
            <div class="field is-grouped">
                <div id="mainForm" class="input is-rounded is-large mr-3">
                    <form id="form">

                    </form>
                </div>

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
            <%--            </form>--%>
        </div>
    </div>
</section>

<div class="container">
    <div class="columns">
        <div class="column">

        <section class="container mt-3">
            <div class="level-item">
                <div class="columns is-multiline is-centered cards-container" id="sectioncontainer">

                    <div class="column is-narrow">
                        <article class="message is-primary">
                            <div class="message-header">
                                <p>Season 1</p>
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
                                                            <c:set value="${issue.title.length()}" var="titleLen"/>
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
                                                                           pattern="yyyy-MM-dd'T'HH:mm" var="updatedAt"
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

                    <div class="column is-narrow">
                        <article class="message is-primary">
                            <div class="message-header">
                                <p>Season 1</p>
                                <button class="delete" aria-label="delete"></button>
                            </div>
                            <div class="message-body">
                                <c:forEach items="${issues1}" var="issue">
                                    <section>
                                        <div class="board-item">
                                            <div class="board-item-content">
                                                <div class="card my-5">
                                                    <div class="card-header has-background-white-ter">
                                                        <p class="card-header-title">
                                                            <c:set value="${issue.title.length()}" var="titleLen"/>
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
                                                                           pattern="yyyy-MM-dd'T'HH:mm" var="updatedAt"
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

                    <div class="column is-narrow">
                        <article class="message is-primary">
                            <div class="message-header">
                                <p>Season 1</p>
                                <button class="delete" aria-label="delete"></button>
                            </div>
                            <div class="message-body">
                                <c:forEach items="${issues2}" var="issue">
                                    <section>
                                        <div class="board-item">
                                            <div class="board-item-content">
                                                <div class="card my-5">
                                                    <div class="card-header has-background-white-ter">
                                                        <p class="card-header-title">
                                                            <c:set value="${issue.title.length()}" var="titleLen"/>
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
                                                                           pattern="yyyy-MM-dd'T'HH:mm" var="updatedAt"
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

                    <div class="column is-narrow">
                        <article class="message is-primary">
                            <div class="message-header">
                                <p>Season 1</p>
                                <button class="delete" aria-label="delete"></button>
                            </div>
                            <div class="message-body">
                                <c:forEach items="${issues3}" var="issue">
                                    <section>
                                        <div class="board-item">
                                            <div class="board-item-content">
                                                <div class="card my-5">
                                                    <div class="card-header has-background-white-ter">
                                                        <p class="card-header-title">
                                                            <c:set value="${issue.title.length()}" var="titleLen"/>
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
                                                                           pattern="yyyy-MM-dd'T'HH:mm" var="updatedAt"
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

                </div>
            </div>
        </section>

    </div>
</div>
<script>
    // const radioInputs = document.querySelectorAll("input[type=radio]");
    // const checkedRadioInputs = [];
    // radioInputs.forEach(el => el.addEventListener("change", () => {
    //     if (el.checked) {
    //         checkedRadioInputs.push(el)
    //     }
    //     console.log(checkedRadioInputs)
    // }));
    // const mainInput = document.getElementById("query");
    // mainInput.innerHTML("<div class=\"tags has-addons\"><span class=\"tag is-danger\">Alex Smith</span><a class=\"tag is-delete\"></a></div>")


    // const mainForm = document.getElementById("mainForm");
    // const form = document.getElementById("form");
    // mainForm.addEventListener("click", () => {
    //     form.innerHTML += "<input class='input' type='text' placeholder='Text input'/>";
    // })


</script>
</body>
</html>
