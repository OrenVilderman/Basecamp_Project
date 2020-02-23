package GrafanaApi;

import Extensions.API.Verifications;
import Utilities.CommonOps;
import WorkFlows.ApiFlows;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class ApiTests extends CommonOps {
    @Test(description = "Test Get Team's Name and Email From Server")
    @Description("Test Description: Gets a Name and email of a Team From Server and assert from UI")
    public void getTeamName(){
        Verifications.verifyNameAndEmailFromUI();
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
