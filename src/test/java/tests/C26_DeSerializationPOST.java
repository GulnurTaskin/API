package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.HerOkuAppDatas;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C26_DeSerializationPOST extends BaseUrlHerOkuApp {

    /*
    https://restful-booker.herokuapp.com/booking url'ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response'un id haric asagidaki gibi oldugunu test edin.
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

        // 1- endpoint ve request body hazirlanir

        specHerOkuApp.pathParam("pp1","booking");

        Map<String,Object> reqBody = HerOkuAppDatas.reqBodyOlustur();

        // 2- expected body hazirlanir

        Map<String,Object> expBody = HerOkuAppDatas.expBodyOlustur();

        // 3- request gonderilir ve gelen veri response olarak kaydedilir

        Response response=given().spec(specHerOkuApp).contentType(ContentType.JSON)
                          .when().body(reqBody).post("{pp1}");
            /* burdaki ='den sonraki tum ifadeler response ile alakalidir*/

        // 4- gelen response map'e donusturulur ve assertion yapilir
            /* sorgumuzu map'le gondermemize ragmen API'den donen response json olacaktir
               o yuzden gelen response'u map'e donusturuyoruz */

        Map<String,Object> resMAP=response.as(HashMap.class);

        assertEquals(((Map)expBody.get("booking")).get("firstname"),((Map)resMAP.get("booking")).get("firstname"));
        assertEquals(((Map) expBody.get("booking")).get("lastname"),((Map) resMAP.get("booking")).get("lastname"));
        assertEquals(((Map) expBody.get("booking")).get("totalprice"),((Map) resMAP.get("booking")).get("totalprice"));
        assertEquals(((Map) expBody.get("booking")).get("depositpaid"),((Map) resMAP.get("booking")).get("depositpaid"));
        assertEquals(((Map) expBody.get("booking")).get("additionalneeds"),((Map) resMAP.get("booking")).get("additionalneeds"));
        assertEquals(((Map)((Map)expBody.get("booking")).get("bookingdates")).get("checkin"),((Map)((Map)resMAP.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(((Map)((Map)expBody.get("booking")).get("bookingdates")).get("checkout"),((Map)((Map)resMAP.get("booking")).get("bookingdates")).get("checkout"));

        /* burda ic ice map var, o yuzden (((Map)((Map)expBody... yaptik

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
    }


}
