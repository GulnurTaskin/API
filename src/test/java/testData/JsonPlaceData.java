package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceData {
    public static int basariliSC=200;
    public static String contentType="application/json; charset=utf-8";
    public static  String header="keep-alive";

    public static JSONObject expectedDataOlustur22(){

        JSONObject expData=new JSONObject();
        expData.put("userId",3);
        expData.put("id",22);
        expData.put("title","dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita " +
                "earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expData;
        // normalde bu kismi test class'inda expected data olusturma adiminda hazirliyorduk
        // burda bunu bir method icine alarak formuluze ediyoruz
        // static method oldugu icin sonunda return yapiyoruz
        // bu data sekli tek bir id icin gecerlidir, yani farkli id'ler icin farkli data'lar hazirlamak gerekir
        // bunun icin asagida expected data'yi dinamik hale getiren yeni bir method olacak
    }

    // data'yi dinamik hale getirmek icin asagidaki methodumuzu hazirliyoruz
    // C20 ve C21 class'larinda bu methodu kullandik ornek olarak
    // ama artik dinamik oldugu icin istedigimiz her yerde bu methodu kullanabiliriz
    public static JSONObject JSonDataOlustur(int userId, int id, String title, String body){
        JSONObject expData=new JSONObject();
        expData.put("userId",userId);
        expData.put("id",id);
        expData.put("title",title);
        expData.put("body",body);

        return expData;

    }


        /*
        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }
         */



    /* Java objelerini API sorgulari yapmak uzere Json objesine cevirmeye Serialization denir.
       Verilen Json objesini testlerimizde kullanmak uzere Java objesine cevirmeye ise DeSerialization denir.

       Asagida java objesi olarak donen bir body methodu yazdik
       Bu methodu C24'de kullandik   */

    public static Map<String,Object> bodyOlustur(){
        // elmas ici ilk her zaman string olmali, ikici ise farkli datalardan olabilir, o yuzden object dedik

        /* JSONObject key-value ikililerini kullandigi icin De-Serialization islemi icin
        Java’dan kullanacagimiz en uygun data turu Map’tir. */

        Map<String,Object> bodyMap=new HashMap<>();

        bodyMap.put("title","Ahmet");
        bodyMap.put("body","Merhaba");
        bodyMap.put("userId",10.0);
        bodyMap.put("id",70.0);

        return bodyMap;
    }


}