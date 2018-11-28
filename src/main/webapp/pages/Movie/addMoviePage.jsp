
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="include/header.jsp"/>
<form action="/addMovie" method="post" enctype="multipart/form-data" class="some__form">
    <div class="form__line">
        <label for="movie_name">
            <span class="input-span">Name</span>
            <input type="text" name="moviename">
        </label>
    </div>
    <div class="form__line">
        <span class="input-span">Type</span>
        <label for="navigation__movie" class="navigation__input-wr navigation__input-movie">
            <span>MOVIE</span>
            <input type="radio" name="type" id="navigation__movie" value="MOVIE">
        </label>
        <label for="navigation__cartoon" class="navigation__input-wr navigation__input-movie">
            <span>CARTOON</span>
            <input type="radio" name="type" id="navigation__cartoon" value="CARTOON">
        </label>
    </div>
    <div class="form__line">
        <span class="input-span">Description</span>
        <input type="text" name="description">
    </div>
    <dib class="form__line">
        <span class="input-span">URL</span>
        <input type="url" name="url">
    </dib>
    <div class="form__line">
        <label for="form__file" class="form__file">
            <span>Завантажити фото</span>
            <input type="file" name="image" id="form__file" class="form__file-inp">
        </label>
    </div>
    <div class="form__line">
        <input type="submit" value="Save "/>
    </div>

</form>
  </div>
</div>
<jsp:include page="include/jsFile.jsp"/>

</body>
</html>
