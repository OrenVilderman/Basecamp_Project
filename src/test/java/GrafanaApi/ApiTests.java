package GrafanaApi;

import Extensions.API.ApiActions;
import Extensions.API.Verifications;
import Utilities.CommonOps;
import WorkFlows.ApiFlows;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class ApiTests extends CommonOps {
    @Test(description = "Test Get All Teams From Server")
    @Description("Test Description: Get Full List Of Teams From The Server")
    public void getTeamName(){
        Extensions.API.Verifications.verifyTextGetResponse(ApiFlows.getTeamProperty("teams[1].name"), "Goodman");
    }

    @Test(description = "Create New Team In Server")
    @Description("Test Description: Create New Team In Server And Verify Name")
    public void postNewTeam(){
        ApiFlows.postNewTeam();
        Verifications.verifyNewTeamCreated();
    }

    @Test(description = "Update Last Created Team Name And Email")
    @Description("Test Description: Update Last Created Team Name And Email - Adding \"AFTER_CHANGE\" In The End And Verify Both Changes")
    public void updateTeamDetails(){
        ApiFlows.updateLastTeamDetails();
        Verifications.verifyLastCreatedTeamDetailsUpdate();
    }

    @Test(description = "Update Last Created Team Name And Email")
    @Description("Test Description: Update Last Created Team Name And Email - Adding \"AFTER_CHANGE\" In The End And Verify Both Changes")
    public void deleteTeam(){
        ApiFlows.deleteRandomTeam();
        Verifications.verifyRandomTeamDeleted();
    }

}
