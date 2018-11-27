<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <%--<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet"
          type="text/css"/>--%>

    <%-- <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>--%>
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
                        <li><a href="/listPerson">List Person</a></li>
                       <%-- <li><a href="/addMoviePage">add Movie</a></li>--%>
                       <%-- <li><a href="/addPersonPage">add Person</a></li>--%>
                        <li><a href="/listMovie">List movie</a></li>
                        <li><a href="/LogoutServlet">Logout</a></li>
                        <%--<li><a href="/loginPage">Login Page</a></li>--%>
                    </ul>
                </div>
            </nav>
            <%-- <div class="header_back"></div>--%>
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








<%--
<a href="/"><img class="logo" src="img/logo.png"></a>



    <c:forEach items="${persons}" var="list">
      <div>${list.name}</div>
        <div>${list.name}</div>
        <img class="image-grid" src="/imgP?img=${list.img}">




    </c:forEach>



<a href="/">main</a>
--%>

<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/slick.min.js"></script>
<script src="js/deletePerson.js"></script>

</body>
</html>
