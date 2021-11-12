
import java.sql.*;
import java.util.*;

public class MySqlCon {
    public static Connection connection;
    public static Statement stmt;

    public MySqlCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp", "jr", "pass");
            stmt = connection.createStatement();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public static User getUser(String accNo, String pass) {
        try {
            PreparedStatement st = connection
                    .prepareStatement(String.format("Select * from users where acc_no='%s' AND password='%s'", accNo, pass));
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("acc_no"), rs.getString("name"),
                        rs.getString("password"), rs.getDouble("balance"), rs.getString("phone"),
                        rs.getString("aadhar_no"));
                System.out.println(user);
                return user;
            } else {
                return null;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
    public static User userExists(String accNo) {
        try {
            PreparedStatement st = connection
                    .prepareStatement(String.format("Select * from users where acc_no='%s'", accNo));
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("acc_no"), rs.getString("name"),
                        rs.getString("password"), rs.getDouble("balance"), rs.getString("phone"),
                        rs.getString("aadhar_no"));
                System.out.println(user);
                return user;
            } else {
                return null;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static User postUser(User user) {
        try {
            String query = String.format(
                    "insert into users (acc_no, name, password, balance, phone, aadhar_no) values ('%s', '%s', '%s', '%.2f', '%s', '%s');",
                    user.accNo, user.name, user.password, user.balance, user.phone, user.aadharNo);
            stmt.executeUpdate(query);
            PreparedStatement st = connection.prepareStatement(
                    String.format("Select * from users where acc_no='%s' AND password='%s'", user.accNo, user.password));
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User tempUser = new User(rs.getInt("id"), rs.getString("acc_no"), rs.getString("name"),
                        rs.getString("password"), rs.getDouble("balance"), rs.getString("phone"),
                        rs.getString("aadhar_no"));
                System.out.println(tempUser);
                return tempUser;
            } else {
                return null;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static List<Transaction> getTransactions(User user) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(String.format(
                    "Select * from transactions where from_acc_no='%s' OR to_acc_no='%s'", user.accNo, user.accNo));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String mode = rs.getString("from_acc_no").equals(String.valueOf(user.accNo)) ? "Send" : "Recieve";
                Transaction transaction = new Transaction(rs.getInt("id"), rs.getString("from_acc_no"),
                        rs.getString("to_acc_no"), rs.getDouble("amount"),rs.getTimestamp("time"), mode);
                System.out.println(transaction);
                transactions.add(transaction);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return transactions;
    }

    public static void postTransaction(User user, String toAccNo, double amount) {
        try {
            String query = String.format(
                    "insert into transactions (from_acc_no, to_acc_no, amount) values ('%s', '%s', %.2f);", user.accNo,
                    toAccNo, amount);
            stmt.executeUpdate(query);
            // Updating current user's balance
            query = String.format("update users set balance=balance-%.2f where acc_no=%s", amount, user.accNo);
            stmt.executeUpdate(query);
            // Updating the other user's balance
            query = String.format("update users set balance=balance+%.2f where acc_no=%s", amount, toAccNo);
            stmt.executeUpdate(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}