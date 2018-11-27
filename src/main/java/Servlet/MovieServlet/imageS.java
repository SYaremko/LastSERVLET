package Servlet.MovieServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@WebServlet("/imgD")
public class imageS extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("image");
        File targetFile = new File("C:\\Users\\Solomiya\\Desktop\\iimm\\" + fileName);
        byte[] fileContent = Files.readAllBytes(targetFile.toPath());
        resp.getOutputStream().write(fileContent);
        resp.setContentType("img/png");
    }
}
