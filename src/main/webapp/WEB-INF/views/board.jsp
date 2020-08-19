<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<nav class="navbar my-2">
    <div class="container">
        <div class="navbar-brand">
            <a class="navbar-item" href="../">
                <img src="http://bulma.io/images/bulma-logo.png" alt="Bulma: a modern CSS framework based on Flexbox"/>
            </a>
        </div>
        <div class="navbar-end">
            <div class="navbar-item">
                <div class="buttons">
                    <a class="button is-dark is-rounded is-outlined" href="/logout">
                        <i class="fa fa-sign-out mr-1" aria-hidden="true"></i>
                        Log out
                    </a>
                </div>
            </div>
        </div>
    </div>
</nav>

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
            <div class="field is-grouped is-grouped-multiline">
                <div class="control">
                    <div class="tags has-addons">
                        <a class="tag is-link">Technology</a>
                        <a class="tag is-delete"></a>
                    </div>
                </div>

                <div class="control">
                    <div class="tags has-addons">
                        <a class="tag is-link">Documentation</a>
                        <a class="tag is-delete"></a>
                    </div>
                </div>
            </div>
            <div class="columns mt-3">
                <div class="column">
                    <p class="menu-label">Title</p>
                    <ul class="control">
                        <li class="mb-1">from A to Z
                            <label class="radio">
                                <input type="radio" name="title">
                            </label>
                        </li>
                        <li class="mb-1">from Z to A
                            <label class="radio">
                                <input type="radio" name="title">
                            </label>
                        </li>
                    </ul>
                </div>
                <div class="column">
                    <p class="menu-label">Author's username</p>
                    <ul class="control">
                        <li class="mb-1">from A to Z
                            <label class="radio">
                                <input type="radio" name="author">
                            </label>
                        </li>
                        <li class="mb-1">from Z to A
                            <label class="radio">
                                <input type="radio" name="author">
                            </label>
                        </li>
                    </ul>
                </div>
                <div class="column">
                    <p class="menu-label">Created date</p>
                    <ul class="control">
                        <li class="mb-1">newest to oldest
                            <label class="radio">
                                <input type="radio" name="created">
                            </label>
                        </li>
                        <li class="mb-1">oldest to newest
                            <label class="radio">
                                <input type="radio" name="created">
                            </label>
                        </li>
                    </ul>
                </div>
                <div class="column">
                    <p class="menu-label">Due date</p>
                    <ul class="control">
                        <li class="mb-1">newest to oldest
                            <label class="radio">
                                <input type="radio" name="due">
                            </label>
                        </li>
                        <li class="mb-1">oldest to newest
                            <label class="radio">
                                <input type="radio" name="due">
                            </label>
                        </li>
                    </ul>
                </div>
                <div class="column">
                    <p class="menu-label">Votes</p>
                    <ul class="control">
                        <li class="mb-1">thumb up
                            <label class="radio">
                                <input type="radio" name="votes">
                            </label>
                        </li>
                        <li class="mb-1">thumb down
                            <label class="radio">
                                <input type="radio" name="votes">
                            </label>
                        </li>
                    </ul>
                </div>
                <div class="column">
                    <p class="menu-label">Sort options</p>
                    <span class="tag is-outlined is-dark">A</span>
                </div>
            </div>

        </div>
    </div>
</section>

<div class="container">
    <div class="columns">
        <div class="column">
            <section>
                <div class="card my-5">
                    <div class="card-header has-background-white-ter">
                        <p class="card-header-title">
                            Open
                        </p>
                    </div>
                </div>
            </section>
            <c:forEach items="${issues}" var="issue">
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
                            <c:set value="${issue.description.length()}" var="descriptionLen"/>
                            <c:out value="${descriptionLen > 300 ? issue.description.substring(0, 300).concat('...') : issue.description}"/>
                            <hr class="my-3">
                            <fmt:parseDate value="${issue.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm" var="updatedAt"
                                           type="date"/>
                            <fmt:formatDate pattern="HH:mm - dd.MM.yyyy" value="${updatedAt}" var="updatedAt"/>
                            <span class="mr-2">${updatedAt}</span>
                            <a class="mr-2" href="${issue.author.webUrl}">@${issue.author.userName}</a>
                            <a class="ml-2">${issue.upVotes} <i class="fa fa-thumbs-o-up" aria-hidden="true"></i></a>
                            <a class="ml-2">${issue.downVotes} <i class="fa fa-thumbs-o-down"
                                                                  aria-hidden="true"></i></a>
                        </div>
                    </div>
                    <div class="card-footer">
                        <p class="card-footer-item">
                            <a class="mr-4" href="${issue.milestone.webUrl}">${issue.milestone.title}</a>
                            <c:forEach items="${issue.labels}" var="label">
                                <a class="tag is-link">${label.name}</a>
                            </c:forEach>
                        </p>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="column">
            <section>
                <div class="card my-5">
                    <div class="card-header has-background-grey-light">
                        <p class="card-header-title">
                            In progress
                        </p>
                    </div>
                </div>
            </section>
        </div>

        <div class="column">
            <section>
                <div class="card my-5">
                    <div class="card-header has-background-grey">
                        <p class="card-header-title">
                            Closed
                        </p>
                    </div>
                </div>
            </section>
        </div>

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


    const mainForm = document.getElementById("mainForm");
    const form = document.getElementById("form");
    mainForm.addEventListener("click", () => {
        form.innerHTML += "<input class='input' type='text' placeholder='Text input'/>";
    })


</script>
</body>
</html>
