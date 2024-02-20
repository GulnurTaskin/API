package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlJsonPlaceUrl {


    protected RequestSpecification specJsonPlaceHolder;

    @Before
    public void setUp(){

        specJsonPlaceHolder=new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();

        // Java'da "setBaseUri" metodunda "URI" terimi, genel bir tanımlayıcıyı ifade ederken,
        // "URL" ise belirli bir kaynağın konumunu belirten bir adresi ifade eder.
    }
}
