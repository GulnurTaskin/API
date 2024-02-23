package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoHerOkuAppBookingdates;
import pojos.PojoHerOkuAppExpBody;
import pojos.PojoHerOkuAppReqBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_POJOClassPOST extends BaseUrlHerOkuApp {

    /*
https://restful-booker.herokuapp.com/booking url'ine
asagidaki body'ye sahip bir POST request gonderdigimizde
donen response'un asagidaki gibi oldugunu test edin.
                    Request body
               {
                    "firstname" : "Ahmet",
                    "lastname" : "Bulut",
                    "totalprice" : 500,
                    "depositpaid" : false,
                    "bookingdates" : {
                             "checkin" : "2021-06-01",
                             "checkout" : "2021-06-10"
                                      },
                    "additionalneeds" : "wi-fi"
                }
                   Response Body // expected data
                {
                "bookingid":24,
                "booking":{
                    "firstname":"Ahmet",
                    "lastname":"Bulut",
                    "totalprice":500,
                    "depositpaid":false,
                    "bookingdates":{
                        "checkin":"2021-06-01",
                        "checkout":"2021-06-10"
                    ,
                    "additionalneeds":"wi-fi"
                }
 */

   @Test
   public void test01(){

       specHerOkuApp.pathParam("pp1","booking");

       PojoHerOkuAppBookingdates bookingdatesPOJO = new PojoHerOkuAppBookingdates("2021-06-01","2021-06-10");
       PojoHerOkuAppReqBody reqBodyPOJO = new PojoHerOkuAppReqBody("Ahmet","Bulut",500,false,bookingdatesPOJO,"wi-fi");

       PojoHerOkuAppReqBody bookingPOJO = new PojoHerOkuAppReqBody("Ahmet","Bulut",500,false,bookingdatesPOJO,"wi-fi");
       PojoHerOkuAppExpBody expBodyPOJO = new PojoHerOkuAppExpBody(24,bookingPOJO);

       Response response = given().spec(specHerOkuApp).contentType(ContentType.JSON).when().body(reqBodyPOJO).post("{pp1}");

       PojoHerOkuAppExpBody responsePOJO = response.as(PojoHerOkuAppExpBody.class);




   }
}
