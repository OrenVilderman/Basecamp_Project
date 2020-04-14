package WorkFlows;

import Extensions.Mobile.UiActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;

import static Utilities.HelperMethods.getDataFromXML;

public class MobileFlows extends CommonOps {

    @Step("Login to Application")
    public static void login(String userEmail, String password) throws InterruptedException {
        UiActions.click(mobileBasecampLoginPage.loginToBasecamp_btn);
        UiActions.insertKeysAndClick(mobileBasecampLoginPage.loginEmail_field, getDataFromXML("UserEmail"), mobileBasecampLoginPage.next1_btn);
        Thread.sleep(3000);
        UiActions.insertKeysAndClick(mobileBasecampLoginPage.password_field, getDataFromXML("Password"), mobileBasecampLoginPage.next2_btn);
    }

    @Step("Logout from Application")
    public static void logout() {
        UiActions.click(mobileBottomMenu.myStuffMenu_btn);

        UiActions.click(mobileMyStuffPage.logout_btn);
        UiActions.click(mobileMyStuffPage.logoutOk_btn);
    }



}
