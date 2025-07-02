package kce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbckce {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/kce";
        String username = "root";
        String password = "root";
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful!");


            System.out.println("Welcome to the Banking Application");
            // String create = "CREATE TABLE IF NOT EXISTS bank (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), balance DOUBLE)";
            // PreparedStatement createStmt = conn.prepareStatement(create);
            // createStmt.executeUpdate();
            // System.out.println("Table created successfully!");

            while (true) {
                System.out.println("1. Create Account");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Check Balance");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1: 
                        int id;
                        System.out.print("Enter your account ID: ");
                        id = sc.nextInt();
                        System.out.print("Enter your name: ");
                        String name = sc.next();
                        String createAccount = "INSERT INTO bank (id, name, balance) VALUES (?, ?, 0)";
                        PreparedStatement createStmt = conn.prepareStatement(createAccount);

                        createStmt.setInt(1, id);
                        createStmt.setString(2, name);
                        createStmt.executeUpdate();
                        System.out.println("Account created successfully!");
                        break;

                    case 2:
                        System.out.print("Enter your account ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        String depositQuery = "UPDATE bank SET balance = balance + ? WHERE id = ?";
                        PreparedStatement depositStmt = conn.prepareStatement(depositQuery);
                        depositStmt.setDouble(1, depositAmount);
                        depositStmt.setInt(2, id);
                        int rowsAffected = depositStmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Deposit successful!");
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter your account ID: ");
                        int withdrawId = sc.nextInt();
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        String withdrawQuery = "UPDATE bank SET balance = balance - ? WHERE id = ? AND balance >= ?";
                        PreparedStatement withdrawStmt = conn.prepareStatement(withdrawQuery);
                        withdrawStmt.setDouble(1, withdrawAmount);
                        withdrawStmt.setInt(2, withdrawId);
                        withdrawStmt.setDouble(3, withdrawAmount);
                        int rowsWithdrawn = withdrawStmt.executeUpdate();
                        if (rowsWithdrawn > 0) {
                            System.out.println("Withdrawal successful!");
                        } else {
                            System.out.println("Insufficient balance or account not found!");
                        }
                        break;

                    case 4:
                        System.out.print("Enter your account ID: ");
                        int checkId = sc.nextInt();
                        String checkBalanceQuery = "SELECT balance FROM bank WHERE id = ?";
                        PreparedStatement checkBalanceStmt = conn.prepareStatement(checkBalanceQuery);
                        checkBalanceStmt.setInt(1, checkId);
                        ResultSet rs = checkBalanceStmt.executeQuery();
                        if (rs.next()) {
                            double balance = rs.getDouble("balance");
                            System.out.println("Your balance is: " + balance);
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
}
}
