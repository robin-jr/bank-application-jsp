import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.*;
import java.sql.*;

public class Account extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        String accNo = req.getParameter("acc_no");
        String password = req.getParameter("password");
        RequestDispatcher view = req.getRequestDispatcher("html/dashboard.html");
        // view.forward(req, res);

        // User user1 = new User(1, "100", "John", "password", 500.00, "1112223331", "123456789012");
        // User user2 = new User(2, "101", "Michael", "password", 500.00, "2223334445", "123456789012");
        new MySqlCon();
        User user = MySqlCon.getUser(accNo, password);
        if (user==null) {
            pw.println("Enter correct credentials");
        } else {
            pw.println(user);
        }
        // // var t =MySqlCon.postUser(user1);
        // // var t =MySqlCon.postUser(user2);
        // MySqlCon.postTransaction(user1, "101", 10.00);
        // var t =MySqlCon.getTransactions(user1);
        // pw.println(t);
    }
}
