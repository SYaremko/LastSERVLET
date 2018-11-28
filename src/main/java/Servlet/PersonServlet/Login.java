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
public class Login extends HttpServlet {
    private DaoPerson daoPerson;

    public Login() throws ClassNotFoundException, SQLException {
        super();
        daoPerson = new DaoPerson();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        try {
            Person person = daoPerson.getPerson(name, MD5.md5(password));
            if (person==null){
                String error = "Your name or password is invalid";
                req.setAttribute("message", error);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!(name.length() < 10)){
            req.setAttribute("message", "You can not use name more the 10 elements");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        if (!((password.length()) < 15)){
            req.setAttribute("message", "You can not use password more the 15 elements");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        System.out.println("Password Is?= " + password);
        if ((name == null || name.isEmpty()) && (password == null || password.isEmpty())) {
            req.setAttribute("message", "Please enter username and password");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        if (name == null || name.isEmpty()) {
            req.setAttribute("message", "Please enter username");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        if (password == null || password.isEmpty()) {
            req.setAttribute("message", "Please enter password");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        String pd = MD5.md5(password);
        System.out.println(pd);
        try {
            Person person = daoPerson.getPerson(name, pd);
            PersonSession.addToSession(String.valueOf(person.getId()), req);
            req.setAttribute("name", name);
            System.out.println("your id  " + person.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
