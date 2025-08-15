import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String s1 = req.getParameter("num1");
        String s2 = req.getParameter("num2");
        String op = req.getParameter("op");

        out.println("<html><body>");
        out.println("<h2>Calculation Result</h2>");

        try {
            double num1 = Double.parseDouble(s1);
            double num2 = Double.parseDouble(s2);
            double result;

            switch (op) {
                case "add": result = num1 + num2; break;
                case "sub": result = num1 - num2; break;
                case "mul": result = num1 * num2; break;
                case "div":
                    if (num2 == 0) {
                        out.println("<p style='color:red'>Error: Division by zero</p>");
                        out.println("</body></html>");
                        return;
                    }
                    result = num1 / num2;
                    break;
                case "mod":
                    if (num2 == 0) {
                        out.println("<p style='color:red'>Error: Modulo by zero</p>");
                        out.println("</body></html>");
                        return;
                    }
                    result = num1 % num2;
                    break;
                default:
                    out.println("<p>Unknown operation.</p>");
                    out.println("</body></html>");
                    return;
            }

            out.printf("<p>%s %s %s = <strong>%s</strong></p>",
                    s1, getSymbol(op), s2, result);

        } catch (NumberFormatException e) {
            out.println("<p style='color:red'>Invalid number input. Please enter numeric values.</p>");
        }

        out.println("<p><a href=\"calculator.html\">Back</a></p>");
        out.println("</body></html>");
    }

    private String getSymbol(String op) {
        switch (op) {
            case "add": return "+";
            case "sub": return "−";
            case "mul": return "×";
            case "div": return "÷";
            case "mod": return "%";
            default: return "";
        }
    }
}
