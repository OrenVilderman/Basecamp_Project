package WorkFlows;

import Extensions.API.ApiActions;
import Utilities.CommonOps;
import Utilities.HelperMethods;
import Utilities.Team;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.openqa.selenium.By;

import static Extensions.API.ApiActions.get;
import static Extensions.API.ApiActions.returnNewTeamDetails;

public class ApiFlows extends CommonOps {
    @Step("Get Team From Grafana")
    public static String getTeamProperty(String jPath) {
        response = ApiActions.get("/api/teams/search");
        return ApiActions.extractFromJSON(response, jPath);                 //jPath will describe the specific team requested for test
    }

    @Step("Get Team From Grafana")
    public static String getTeamsList(String jPath) {
        response = ApiActions.get("/api/teams/search");
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

    @Step("Delete Random Team From Grafana")
    public static void deleteRandomTeam(){
        int totalCount = ApiActions.getTeamTotalCount();
        if (totalCount > 0) {
            String teamIndexForDelete = HelperMethods.returnRandomNumberForIndex(totalCount);
            teamIdForDelete = getTeamProperty("teams[" + teamIndexForDelete + "].id");
            System.out.println("Team id for delete is: " + teamIdForDelete);
            ApiActions.delete("api/teams/" + teamIdForDelete);
        }
        else {
            System.out.println("No Teams Available for Delete");
        }
    }

    @Step("Get team name from UI")
    public static Team getTeamDetailFromUI(int teamIndex){
        CommonOps.initBrowser();
        driver.get("http://localhost:3000/");
        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        driver.findElement(By.xpath("//form/div/a")).click();
        driver.get("http://localhost:3000/org/teams");
        Team team = new Team(driver.findElement(By.xpath("//tr[" + teamIndex + "]/td[2]/a")).getText(),
                             driver.findElement(By.xpath("//tr[" + teamIndex + "]/td[3]/a")).getText());
        driver.quit();
        return team;
    }

    @Step("Get Random Existing Team Name and Email")
    public static Team getRandomTeamDetails(){
        teamIndexForUiVerification = HelperMethods.returnRandomNumberFromInt(ApiActions.getTeamTotalCount());
        return getTeamDetailFromUI(teamIndexForUiVerification);
    }

}
