package tests;

import baseUrl.TrelloBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import testData.ConfigReader;
import testData.ReusableMethods;

public class US04_DeleteBoard extends TrelloBaseUrl {

    @Test
    public void deleteCard(){


        ReusableMethods.setpathParams("boards/" + US01_CreateBoard.idBoard);

        spec.queryParams(
                "key", ConfigReader.getProperty("key"),
                "token", ConfigReader.getProperty("token"));

        Response response=ReusableMethods.deleteRequest();

        System.out.println("Delete Board calisti");
    }
}


