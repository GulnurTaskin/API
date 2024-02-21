package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C16_baseUrlHerOkuAppQuery2 extends BaseUrlHerOkuApp {

    /*
    https://restful-booker.herokuapp.com/booking endpointine
    gerekli Query parametrelerini yazarak
        "firstname" degeri "Susan"
        ve "lastname" degeri "Ericson" olan
    rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
    donen response'un
        status code'unun 200 oldugunu
        ve "Eric Jones" ismine sahip en az bir booking oldugunu test edin
 */
    @Test
    public void queryParams(){
        specHerOkuApp.pathParam("pp1","booking").queryParams("firstname","Sally","lastname","Jackson");


        Response response=given().when().spec(specHerOkuApp).get("/{pp1}");

        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(1));
    }


}