package Electron;

import Extensions.Web.Verifications;
import Utilities.CommonOps;
import WorkFlows.ElectronFlow;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.Listeners.class)
public class ElectronTests extends CommonOps {

    @Test(description = "Check Electron Screen Info")
    @Description("Check Electron Screen Info Correct for 1920px X 1200px")
    public void checkScreenInfo() {
        ElectronFlow.checkScreenInfo();
        Verifications.verifyTextInElement(electronMainPage.screenInfo_txt, "Your screen is: 1920px x 1200px");
    }
}
