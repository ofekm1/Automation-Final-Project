package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {
    @Step("Get credentials from database")
    public static List<String> getCredentials(String query) {
        List<String> credentials = new ArrayList<String>();
        try {
            resultSet = statement.executeQuery(query);
            resultSet.next();
            credentials.add(resultSet.getString(1));
            credentials.add(resultSet.getString(2));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return credentials;
    }
}
