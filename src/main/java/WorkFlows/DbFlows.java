package WorkFlows;

import Extensions.API.ApiActions;
import Extensions.DB.DbActions;
import Extensions.Web.UiActions;
import Utilities.CommonOps;
import Utilities.HelperMethods;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

public class DbFlows extends CommonOps{
    public static String userNameFromDB;
    @Step("Log in to grafana - credentials from DB")
    public static void grafanaLogInFromDB() throws InterruptedException {
        grafanaSignInAsAdmin();
        response = httpRequest.get("/api/users/search");
        jp = response.jsonPath();
        String userIndexForCredentials = String.valueOf(HelperMethods.returnRandomNumberFromInt(ApiActions.getUsersTotalCount())-1);
        List<String> testCred =
                DbActions.getCredentials(
                        jp.get("users[" + userIndexForCredentials + "].id").toString());
        grafanaSignOut();
        UiActions.insertKeys(grafanaForDbLoginPage.userName_field, testCred.get(0));
        userNameFromDB = testCred.get(0);
        UiActions.insertKeysAndClick(grafanaForDbLoginPage.password_field, testCred.get(1), grafanaForDbLoginPage.logIn_btn);
        UiActions.click(grafanaForDbLoginPage.skip_btn);
        UiActions.mouseHover(grafanaForDbMainPage.avatar_img, grafanaForDbMainPage.userName);
    }

    @Step("Sign out from grafana and sign in again as admin")
    public static void grafanaSignInAsAdmin() {
        if (driver.getCurrentUrl().equalsIgnoreCase("http://localhost:3000/login")) {
            UiActions.insertKeys(grafanaForDbLoginPage.userName_field, "admin");
            UiActions.insertKeysAndClick(grafanaForDbLoginPage.password_field, "admin", grafanaForDbLoginPage.logIn_btn);
            UiActions.click(grafanaForDbLoginPage.skip_btn);
        } else if (!driver.findElement(By.xpath("//li[3]/span")).getText().equalsIgnoreCase("admin")) {
            grafanaSignOut();
            UiActions.insertKeys(grafanaForDbLoginPage.userName_field, "admin");
            UiActions.insertKeysAndClick(grafanaForDbLoginPage.password_field, "admin", grafanaForDbLoginPage.logIn_btn);
            UiActions.click(grafanaForDbLoginPage.skip_btn);
        } else {
        }
    }

    @Step("Sign out from grafana")
    public static void grafanaSignOut(){
        UiActions.mouseHover(grafanaForDbMainPage.avatar_img, grafanaForDbMainPage.logOut_btn);
    }
}
