import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DestroySessionServlet")
public class DestroySessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
            out.println("<h3>Session destroyed successfully.</h3>");
        } else {
            out.println("<h3>No active session found.</h3>");
        }
        out.println("<p><a href='SessionCheckServlet'>Go back</a></p>");
    }
}
