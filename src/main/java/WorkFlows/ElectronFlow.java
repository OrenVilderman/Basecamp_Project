package WorkFlows;

import Extensions.Web.UiActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;

public class ElectronFlow extends CommonOps {

    @Step("Check Screen Appearance")
    public static void checkScreenInfo(){
    UiActions.click(electronMainPage.system_systemInfo_btn);
    if (!electronMainPage.viewDemo_btn.isDisplayed()){
        UiActions.click(electronMainPage.getScreenInfo_btn);
    }
    UiActions.click(electronMainPage.viewDemo_btn);
    }
}
