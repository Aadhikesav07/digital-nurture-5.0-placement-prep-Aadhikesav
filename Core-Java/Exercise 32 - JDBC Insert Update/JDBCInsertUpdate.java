import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

class StudentDAO {
    private static final String DB_URL = "jdbc:sqlite:Core-Java/sample.db";

    private void createTableIfNeeded(Connection connection) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT, grade INTEGER)");
        }
    }

    public void insertStudent(int id, String name, int grade) {
        String sql = "INSERT INTO students VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            createTableIfNeeded(connection);
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.setString(2, name);
                statement.setInt(3, grade);
                statement.executeUpdate();
            }
            System.out.println("Inserted: " + name);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void updateStudent(int id, int grade) {
        String sql = "UPDATE students SET grade = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            createTableIfNeeded(connection);
            int affectedRows;
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, grade);
                statement.setInt(2, id);
                affectedRows = statement.executeUpdate();
            }

            if (affectedRows > 0) {
                System.out.println("Updated student " + id + " to grade " + grade);
            } else {
                System.out.println("Student not found");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

public class JDBCInsertUpdate {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.insertStudent(3, "Charlie", 78);
        studentDAO.updateStudent(3, 88);
    }
}
