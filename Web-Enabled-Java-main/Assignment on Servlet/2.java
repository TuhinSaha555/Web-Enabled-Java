import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    // For demo: hard-coded credential
    private static final String VALID_USER = "admin";
    private static final String VALID_PASS = "admin123";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        out.println("<html><body>");

        if (user != null && pass != null && user.equals(VALID_USER) && pass.equals(VALID_PASS)) {
            out.printf("<h3>Hello %s</h3>", escapeHtml(user));
        } else {
            out.println("<h3>Login failed</h3>");
            out.println("<p><a href=\"login.html\">Try again</a></p>");
        }

        out.println("</body></html>");
    }

    // Very small HTML escaper
    private String escapeHtml(String s) {
        if (s == null) return null;
        return s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;")
                .replace("\"","&quot;").replace("'","&#x27;");
    }
}
