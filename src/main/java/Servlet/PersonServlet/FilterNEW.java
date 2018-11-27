package Servlet.PersonServlet;/*
package Servlet.PersonServlet;



        import Entity.Person;
        import MD5.MD5;
        import enumPackage.Role;

        import javax.servlet.*;
        import javax.servlet.annotation.WebFilter;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import java.io.IOException;


public class FilterNEW implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;




        HttpSession session = req.getSession(false);
        Person person;

        if (session != null) {
            if ((person = (Person) session.getAttribute("User")) != null) {
                if (person.getPassword().equals("b895e9d6bedde8050dd1550e624566b3")) {

                    filterChain.doFilter(servletRequest, servletResponse);

                }
                else {
                    System.out.println("Authorized user doesn't have correspondent access rights");
                    res.sendRedirect("/");
                }
            }
            else {
                System.out.println("Unauthorized access request to admin panel");
                res.sendRedirect("/");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
*/
