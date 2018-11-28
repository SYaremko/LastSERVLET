
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
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
                        <li><a href="/listPerson">List Person</a></li>

                        <li><a href="/listMovie">List movie</a></li>
                        <li><a href="/LogoutServlet">Logout</a></li>

                    </ul>
                </div>
            </nav>

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
        <form action="/edit" method="post" enctype="multipart/form-data" class="some__form">
            <div class="form__line">
                <span class="input-span">Id</span>
                <input type="text" name="id" value="${movie.id}"/>
            </div>
            <div class="form__line">
                <label for="movie_name">
                    <span class="input-span">Name</span>
                    <input type="text" name="moviename" value="${movie.moviename}"/>
                </label>
            </div>
            <div class="form__line">
                <span class="input-span">Type</span>
                <label for="navigation__movie" class="navigation__input-wr navigation__input-movie">
                    <span>MOVIE</span>
                    <%--<input type="radio" name="type" value="MOVIE" value="${item.type}">--%>
                    <input type="radio" name="type" id="navigation__movie" value="MOVIE"  value="${movie.type}">
                </label>
                <label for="navigation__cartoon" class="navigation__input-wr navigation__input-movie">
                    <span>CARTOON</span>
                    <input type="radio" name="type" id="navigation__cartoon" value="CARTOON" value="${movie.type}">
                </label>
            </div>
            <div class="form__line">
                <span class="input-span">Description</span>
                <input type="text" name="description"  value="${movie.description}"/>
            </div>
            <dib class="form__line">
                <span class="input-span">URL</span>
                <input type="url" name="url"  value="${movie.url}"/>
            </dib>
            <div class="form__line">
                <label for="form__file" class="form__file">
                    <span>Завантажити фото</span>
                    <input type="file" name="image" value="${movie.image}" id="form__file" class="form__file-inp">
                </label>
            </div>
            <div class="form__line">
                <input type="submit" value="Save "/>
            </div>

        </form>
    </div>
</div>  <script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/slick.min.js"></script>
<script src="js/grid_list.js"></script>



</form>
</body>
</html>
