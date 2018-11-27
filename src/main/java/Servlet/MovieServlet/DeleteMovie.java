package Servlet.MovieServlet;

import DAO.DaoMovie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteMovie")
public class DeleteMovie extends HttpServlet {
    private DaoMovie daoMovie;
    public DeleteMovie() throws Exception {
        super();
        daoMovie = new DaoMovie();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String movieid = req.getParameter("reqValue");

        System.out.println(movieid);
        try {
            daoMovie.deleteMovie(Integer.parseInt(movieid));
            System.out.println("serv");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
