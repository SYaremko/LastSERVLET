package Servlet.PersonServlet;/*
package Servlet.PersonServlet;


import DAO.DaoPerson;
import Entity.Person;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class KOSTYClass {


    public Person login(HttpSession session, String name, String password) throws SQLException, ClassNotFoundException {
        Person person = null;

        DaoPerson userDAO = new DaoPerson();



                if (!person.getPassword().equals(password)) {

                    person = null;

                    session.setAttribute("User", person);

                }
        return person;
    }
}
*/
