package Servlet.PersonServlet;

import Entity.Person;
import enumPackage.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/addMoviePage")
public class FilterPerson implements Filter {
    public FilterPerson() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
        Object attribute = httpServletRequest.getSession().getAttribute("person");
        Person p = null;
        if (attribute == null) {
            request.getRequestDispatcher("pages/Person/404.jsp").forward(request, response);
            return;
        }
        String personid = (String) attribute;
        if (!PersonSession.isSessionValid(personid, httpServletRequest)) {
            request.getRequestDispatcher("pages/Person/404.jsp").forward(request, response);
            return;
        }
        if (PersonSession.isSessionValid(personid, httpServletRequest)) {
            request.getRequestDispatcher("pages/Movie/addMoviePage.jsp").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
