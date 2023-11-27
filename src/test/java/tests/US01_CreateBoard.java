package tests;

import baseUrl.TrelloBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testData.ConfigReader;
import testData.ReusableMethods;

import static baseUrl.TrelloBaseUrl.spec;

public class US01_CreateBoard extends TrelloBaseUrl {

    public static String idBoard;


    @Test
    public void createBoard() throws InterruptedException {
        ReusableMethods.setpathParams("boards");

        spec.queryParams("name", "Yesil",
                "key", ConfigReader.getProperty("key"),
                "token", ConfigReader.getProperty("token"));

        Response response = ReusableMethods.postRequest();

        response.prettyPrint();
        JsonPath resJP = response.jsonPath();

        idBoard = resJP.getString("id");
        System.out.println("idBoard = " + idBoard);

        ReusableMethods.waitFor(10);

    }
}











