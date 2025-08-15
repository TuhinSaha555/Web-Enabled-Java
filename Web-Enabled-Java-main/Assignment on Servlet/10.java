import java.io.*;
import java.util.regex.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String gender = req.getParameter("gender");
        String dob = req.getParameter("dob");

        StringBuilder errors = new StringBuilder();

        // Name validation
        if (name == null || name.trim().isEmpty()) {
            errors.append("<p>Name is required.</p>");
        }

        // Password validation
        if (password == null || password.length() < 6) {
            errors.append("<p>Password must be at least 6 characters long.</p>");
        }

        // Email validation
        if (email == null || !Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email)) {
            errors.append("<p>Invalid email format.</p>");
        }

        // Phone validation
        if (phone == null || !Pattern.matches("\\d{10}", phone)) {
            errors.append("<p>Phone must be a 10-digit number.</p>");
        }

        // Gender validation
        if (gender == null) {
            errors.append("<p>Please select gender.</p>");
        }

        // DOB validation
        if (dob == null || dob.trim().isEmpty()) {
            errors.append("<p>Please select Date of Birth.</p>");
        }

        // Show errors or success
        if (errors.length() > 0) {
            out.println("<h3>Registration Failed:</h3>");
            out.println(errors.toString());
            out.println("<p><a href='registration.html'>Go back</a></p>");
        } else {
            out.println("<h3>Registration Successful!</h3>");
            out.println("<p>Name: " + name + "</p>");
            out.println("<p>Email: " + email + "</p>");
            out.println("<p>Phone: " + phone + "</p>");
            out.println("<p>Gender: " + gender + "</p>");
            out.println("<p>Date of Birth: " + dob + "</p>");
        }
    }
}
