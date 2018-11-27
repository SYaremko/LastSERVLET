package Servlet.PersonServlet;

import DAO.DaoPerson;
import Entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/listPerson")
public class ListPerson extends HttpServlet {
    private DaoPerson daoPerson;

    public ListPerson() throws SQLException, ClassNotFoundException {
        super();
        daoPerson = new DaoPerson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Person> personList = new ArrayList<Person>();
        try {
            personList.addAll(daoPerson.getAllPersons());
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("persons", personList);
        req.getRequestDispatcher("pages/Person/listPerson.jsp").forward(req,resp);
    }
}
