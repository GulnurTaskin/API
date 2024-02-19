package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

// herokuapp sitesinde yapacagimiz testler icin baseurl burada tanimliyoruz
// her zaman en basta calismasi icin before notasyonu ile isaretliyoruz

public class BaseUrlHerOkuApp {

    protected RequestSpecification specHerOkuApp;

    @Before
    public void setUp(){

        specHerOkuApp=new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .build();

        // Java'da "setBaseUri" metodunda "URI" terimi, genel bir tanımlayıcıyı ifade ederken,
        // "URL" ise belirli bir kaynağın konumunu belirten bir adresi ifade eder.
    }
}
