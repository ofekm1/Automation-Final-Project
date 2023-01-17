package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageDB extends CommonOps {
    public static void openConnection(String dbURL, String user, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, user, pass);
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Error trying to connect to DB, see details: " + e);
        }
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
