package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = null;
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/testtest",
                "root", "root");
        return connection;
    }
}
