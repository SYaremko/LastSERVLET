
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<%--

</head>
<body>

<div class="block-body">
    <h2>Simple Login Web Application using JSP/Servlet</h2>

    <ul><li><a href="/"><img class="movie" src="img/logo.png"></a></li>
        <li><a href="/listPerson">List Person</a></li>
        <li><a href="/addMoviePage">add Movie</a></li>
        <li><a href="/addPersonPage">add Person</a></li>
        <li><a href="/listMovie">List movie</a></li>
        <li><a href="/loginPage">Login Page</a></li>

    </ul>

<div class="block-content">



</div>

</div>--%>
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&amp;subset=cyrillic,cyrillic-ext,latin-ext" rel="stylesheet">

</head>

<body>
${name}
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
                           <li><a href="/addPersonPage">Registration</a></li>
                       <%-- <li><a href="/loginPage">Login Page</a></li>--%>
                       <%-- <li><a href="/LogoutServlet">Logout</a></li>
--%>
                    </ul>
                </div>
            </nav>
            <%-- <div class="header_back"></div>--%>
        </header>
    <%--    <div class="hero__wrapper">
            <div class="slick__wrapper">
                <div class="slick__slide">
                    <img src="img/img1.jpeg" alt="img1">
                </div>
                <div class="slick__slide">
                    <img src="img/img2.jpg" alt="img2">
                </div>
            </div>
            <div class="slick-arrow slick-prev">
                <img src="img/arr1.png" alt="arrow">
            </div>
            <div class="slick-arrow slick-next">
                <img src="img/arr1.png" alt="arrow">
            </div>
        </div>--%>

        <div class="site__info-wrapper">
            <div id="particles" class="particles__wrap">
                <form action="/login" method="post" class="enter__form">
                    <p class="enter__form-error">
                        ${msgg} Введіть вірно ваші дані!!!
                    </p>
                    <label for="user_name" class="enter__form-label">
                        <span>Login</span>
                        <input type="text" name="name" id="user_name" class="enter__form-input"><br>
                    </label>
                    <label for="user__password" class="enter__form-label">
                        <span>Password</span>
                        <input type="text" name="password" id="user__password" class="enter__form-input"><br>
                    </label>
                    <%--<span>Password again</span>
                    <input type="text" name=""><br>--%>
                    <input type="submit" class="enter__form-submit">

                </form>
            <%--</div>--%>
        </div>
    </div>
</div>
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/slick.min.js"></script>
<script type="text/javascript" src="js/particles.js"></script>
<script src="js/grid_list.js"></script>
</body>
</html>
