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
                        <i class="fa fa-sign-in mr-1" aria-hidden="true"></i>
                        Log out
                    </a>
                </div>
            </div>
        </div>
    </div>
</nav>

<section class="hero has-background-light">
    <div class="hero-body">
        <div class="container has-text-centered">
            <h1 class="title my-4">Kanban board for GitLab issues</h1>
        </div>
    </div>
</section>

<div class="container">
    <div class="field">
        <div class="control">
            <form method="post" action="/login/action">
                <div class="my-3">
                    <label class="ml-3">email:
                        <input class="input is-rounded" type="email" name="email">
                    </label>
                </div>
                <div class="my-3">
                    <label class="ml-3">password:
                        <input class="input is-rounded" type="password" name="password">
                    </label>
                </div>
                <button type="submit" class="button is-dark is-rounded is-outlined my-3">
                    <i class="fa fa-sign-in mr-1" aria-hidden="true"></i>
                    Log in
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
