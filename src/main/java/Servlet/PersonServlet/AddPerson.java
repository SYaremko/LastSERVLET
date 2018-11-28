package Servlet.PersonServlet;

import DAO.DaoPerson;
import Entity.Person;
import MD5.MD5;
import enumPackage.Sex;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.sql.SQLException;

@WebServlet("/addPerson")
@MultipartConfig
public class AddPerson extends HttpServlet {
    private DaoPerson daoPerson;

    public AddPerson() throws Exception {
        super();
        daoPerson = new DaoPerson();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileNotFoundException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Part filePart = request.getPart("img");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String sex = String.valueOf(request.getParameter("sex"));

        if ((name.contains(" ")) || password.contains(" ") || email.contains(" ")) {
            request.setAttribute("message", "You can not use a space");
            request.getRequestDispatcher("pages/Person/addPersonPage.jsp").forward(request, response);
        }
        if ((name == null || name.isEmpty())
                || (password == null || password.isEmpty()  )
                || (email == null || email.isEmpty())
                || (fileName == null || fileName.isEmpty())
                || (sex == null || sex.isEmpty())
                ) {
            request.setAttribute("message", "Sorry, but all gaps have to be field !");
            request.getRequestDispatcher("pages/Person/addPersonPage.jsp").forward(request, response);
        }

        Person person = new Person();
        person.setName(request.getParameter("name"));
        person.setEmail(request.getParameter("email"));
        person.setPassword(MD5.md5(request.getParameter("password")));
        person.setSex(Sex.valueOf(request.getParameter("sex")));
        /*Part filePart = request.getPart("img");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();*/
        InputStream fileContent = filePart.getInputStream();
        byte[] buffer = new byte[fileContent.available()];
        fileContent.read(buffer);
        File targetFile = new File("C:\\Users\\Solomiya\\Desktop\\iimm\\" + fileName);
        System.out.println(targetFile.getAbsolutePath());
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);
        outStream.close();
        person.setImg(fileName);
        try {
            daoPerson.createPerson(person);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/");
    }
}

