package Servlet.MovieServlet;

import DAO.DaoMovie;
import Entity.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/listMovie")
public class ListMovie extends HttpServlet {

    private DaoMovie daoMovie;

    public ListMovie() throws SQLException, ClassNotFoundException {
        super();
        daoMovie = new DaoMovie();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> movieList = new ArrayList<Movie>();
        try {
            movieList.addAll(daoMovie.getAllMovie());
                /*System.out.println( movieList.addAll(daoMovie.getAllMovie()));*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("movieList", movieList);
        req.getRequestDispatcher("pages/Movie/listMovie.jsp").forward(req, resp);
    }
}
