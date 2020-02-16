package Extensions.API;

import Utilities.CommonOps;
import Utilities.HelperMethods;
import Utilities.Team;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static Utilities.HelperMethods.*;

import java.util.Collections;
import java.util.List;

public class ApiActions extends CommonOps {

    @Step("Get Data From Server")
    public static Response get(String queryValues){
        response = httpRequest.get(queryValues);
        System.out.println(response.prettyPrint());
        return response;
    }

    @Step("Post New Data To Server")
    public static String post(JSONObject params, String resource){
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        System.out.println(response.prettyPrint());
        return response.getStatusLine();
    }

    @Step("Update Data In Server")
    public static String put(JSONObject params, String resource){
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
        System.out.println(response.prettyPrint());
        return response.getStatusLine();
    }

    @Step("Delete Data From Server")
    public static String delete(String resource){
        response = httpRequest.delete(resource);
        System.out.println(response.prettyPrint());
        return response.getStatusLine();
    }

    @Step("Extract Value From JSON Format")
    public static String extractFromJSON(Response response, String path){
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("Return New Random Team Details")
    public static Team returnNewTeamDetails() {
        String _teamName = HelperMethods.returnRandomName();
        String _teamEmail = _teamName + returnRandomThreeDigitNumber() + "@" + returnRandomEmailProvider() + ".com";
        Team team = new Team(_teamName, _teamEmail);
        teamNameList.add(team);
        return teamNameList.get(teamNameList.size() - 1);
    }

    @Step("Get The ID Of Last Created Team")
    public static String getLastCreatedTeamId() {
        //initGrafanaApi();
        response = httpRequest.get("api/teams/search");
        List<Integer> allGroupsId = response.jsonPath()
                .getList("teams.id");
        Integer maxId = Collections.max(allGroupsId);
        return maxId.toString();
    }



}
