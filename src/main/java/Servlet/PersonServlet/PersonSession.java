package Servlet.PersonServlet;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class PersonSession {
    private static Map<String,String> personSession = new HashMap<>();

    public static void addToSession(String personId, HttpServletRequest httpServletRequest){
        personSession.put(personId, httpServletRequest.getSession().getId());
        httpServletRequest.getSession().setAttribute("person", personId);
        System.out.println(personId);

    }
    public static void clearSession(String personId){
        personSession.remove(personId);
    }

    public static boolean isSessionValid(String personId, HttpServletRequest httpServletRequest){
        if (!personSession.containsKey(personId)){
            return false;
        }return personSession.get(personId).equals(httpServletRequest.getSession().getId());
    }
}
