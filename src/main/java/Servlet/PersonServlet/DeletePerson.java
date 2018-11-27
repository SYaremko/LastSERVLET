package Servlet.PersonServlet;

import DAO.DaoPerson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deletePerson")
public class DeletePerson extends HttpServlet{
    private DaoPerson daoPerson;
    public DeletePerson() throws Exception {
        super();
        daoPerson = new DaoPerson();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String movieid = req.getParameter("reqValue");

        System.out.println(movieid);
        try {
            daoPerson.deletePerson(Integer.parseInt(movieid));
            System.out.println("serv");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
