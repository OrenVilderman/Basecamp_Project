package Extensions.DB;

import Utilities.CommonOps;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class DbActions extends CommonOps {
    @Step("Get Grafana user and password from credentials")
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

    @Step("Post Basecamp new user info to Basecamp Credentials Table")
    public static void postCredentials() {
        try {
            resultSet = statement.executeQuery("INSERT INTO `Basecamp_Users`(`Name`, `Email`, `Password`, `Company`) VALUES (" + "'" + _userName + "'" + ","
                    + "'" + _userEmail + "'" + "," + "'" + _password + "'" + "," + "'" + _companyName + "'" + ");");
        } catch (Exception e) {
            System.out.println("Error while posting data");
        }
    }
}
