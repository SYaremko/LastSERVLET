package DAO.DaoI;


import Entity.Movie;
import enumPackage.Type;

import java.sql.SQLException;
import java.util.List;

public interface IDaoMovie {

    void createMovie(Movie movie) throws SQLException;

    List<Movie> getAllMovie() throws SQLException;

    void deleteMovie(int id) throws SQLException;

    List<Movie> navigation(Type type) throws SQLException;

    Movie getMovieById(int movieID) throws SQLException;

    void updateMovie(Movie movie) throws SQLException;
}
