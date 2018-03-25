
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {

    private static final long serialVersionUID = -1822377043264836486L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// TODO Auto-generated method stub
        HttpSession session = req.getSession();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
// These are the Request Parameters
        System.out.println("I am here");
        String param = req.getParameter("Book1");
        String param2 = req.getParameter("Book2");
        out.print("<html><body>");
        out.println("<H3>Test URL Rewriting</H3>");
        out.println("Click <A HREF=" + resp.encodeURL(req.getRequestURI()) + ">here</A><br>");
        out.print("</html></body>");
        if (!(param == null)) {
            session.setAttribute("Book1", param);
        }
        if (!(param2 == null)) {
            session.setAttribute("Book2", param2);
        }
//The following line prints the request parameters
        out.print("This is Book1: " + param + "</br>" + "This is another Book: " + param2 + "</br>");
//The following line prints the session  parameters
        out.print("</br>" + "This is SessionBook1: " + session.getAttribute("Book1") + "</br>" + "This is another SessionBook2: " + session.getAttribute("Book2"));
    }
}
