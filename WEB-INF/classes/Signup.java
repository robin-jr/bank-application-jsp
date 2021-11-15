import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.*;
import java.util.List;

public class Signup extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        String accNo = req.getParameter("acc_no");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String aadharNo = req.getParameter("aadhar-no");
        
        User user = new User(1, accNo, name, password, 500.00, phone, aadharNo);
        // User user2 = new User(2, "101", "Michael", "password", 500.00, "2223334445", "123456789012");
        // User user2 = new User(2, "101", "Michael", "password", 500.00, "2223334445", "123456789012");
        
        new MySqlCon();
        // user = MySqlCon.getUser(accNo, password);
        user = MySqlCon.postUser(user);
        if (user==null) {
            pw.println("Enter correct credentials");
        } else {
            res.sendRedirect("/hello");
            // List<Transaction> transactions =MySqlCon.getTransactions(user);
            // req.setAttribute("user", user);
            // req.setAttribute("transactions", transactions);
            // RequestDispatcher view = req.getRequestDispatcher("html/dashboard.jsp");
            // view.forward(req, res);
        }
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        
        // User user1 = new User(1, "100", "John", "password", 500.00, "1112223331", "123456789012");
        // User user2 = new User(2, "101", "Michael", "password", 500.00, "2223334445", "123456789012");
        // User user2 = new User(2, "101", "Michael", "password", 500.00, "2223334445", "123456789012");
        
        RequestDispatcher view = req.getRequestDispatcher("html/sign-up.html");
        view.forward(req, res);
    }
}
