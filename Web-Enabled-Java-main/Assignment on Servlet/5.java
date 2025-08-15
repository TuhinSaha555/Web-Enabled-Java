import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SessionCheckServlet")
public class SessionCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(true);

        if (session.isNew()) {
            out.println("<h3>Welcome! This is your first visit.</h3>");
        } else {
            out.println("<h3>Welcome back! You last visited on: " + new Date(session.getLastAccessedTime()) + "</h3>");
        }

        out.println("<p>Session ID: " + session.getId() + "</p>");
        out.println("<p><a href='SessionCheckServlet'>Refresh</a></p>");
        out.println("<p><a href='DestroySessionServlet'>Destroy Session</a></p>");
    }
}
