package DAO;

import DAO.DaoI.IDaoPerson;
import Entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DaoPerson implements IDaoPerson{

    private Connection connection;

    public DaoPerson() throws SQLException, ClassNotFoundException {
        connection = new DBConnection().getConnection();
    }
    @Override
    public List<Person> getAllPersons() throws SQLException {
        List<Person> listt = new ArrayList<Person>();
        String sql = "Select * from user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setImg(resultSet.getString("img"));

            listt.add(person);
        }
        return listt;
    }
    @Override
    public void createPerson(Person persons) throws SQLException {
        if (isPersonExit(persons.getName())){
            return;
        }
        String sql = "INSERT INTO user (name, email, password, sex, role, img) VALUES (?,?,?,?,?,?)";
        PreparedStatement prr = connection.prepareStatement(sql);

        prr.setString(1,persons.getName());
        prr.setString(2,persons.getEmail());
        prr.setString(3,persons.getPassword());
        prr.setString(4,String.valueOf(persons.getSex()));
        prr.setString(5,String.valueOf(persons.getRole()));
        prr.setString(6,persons.getImg());
        System.out.println("1111");
        prr.executeUpdate();
        System.out.println("122222");

    }
    @Override
    public Person getPerson (String name, String password) throws SQLException {
        String sq = "select id, name, password from user where name=? and password=?";
        PreparedStatement pr = connection.prepareStatement(sq);
        pr.setString(1, name);
        pr.setString(2, password);
        ResultSet resultSet = pr.executeQuery();
        if(resultSet.next()){
            Person person = new Person();
            person.setId(resultSet.getInt(1));
            person.setName(resultSet.getString(2));
            person.setPassword(resultSet.getString(3));
            return person;

        }
        return null;
    }
    @Override
    public boolean isPersonExit(String name) throws SQLException {
        String sq = "select id from user where name=? ";
        PreparedStatement pr = connection.prepareStatement(sq);
        pr.setString(1, name);
        ResultSet resultSet = pr.executeQuery();
        if(resultSet.next()){
            return true;
        }
        return false;
    }
    @Override
    public void deletePerson(int id) throws SQLException {
        String sql = "delete from user where id =?";
        PreparedStatement pr = connection.prepareStatement(sql);
        pr.setInt(1, id);
        pr.executeUpdate();
        System.out.println("dao all ok");
    }


}
