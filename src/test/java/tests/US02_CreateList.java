package tests;

import baseUrl.TrelloBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testData.ConfigReader;
import testData.ReusableMethods;

public class US02_CreateList extends TrelloBaseUrl {

    public static String idList;
    @Test
    public void createList() throws InterruptedException {

        ReusableMethods.setpathParams("lists");

        spec.queryParams("name","Eksikler",
                "idBoard",US01_CreateBoard.idBoard,
                "key", ConfigReader.getProperty("key"),
                "token", ConfigReader.getProperty("token"));

        Response response=ReusableMethods.postRequest();

        response.prettyPrint();
        JsonPath resJP=response.jsonPath();

        idList=resJP.get("id");
        System.out.println("idList = " + idList);

        ReusableMethods.waitFor(10);
    }
}


