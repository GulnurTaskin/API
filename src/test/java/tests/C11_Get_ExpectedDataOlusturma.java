package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class C11_Get_ExpectedDataOlusturma {
/*
    https://jsonplaceholder.typicode.com/posts/22 url'ine
    bir GET request yolladigimizda
    donen response body'sinin asagida verilen ile ayni oldugunu test ediniz

    Response body :

    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }

 */

    @Test
    public void expectedBodyTesti(){

        // 1- endpoint ve reqbody hazirlanir

        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2- expected data hazirlanir

        JSONObject expBody = new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        // 3- request gonder response kaydet

        Response response = given().when().get(url);

        // 4- asssertion islemi
        /*
        Şimdiye kadar kullandığımız assertThat() metodu ile yapılan testlerdeki gibi assertion yapılabilir
        Frameworkümüzü geliştirmek için dinamik bir yapı kazandırabiliriz. Bunu için de HardAssert kullanabiliriz.
        Bunun için JUnit kullanacağız
         */

        // expBody bir json obje, response'muz json obje degil, o yuzden response'u json path yapmamiz lazim
        // jsonPath'e cevirince response dinamik hale geliyor, isimiz daha kolaylasiyor
        JsonPath respJsonPath = response.jsonPath();
        assertEquals(expBody.get("userId"),respJsonPath.get("userId"));
        assertEquals(expBody.get("id"),respJsonPath.get("id"));
        assertEquals(expBody.get("title"),respJsonPath.get("title"));
        assertEquals(expBody.get("body"),respJsonPath.get("body"));


    }
}
