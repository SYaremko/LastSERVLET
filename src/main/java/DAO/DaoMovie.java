package DAO;

import DAO.DaoI.IDaoMovie;
import Entity.Movie;
import enumPackage.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DaoMovie implements IDaoMovie {

    private Connection connection;

    public DaoMovie() throws SQLException, ClassNotFoundException {
        connection = new DBConnection().getConnection();
    }

    @Override
    public void createMovie(Movie movie) throws SQLException {
        String sql = "Insert into movie ( moviename, type, description, image, url) values (?,?,?,?,?)";
        PreparedStatement pr = connection.prepareStatement(sql);
        pr.setString(1, movie.getMoviename());
        pr.setString(2, String.valueOf(movie.getType()));
        pr.setString(3, movie.getDescription());
        pr.setString(4, movie.getImage());
        pr.setString(5, movie.getUrl());
        pr.executeUpdate();
    }

    @Override
    public List<Movie> getAllMovie() throws SQLException {
        List<Movie> list = new ArrayList<Movie>();
        String sql = "Select * from movie";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Movie movie = new Movie();
            movie.setId(resultSet.getInt("id"));
            movie.setMoviename(resultSet.getString("moviename"));
            movie.setDescription(resultSet.getString("description"));
            movie.setImage(resultSet.getString("image"));
            movie.setUrl(resultSet.getString("url"));
            list.add(movie);
        }
        return list;
    }

    @Override
    public void deleteMovie(int id) throws SQLException {
        String sql = "delete from movie where id =?";
        PreparedStatement pr = connection.prepareStatement(sql);
        pr.setInt(1, id);
        pr.executeUpdate();
        System.out.println("dao all ok");
    }

    @Override
    public List<Movie> navigation(Type type) throws SQLException {
        List<Movie> list = new ArrayList<Movie>();
        String sql = "Select * from movie where type=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(type));
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Movie movie = new Movie();
            movie.setId(resultSet.getInt("id"));
            movie.setMoviename(resultSet.getString("moviename"));
            movie.setDescription(resultSet.getString("description"));
            movie.setImage(resultSet.getString("image"));
            movie.setUrl(resultSet.getString("url"));
            list.add(movie);
            System.out.println("dao good");
        }
        return list;
    }

    @Override
    public Movie getMovieById(int movieID) throws SQLException {
        String sql = "Select * from movie where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, movieID);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Movie movie = new Movie();
            movie.setId(resultSet.getInt("id"));
            movie.setMoviename(resultSet.getString("moviename"));
            movie.setDescription(resultSet.getString("description"));
            movie.setImage(resultSet.getString("image"));
            movie.setUrl(resultSet.getString("url"));
            return movie;
        }
        return null;
    }

    @Override
    public void updateMovie(Movie movie) throws SQLException {
        Movie movieEdit = getMovieById(movie.getId());
        movieEdit.setMoviename(movie.getMoviename());
        movieEdit.setType(movie.getType());
        movieEdit.setDescription(movie.getDescription());
        movieEdit.setImage(movie.getImage());
        movieEdit.setUrl(movie.getUrl());
        deleteMovie(movie.getId());
        createMovie(movieEdit);
        System.out.println("rrrrr");
    }
}
