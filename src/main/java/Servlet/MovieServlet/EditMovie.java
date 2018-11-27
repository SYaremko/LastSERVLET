package Servlet.MovieServlet;

import DAO.DaoMovie;
import Entity.Movie;
import enumPackage.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")

public class EditMovie extends HttpServlet{

        private DaoMovie daoMovie;
        public EditMovie() throws Exception {
            super();
            daoMovie = new DaoMovie();
        }
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String moId = request.getParameter("MovieId");
            Movie movie = null;
            try {
                if (moId == null || moId.isEmpty()) {
                    movie = new Movie();
                    movie.setId(-1);
                } else {
                    movie = daoMovie.getMovieById(Integer.parseInt(moId));
                }
            } catch (Exception e) {
            }
            if (movie == null) {
                request.getRequestDispatcher("WEB-INF/view/404.jsp").forward(request, response);
            } else {
                request.setAttribute("movie", movie);
                request.getRequestDispatcher("pages/Movie/Editmovie.jsp").forward(request, response);
            }
            System.out.println("fffff");
        }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Movie movie = new Movie();
        movie.setId(Integer.parseInt(request.getParameter("id")));
        movie.setMoviename(request.getParameter("moviename"));
        movie.setType(Type.valueOf(request.getParameter("type")));
        movie.setDescription(request.getParameter("description"));

        movie.setImage(request.getParameter("image"));
        movie.setUrl(request.getParameter("url"));

        try {
            if (movie.getId() == -1) {
                daoMovie.createMovie(movie);
            } else {
                daoMovie.updateMovie(movie);
            }
        } catch (Exception e) {
        }
        response.sendRedirect("/");
    }
}

