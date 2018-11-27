package Servlet.PersonServlet;

import MD5.MD5;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/login")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }




    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chainObj) throws IOException, ServletException {

        RequestDispatcher rdObj = null;

        String name = req.getParameter("name");
        String password = MD5.md5(req.getParameter("password"));

        System.out.println("Password Is?= " + password);
        if (name == null || name.isEmpty()) {
            req.setAttribute("msgg","Please enter username");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

        if (password == null || password.isEmpty()) {
            req.setAttribute("msgg","Please enter password");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }


        if(password != null && password.equals("b895e9d6bedde8050dd1550e624566b3")) {
            req.getRequestDispatcher("pages/Movie/addMoviePage.jsp").forward(req,resp);
            chainObj.doFilter(req, resp);

        }
 HttpServletRequest httpServletRequest = ((HttpServletRequest)req);
        Object attribute = httpServletRequest.getSession().getAttribute("person");
        if (attribute == null) {
            req.getRequestDispatcher("pages/Person/404.jsp").forward(req, resp);
            return;
        }


        
        if(password != null  ) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);

        }


    }
    @Override
    public void destroy() {

    }
}
