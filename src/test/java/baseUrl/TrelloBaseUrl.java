package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.BeforeClass;
import testData.ConfigReader;

public class TrelloBaseUrl {

    public static RequestSpecification spec;

    @BeforeClass
    public static void beforeAPIScnerio() {
        spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("baseUrl"))
                .build();
    }
}
