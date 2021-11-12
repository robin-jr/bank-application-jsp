import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;

public class SendMoney extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        String accNo = req.getParameter("to_acc_no");
        Double amount = Double.parseDouble(req.getParameter("amount"));
        
        User user = Account.user;
        User user2 = MySqlCon.userExists(accNo);
        
        if (user==null) {
            pw.println("Enter correct credentials");
        } else if(accNo.equals(user.accNo)){
            pw.println("You cannot send money to yourself");
        } else if(user.balance-amount<0){
            pw.println("You do not have sufficient balance to make this transaction");
        }else if(user2==null){
            pw.println("The entered account number does not exist in our system");
        } else {
            MySqlCon.postTransaction(user,accNo,amount);
            pw.println(String.format("%.2f successfully transferred to %s of account number %s %s",amount,user2.name,accNo,user.accNo));
        }
        pw.println("<br/><a href='javascript:history.back()'>Go Back</a>");
    }
}