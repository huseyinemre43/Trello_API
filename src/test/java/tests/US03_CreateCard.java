package tests;

import baseUrl.TrelloBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import testData.ConfigReader;
import testData.ReusableMethods;



@FixMethodOrder(MethodSorters.JVM)
public class US03_CreateCard  extends TrelloBaseUrl {

    String idCard;

    void createCard(String name) throws InterruptedException {

        ReusableMethods.setpathParams("cards");

        spec.queryParams("name", name,
                "idList", US02_CreateList.idList,
                "key", ConfigReader.getProperty("key"),
                "token", ConfigReader.getProperty("token"));

        Response response = ReusableMethods.postRequest();

        JsonPath resJP=response.jsonPath();
        idCard=resJP.get("id");
        System.out.println("idCard = " + idCard);
        System.out.println("1. Kart calisti");

        ReusableMethods.waitFor(7);

    }
    void createCard2(){

        spec.queryParams("name","Yumurta",
                "idList", ConfigReader.getProperty("idList"),
                "key", ConfigReader.getProperty("key"),
                "token", ConfigReader.getProperty("token"));

        Response response=ReusableMethods.postRequest();
        System.out.println("2. Kart calisti");
    }

    void updateCard(String name) throws InterruptedException {


        ReusableMethods.setpathParams("cards/" + idCard);

        spec.queryParams(
                "key", ConfigReader.getProperty("key"),
                "token", ConfigReader.getProperty("token"),
                "name",name);

        Response response=ReusableMethods.putRequest();

        response.prettyPrint();
        JsonPath resJP=response.jsonPath();

        String isim=resJP.get("name");
        System.out.println("Yeni isim = " + isim);
        System.out.println("Update calisti");

        ReusableMethods.waitFor(7);
    }

    void deleteCard() throws InterruptedException {


        ReusableMethods.setpathParams("cards/" + idCard);

        spec.queryParams(
                "key", ConfigReader.getProperty("key"),
                "token", ConfigReader.getProperty("token"));

        Response response=ReusableMethods.deleteRequest();

        System.out.println("Delete calisti");
        ReusableMethods.waitFor(10);
    }
    @Test
    public void test01() throws InterruptedException {

        createCard("Yumurta");
        updateCard("Sut");
        deleteCard();
    }
}

