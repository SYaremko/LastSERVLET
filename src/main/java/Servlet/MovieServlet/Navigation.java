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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/navigation")
public class Navigation extends HttpServlet {
    private DaoMovie daoMovie;

    public Navigation() throws Exception {
        super();
        daoMovie = new DaoMovie();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Movie movie = new Movie();
        Type type = movie.setType(Type.valueOf(req.getParameter("type")));
        System.out.println(type);
        List<Movie> movieList = new ArrayList<Movie>();
        try {
            movieList.addAll(daoMovie.navigation(type));
            /*System.out.println(daoMovie.navigation(type));*/
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("serv good");
        req.setAttribute("movieList", movieList);
        req.getRequestDispatcher("pages/Movie/listMovie.jsp").forward(req, resp);
    }
}
