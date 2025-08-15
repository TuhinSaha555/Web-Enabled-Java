import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        if ("Servlet".equals(pass)) {
            req.setAttribute("user", user);
            RequestDispatcher rd = req.getRequestDispatcher("welcome");
            rd.forward(req, resp);
        } else {
            out.println("<p style='color:red'>Incorrect password</p>");
            RequestDispatcher rd = req.getRequestDispatcher("q3_login.html");
            rd.include(req, resp);
        }
    }
}
