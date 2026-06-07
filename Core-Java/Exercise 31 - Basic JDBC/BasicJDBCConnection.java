import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasicJDBCConnection {
    private static final String DB_URL = "jdbc:sqlite:Core-Java/sample.db";

    private static boolean loadDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
            return true;
        } catch (ClassNotFoundException exception) {
            System.out.println("SQLite JDBC driver not found");
            return false;
        }
    }

    private static void initializeData(Statement statement) throws Exception {
        statement.execute("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT, grade INTEGER)");
        statement.execute("INSERT OR IGNORE INTO students VALUES (1, 'Alice', 85)");
        statement.execute("INSERT OR IGNORE INTO students VALUES (2, 'Bob', 92)");
    }

    public static void main(String[] args) {
        if (!loadDriver()) {
            return;
        }

        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {
            initializeData(statement);

            try (ResultSet rows = statement.executeQuery("SELECT * FROM students")) {
                while (rows.next()) {
                    System.out.println(
                            rows.getInt("id") + " "
                                    + rows.getString("name") + " "
                                    + rows.getInt("grade")
                    );
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
