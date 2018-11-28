
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