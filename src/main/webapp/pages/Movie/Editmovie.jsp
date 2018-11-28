<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="include/header.jsp"/>
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
</div>

</form>
<jsp:include page="include/jsFile.jsp"/>

</body>
</html>
