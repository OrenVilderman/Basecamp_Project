package Extensions.DB;

import Utilities.CommonOps;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class DbActions extends CommonOps {
    @Step("get user and password from credentials")
    public static List<String> getCredentials(String UserID) {
        List<String> credentials = new ArrayList<String>();
        try {
            resultSet = statement.executeQuery("SELECT UserName, Password FROM Credentials WHERE ID = " + UserID + ";");
            resultSet.next();
            credentials.add(resultSet.getString(1));
            credentials.add(resultSet.getString(2));

        } catch (Exception e) {
            System.out.println("Error while retrieving data");
        }
        return credentials;
    }
}
