import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AutoRefreshServlet")
public class AutoRefreshServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Refresh every 5 seconds
        resp.setHeader("Refresh", "5");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<h3>Auto-refresh Servlet</h3>");
        out.println("<p>Current time: " + new Date() + "</p>");
        out.println("<p>Page refreshes every 5 seconds.</p>");
    }
}
