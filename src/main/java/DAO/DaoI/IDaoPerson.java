package DAO.DaoI;


import Entity.Person;

import java.sql.SQLException;
import java.util.List;

public interface IDaoPerson {

    List<Person> getAllPersons() throws SQLException;

    void createPerson(Person persons) throws SQLException;

    Person getPerson(String name, String password) throws SQLException;

    boolean isPersonExit(String name) throws SQLException;

    void deletePerson(int id) throws SQLException;
}
