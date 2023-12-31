package testData;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static baseUrl.TrelloBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class ReusableMethods {

   public static Response response;
    static String fullPath;

    public static String setpathParams(String rawPath) {


        String [] paths = rawPath.split("/");
        StringBuilder tempPath = new StringBuilder("/{");
        for (int i = 0; i < paths.length ; i++) {
            String key = "pp" + (i + 1);
            String value = paths[i];
            spec.pathParam(key,value);
            tempPath.append( key + "}/{" );
        }
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));
        fullPath = tempPath.toString();


        return fullPath;
    }
    public static Response postRequest(Object reqBody){
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody)
                .post(fullPath);
        return response;
    }
    public static Response postRequest(){
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .post(fullPath);
        return response;
    }
    public static Response putRequest(){
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .put(fullPath);
        return response;
    }
    public static Response putRequest(Object reqBody){
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .put(fullPath);
        return response;
    }
    public static Response deleteRequest(){
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .delete(fullPath);
        return response;
    }

    public static void waitFor(int saniye) {

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {

        }
    }
}
