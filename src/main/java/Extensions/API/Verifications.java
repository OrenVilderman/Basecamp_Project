package Extensions.API;

import Utilities.CommonOps;
import static org.testng.Assert.*;
import static WorkFlows.ApiFlows.*;

import Utilities.HelperMethods;
import Utilities.Team;
import WorkFlows.ApiFlows;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;

public class Verifications extends CommonOps {

    @Step("Verify Text From Response")
    public static void verifyNameAndEmailFromUI() {
        Team team = ApiFlows.getRandomTeamDetails();
        assertEquals(ApiFlows.getTeamProperty("teams[" + String.valueOf(teamIndexForUiVerification-1) + "].name"), team.teamName);
        assertEquals(ApiFlows.getTeamProperty("teams[" + String.valueOf(teamIndexForUiVerification-1) + "].email"), team.teamEmail);
    }

    @Step("Verify New Team Created Successfully")
    public static void verifyNewTeamCreated() {
        jp = ApiActions.get("/api/teams/" + ApiActions.getLastCreatedTeamId()).jsonPath();
        assertEquals(jp.get("name").toString(), HelperMethods.teamNameList.get(HelperMethods.teamNameList.size()-1).teamName);
    }

    @Step("Verify Details Update For Last Created Team")
    public static void verifyLastCreatedTeamDetailsUpdate() {
        jp = ApiActions.get("/api/teams/" + ApiActions.getLastCreatedTeamId()).jsonPath();
        assertTrue(jp.get("name").toString().equalsIgnoreCase(teamName + "-AFTER_CHANGE") && jp.get("email").toString().equalsIgnoreCase(teamEmail + "-AFTER_CHANGE"));
    }

    @Step("Verify Selected Team Deleted Successfully")
    public static void verifyRandomTeamDeleted() {
        boolean isTeamDeleted = true;
        response = httpRequest.get("/api/teams/search");
        jp = response.jsonPath();
        List<Integer> teamsList = jp.getList("teams.id");
            for (int id : teamsList) {
            if (id == Integer.valueOf(teamIdForDelete)) {
                isTeamDeleted = false;
                break;
            }
        }
        assertTrue(isTeamDeleted);
    }

}
