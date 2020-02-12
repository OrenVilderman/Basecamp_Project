package GrafanaApi;

import Utilities.CommonOps;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static Utilities.HelperMethods.getDataFromXML;

public class Temp extends CommonOps {

    @Test
    public void test01(){
        RestAssured.baseURI = getDataFromXML("APIurl");
        httpRequest = RestAssured.given().auth().preemptive().
                      basic(getDataFromXML("grafanaUserName"),
                      getDataFromXML("grafanaPassword"));

        response = httpRequest.get("api/teams/search?perpage=50&page=1");
        System.out.println("Response body: " + response.getBody().asString());
        System.out.println("Status line is: " + response.getStatusLine());
    }
}
