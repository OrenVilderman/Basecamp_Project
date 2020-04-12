package GrafanaDB;

import Utilities.CommonOps;
import WorkFlows.DbFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static WorkFlows.DbFlows.userNameFromDB;

public class SanityDB extends CommonOps {
    @Test(description = "Login to Grafana with DataBase Credentials")
    @Description("Test description: Adding a new project")
    public void tesSignInFromDB() throws InterruptedException {
        DbFlows.grafanaLogInFromDB();
        Extensions.Web.Verifications.verifyTextInElement(grafanaForDbMainPage.userName, userNameFromDB);
    }

}
