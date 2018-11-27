package Servlet.PersonServlet;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class PersonSession {
    private static Map<String,String> personSession = new HashMap<>();

    public static void addToSession(String personId, HttpServletRequest httpServletRequest){
        personSession.put(personId, httpServletRequest.getSession().getId());
        httpServletRequest.getSession().setAttribute("person", personId);

    }
    public static void clearSession(String personId){
        personSession.remove(personId);
    }

    public static boolean isSessionValid(String personId, HttpServletRequest httpServletRequest){
        if (!personId.contains(personId)){
            return false;
        }return personSession.get(personId).equals(httpServletRequest.getSession().getId());
    }
}
