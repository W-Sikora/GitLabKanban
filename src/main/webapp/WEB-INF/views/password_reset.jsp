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
                <c:import url="coming_soon.jsp"/>
            </div>
        </div>
    </div>
</section>

</body>
</html>
