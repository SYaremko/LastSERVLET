<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <%--<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet"
          type="text/css"/>--%>

   <%-- <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>--%>
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&amp;subset=cyrillic,cyrillic-ext,latin-ext" rel="stylesheet">

</head>

<body>
${adm}
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
                                <%--<li><a href="/addMoviePage">add Movie</a></li>--%>
                               <%-- <li><a href="/addPersonPage">add Person</a></li>--%>
                                <li><a href="/listMovie">List movie</a></li>
                                <li><a href="/LogoutServlet">Logout</a></li>
                               <%-- <li><a href="/loginPage">Login Page</a></li>--%>
                            </ul>
                        </div>
                    </nav>
                   <%-- <div class="header_back"></div>--%>
                </header>
                <div class="hero__wrapper">
                    <div class="slick__wrapper">
                        <div class="slick__slide"><img src="img/movie-article.jpg"></div>
                        <div class="slick__slide"><img src="img/Popcorn.jpg"></div>
                        <div class="slick__slide"><img src="img/shutterstock_479963272.jpg"></div>
                    </div>
                    <div class="slick-arrow slick-prev">
                        <img src="img/arr1.png" alt="arrow">
                    </div>
                    <div class="slick-arrow slick-next">
                        <img src="img/arr1.png" alt="arrow">
                    </div>
                </div>
            </div>


        <div class="block-content">
            <div id="block-sorting">
                <ul id="option-list">
                    <li>Вид:</li>
                    <li id="style-grid"><img src="img/icon-grid-active.png"></li>
                    <li id="style-list"><img src="img/icon-list.png"></li>
                </ul>

                <form action="/navigation" method="post" class="navigation__form">
                    <input class="navigation__input navigation__input-movie" id="navigation__movie"  type="radio" name="type" value="MOVIE">
                    <label for="navigation__movie" class="navigation__input-wr navigation__input-movie">
                        <span>MOVIE</span>
                    </label>
                    <input class="navigation__input navigation__input-cartoon" id="navigation__cartoon" type="radio" name="type" value="CARTOON">
                    <label for="navigation__cartoon" class="navigation__input-wr navigation__input-cartoon">
                        <span>CARTOON</span>
                    </label>
                   <%-- <input type="submit" value="Find" id="navigation__submit">--%>
                </form>
            </div>
            <ul id="block-tovar-grid" class="list__wrapper">
                <c:forEach items="${movieList}" var="movieList" >
                    <li id="${movieList.id}" class="list__item" >
                        <div class="block-images-grid"><img class="image-grid" src="/imgD?image=${movieList.image}">
                            <a href="/" class="list__crt list__cancel"><img src="img/cancel.png" alt=" "></a>
                            <%--<a href="#" class="list__crt list__submit"><img src="img/ok.png" alt=" "></a>--%>
                        </div>
                        <div class="list__item-wrapper">
                            <a class="list__name" href="${movieList.url}">${movieList.moviename}</a>
                            <p class="list__features">
                                    ${movieList.description}
                            </p>
                            <a href="/edit?MovieId=${movieList.id}" class="list__crt list__edit"><img src="img/multi-edit.png" alt=" "></a>
                           <%-- ItemEdit?itemId=${item.id}--%>

                        </div>
                    </li>
                </c:forEach>
            </ul>

        </div>
        <%--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>--%>

    </div>
    <div class="modal__wrapper" id="siteModal">
        <div class="modal__body">
            <div class="modal__inner">
                <button class="modal__close">
                    <img src="img/close.png">
                </button>
                <h3 class="modal__title">Ви дійсно хочете видалити запис?</h3>
                <div class="modal__btn-wrapper">
                    <a href="/" class="modal__btn btn_yes" data-id="" id="btn_yes">Так</a>
                    <a href="/" class="modal__btn btn_no" id="btn_no">Ні</a>
                </div>
            </div>
        </div>
    </div>

    <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/slick.min.js"></script>
    <script src="js/grid_list.js"></script>
</body>

</html>