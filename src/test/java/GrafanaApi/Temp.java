package GrafanaApi;

import Utilities.CommonOps;
import Utilities.Team;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static Extensions.API.ApiActions.*;

public class Temp extends CommonOps {

    @Test
    public void test01Get(){
        //initGrafanaApi();
        response = httpRequest.get("api/teams/search?perpage=50&page=1");
        System.out.println("Test GET Response body: " + response.getBody().prettyPrint());
        System.out.println("Test GET Status line is: " + response.getStatusLine());
    }

    @Test
    public void test02Post(){
        //initGrafanaApi();
        JSONObject params = new JSONObject();
        Team team = returnNewTeamDetails();
        params.put("name", team.teamName);
        params.put("email",team.teamEmail);
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post("/api/teams");
        System.out.println("Test POST Response body: " + response.getBody().prettyPrint());
        System.out.println("Test POST Status line is: " + response.getStatusLine());
    }

    @Test
    public void test03Put(){
        //initGrafanaApi();
        String lastTeamCreatedId = getLastCreatedTeamId();
        response = httpRequest.get("/api/teams/" + lastTeamCreatedId);
        JsonPath jp = response.jsonPath();
        JSONObject params = new JSONObject();
        params.put("name", jp.get("name").toString() + "-ChangedName");
        params.put("email",jp.get("email").toString() + "-ChangedEmail");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put("/api/teams/" + lastTeamCreatedId);
        System.out.println("Test PUT Response body: " + response.getBody().prettyPrint());
        System.out.println("Test PUT Status line is: " + response.getStatusLine());

    }

    @Test
    public void test03Delete(){
        //initGrafanaApi();
        String lastTeamCreatedId = getLastCreatedTeamId();
        response = httpRequest.delete("/api/teams/" + lastTeamCreatedId);
        System.out.println("Test DELETE Response body: " + response.getBody().prettyPrint());
        System.out.println("Test DELETE Status line is: " + response.getStatusLine());
    }
}
