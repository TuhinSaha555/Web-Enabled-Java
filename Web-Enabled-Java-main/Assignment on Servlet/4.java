import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/VisitCountServlet")
public class VisitCountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        int count = 0;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("visitCount".equals(c.getName())) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }
        count++;
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(count));
        visitCookie.setMaxAge(60*60*24*365);
        resp.addCookie(visitCookie);

        out.println("<h3>You have visited this servlet " + count + " times.</h3>");
    }
}
