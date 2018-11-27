package Servlet.PersonServlet;

import DAO.DaoPerson;
import Entity.Person;
import MD5.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class Login  extends HttpServlet{
    private DaoPerson daoPerson;

    public Login() throws SQLException, ClassNotFoundException, SQLException {
        super();
        daoPerson = new DaoPerson();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = MD5.md5(req.getParameter("password"));

        /*if (name.isEmpty() || password.isEmpty()) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
*/


       /* if (name == null || name.isEmpty()) {
            req.setAttribute("msgg","Please enter username");
            req.getRequestDispatcher("pages/Person/loginPage.jsp").forward(req,resp);
        }

        if (password == null || password.isEmpty()) {
            req.setAttribute("msgg","Please enter password");
            req.getRequestDispatcher("pages/Person/loginPage.jsp").forward(req,resp);
        }*/
        /*if (password.equals("2c80fe6cdc35ad8188a1e714452130ed") && name.equals("vv")){
            req.setAttribute("adm","You are admin");
            req.getRequestDispatcher("pages/Movie/listMovie.jsp").forward(req,resp);
        }*/
        /*else {
            req.setAttribute("msgg","We don't find you");
            req.getRequestDispatcher("pages/Person/loginPage.jsp").forward(req,resp);
        }*/







            System.out.println(password);
            try {
                Person person = daoPerson.getPerson(name, password);
                PersonSession.addToSession(person.getName(), req);
                req.setAttribute("name",person);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            req.getRequestDispatcher("pages/Movie/listMovie.jsp").forward(req, resp);
        }
    }
