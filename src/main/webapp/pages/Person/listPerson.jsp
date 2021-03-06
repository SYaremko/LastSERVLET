<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&amp;subset=cyrillic,cyrillic-ext,latin-ext" rel="stylesheet">
</head>
<body>
<div class="block-body">

    <div class="container">
        <header class="header">
            <nav class="header_nav">
                <div class="logo">
                    <a href="/"><img class="movie" src="img/logo.png"></a>
                </div>
                <div class="header_menu">
                    <ul class="h_menu">
                        <li><a href="/listPerson">Users</a></li>
                        <li><a href="/listMovie">Movies</a></li>
                        <li><a href="/LogoutServlet">Logout</a></li>
                    </ul>
                </div>
            </nav>
        </header>
    </div>
    <div class="block-content">

        <ul id="block-tovar-grid" class="list__wrapper">
            <c:forEach items="${persons}" var="list">

                <li id="${list.id}" id="block-tovar-grid-new" class="list__item">
                    <div class="block-images-grid"><img class="image-grid" src="/imgP?img=${list.img}">
                        <a href="#" class="list__crt list__cancel"><img src="img/cancel.png" alt=" "></a>

                    </div>
                    <div class="list__item-wrapper">
                        <a class="list__name" href="">${list.name}</a>

                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/slick.min.js"></script>
<script src="js/deletePerson.js"></script>

</body>
</html>
