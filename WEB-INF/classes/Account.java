import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.*;
import java.util.List;

public class Account extends HttpServlet {
    static User user;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        String accNo = req.getParameter("acc_no");
        String password = req.getParameter("password");
        
        // User user1 = new User(1, "100", "John", "password", 500.00, "1112223331", "123456789012");
        // User user2 = new User(2, "101", "Michael", "password", 500.00, "2223334445", "123456789012");
        
        new MySqlCon();
        user = MySqlCon.getUser(accNo, password);
        if (user==null) {
            pw.println("Enter correct credentials");
        } else {
            List<Transaction> transactions =MySqlCon.getTransactions(user);
            req.setAttribute("user", user);
            req.setAttribute("transactions", transactions);
            RequestDispatcher view = req.getRequestDispatcher("html/dashboard.jsp");
            view.forward(req, res);
        }
    }
}
