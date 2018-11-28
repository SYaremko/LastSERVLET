package Servlet.MovieServlet;

import DAO.DaoMovie;
import Entity.Movie;
import enumPackage.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.sql.SQLException;

@WebServlet("/addMovie")
@MultipartConfig
public class AddMovie extends HttpServlet {
    private DaoMovie daoMovie;

    public AddMovie() throws Exception {
        super();
        daoMovie = new DaoMovie();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Movie movie = new Movie();
        String moveName = request.getParameter("moviename");
        if (moveName.isEmpty()) {
            movie.setMoviename("ok");
        } else {
            movie.setMoviename(moveName);
        }
        movie.setMoviename(request.getParameter("moviename"));
        movie.setType(Type.valueOf(request.getParameter("type")));
        movie.setDescription(request.getParameter("description"));
        movie.setUrl(request.getParameter("url"));
        Part filePart = request.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();
        byte[] buffer = new byte[fileContent.available()];
        fileContent.read(buffer);
        File targetFile = new File("C:\\Users\\Solomiya\\Desktop\\iimm\\" + fileName);
        System.out.println(targetFile.getAbsolutePath());
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);
        outStream.close();
        movie.setImage(fileName);
        try {
            daoMovie.createMovie(movie);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/addMoviePage");
    }
}


