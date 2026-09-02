import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankTransfer {
    static final String URL = "jdbc:mysql://localhost:3306/jdbc_learning";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void transfer(int fromId, int toId, double amount) {
        String debit = "UPDATE accounts SET balance = balance - ? WHERE id = ? AND balance >= ?";
        String credit = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement debitPs = con.prepareStatement(debit);
             PreparedStatement creditPs = con.prepareStatement(credit)) {

            // Auto-commit off: dono operations ko ek single transaction banate hain.
            con.setAutoCommit(false);

            try {
                debitPs.setDouble(1, amount);
                debitPs.setInt(2, fromId);
                debitPs.setDouble(3, amount);
                int debited = debitPs.executeUpdate();

                if (debited != 1) {
                    throw new SQLException("Insufficient balance or source account not found");
                }

                creditPs.setDouble(1, amount);
                creditPs.setInt(2, toId);
                int credited = creditPs.executeUpdate();

                if (credited != 1) {
                    throw new SQLException("Destination account not found");
                }

                // Dono successful hain, ab permanent save.
                con.commit();
                System.out.println("Transfer successful");
            } catch (SQLException e) {
                // Beech mein koi operation fail hua to pehle operation ko bhi undo kar do.
                con.rollback();
                System.out.println("Transaction rolled back: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
