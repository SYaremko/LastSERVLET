<%--
  Created by IntelliJ IDEA.
  User: Solomiya
  Date: 22.11.2018
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
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
                     <%--   <li><a href="/listPerson">List Person</a></li>
                        <li><a href="/addMoviePage">add Movie</a></li>
                        <li><a href="/addPersonPage">add Person</a></li>
                        <li><a href="/listMovie">List movie</a></li>--%>
                        <li><a href="/">I ALREADY HAVE AN ACCOUNT </a></li>
                    </ul>
                </div>
            </nav>
            <%-- <div class="header_back"></div>--%>
        </header>

<form action="/addPerson" method="post" enctype="multipart/form-data" class="form__wrapper">
    <div class="form__text-wrapper">
        <label for="user_name" class="form__label">
            <input type="text" id="user_name" name="name" class="form__inp-text" value="" required="required">
            <span class="inp__title">Your Name</span>
            <span class="form-error"></span>
        </label>
        <label for="user_email" class="form__label">
            <input type="text" id="user_email" name="email" class="form__inp-text" value="" required="required">
            <span class="inp__title">Your Email</span>
            <span class="form-error"></span>
        </label>
        <label for="user__password" class="form__label">
            <input type="password" id="user__password" name="password" class="form__inp-text" value="" required="required">
            <span class="inp__title">Your Password</span>
            <span class="form-error"></span>
        </label>
    </div>
    <div class="form__radio">

        <label for="male" class="radio__input">
            <input type="radio" name="sex" id="male" value="MALE">
            <span>MALE</span>
        </label>
        <label for="female" class="radio__input">
            <input type="radio" name="sex" id="female" value="FEMALE">
            <span>FEMALE</span>
        </label>
    </div>
   <%-- <input type="hidden" value="ROLE_USER">--%>
    <div class="form__file-wrapper">
        <label for="form__file" class="form__file">
            <input type="file" name="img" id="form__file" class="form__file-inp">
            <span>Завантажити фото</span>
        </label>
    </div>
    <div class="form__submit">
        <input type="submit" value="Save">
    </div>
</form>
    </div>
</div>
</body>
</html>