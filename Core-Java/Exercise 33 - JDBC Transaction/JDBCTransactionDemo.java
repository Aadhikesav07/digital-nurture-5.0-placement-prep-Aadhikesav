import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JDBCTransactionDemo {
    private static final String DB_URL = "jdbc:sqlite:Core-Java/sample.db";

    private static void prepareAccounts(Connection connection) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS accounts (id INTEGER PRIMARY KEY, name TEXT, balance REAL)");
            statement.execute("INSERT OR IGNORE INTO accounts VALUES (1, 'Alice', 1000)");
            statement.execute("INSERT OR IGNORE INTO accounts VALUES (2, 'Bob', 500)");
        }
    }

    public static void transferFunds(int fromId, int toId, double amount) {
        String debitSql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            connection.setAutoCommit(false);
            prepareAccounts(connection);

            try (PreparedStatement debitStatement = connection.prepareStatement(debitSql);
                 PreparedStatement creditStatement = connection.prepareStatement(creditSql)) {
                debitStatement.setDouble(1, amount);
                debitStatement.setInt(2, fromId);
                debitStatement.executeUpdate();

                creditStatement.setDouble(1, amount);
                creditStatement.setInt(2, toId);
                creditStatement.executeUpdate();

                connection.commit();
                System.out.println("Transfer successful");
            } catch (Exception exception) {
                connection.rollback();
                System.out.println("Transfer failed, rolled back: " + exception.getMessage());
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void main(String[] args) {
        transferFunds(1, 2, 200);
    }
}
