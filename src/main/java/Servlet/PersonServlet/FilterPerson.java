package Servlet.PersonServlet;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter("/personFilter")
public class FilterPerson implements Filter{
    public FilterPerson() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = ((HttpServletRequest)request);
        Object attribute = httpServletRequest.getSession().getAttribute("person");
        if (attribute == null) {
            request.getRequestDispatcher("pages/Person/404.jsp").forward(request, response);
            return;
        }
        String personid = (String)attribute;
        if (!PersonSession.isSessionValid(personid, httpServletRequest)) {
            request.getRequestDispatcher("pages/Person/404.jsp").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
