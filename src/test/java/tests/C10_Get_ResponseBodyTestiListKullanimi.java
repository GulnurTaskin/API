package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestiListKullanimi {

/*
    http://dummy.restapiexample.com/api/v1/employees url'ine
    bir GET request yolladigimizda
        donen Response'in
            status code'unun 200,
            ve content type'inin Aplication.JSON,
            ve response body'sindeki
            employees sayisinin 24
            ve employee'lerden birinin "Ashton Cox"
            ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin.
 */

   @Test
   public void ListKullanimi(){

       // 1- endpoint ve reqbody hazirlama

       String url = "http://dummy.restapiexample.com/api/v1/employees";

       // 2- expected data

       // 3- Request gonder ve responsu kaydet

       Response response = given().when().get(url);
            // eger bi expected data gonderecek olursak, given'dan sonra contentType'ini,
            // when'den sonra da body'i eklememiz gerekir
            // ama bu bi get request oldugu icin su an buna gerek yok

       // 4- assertion (hard assert yapiyoruz, ama sonraki class'larda soft assert yapacagiz)

             // response.prettyPrint();
       response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
               .body("data.id", hasSize(24),
                       "data.employee_name",hasItem("Ashton Cox"),
                       "data.employee_age",hasItems(61,21,35));

       /*donen Response'in
            status code'unun 200,
            ve content type'inin Aplication.JSON,
            ve response body'sindeki
            employees sayisinin 24
            ve employee'lerden birinin "Ashton Cox"
            ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test ediyoruz*/
   }
}
