package WorkFlows;

import Extensions.API.ApiActions;
import Utilities.CommonOps;
import Utilities.HelperMethods;
import Utilities.Team;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static Extensions.API.ApiActions.get;
import static Extensions.API.ApiActions.returnNewTeamDetails;

public class ApiFlows extends CommonOps {
    @Step("Get Team From Grafana")
    public static String getTeamProperty(String jPath) {
        Response response = ApiActions.get("/api/teams/search");
        return ApiActions.extractFromJSON(response, jPath);                 //jPath will describe the specific team requested for test
    }

    @Step("Get Team From Grafana")
    public static String getTeamsList(String jPath) {
        Response response = ApiActions.get("/api/teams/search");
        return response.toString();
    }

    @Step("Create New Team In Grafana Server")
    public static void postNewTeam() {
        Team team = returnNewTeamDetails();
        requestParams.put("name", team.teamName);
        requestParams.put("email",team.teamEmail);
        ApiActions.post(requestParams, "/api/teams");
    }

    @Step("Update Last Created Team Name And Email")
    public static void updateLastTeamDetails() {
        jp = get("/api/teams/" + ApiActions.getLastCreatedTeamId()).jsonPath();
        teamName = jp.get("name").toString();
        teamEmail = jp.get("email").toString();
        requestParams.put("name", teamName + "-AFTER_CHANGE");
        requestParams.put("email", teamEmail + "-AFTER_CHANGE");
        ApiActions.put(requestParams, "/api/teams/" + ApiActions.getLastCreatedTeamId());
        System.out.println(response.prettyPrint());
    }



}
