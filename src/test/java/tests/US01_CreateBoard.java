package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testData.ConfigReader;
import testData.ReusableMethods;

import static baseUrl.TrelloBaseUrl.spec;

public class US01_CreateBoard {

    @Test
    public void createBoard(){
        ReusableMethods.setpathParams("boards");

     spec.queryParams("name","Kirmizi",
                 "key", ConfigReader.getProperty("key"),
                         "token", ConfigReader.getProperty("token"));

     Response response=ReusableMethods.postRequest();

     response.prettyPrint();
     JsonPath resJP=response.jsonPath();
     String idBoard=resJP.getString("id");




    }
}






