package api.endpoints;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StoreEndPoints {

    // perform CRUD operations


   public static Response putStore(Store storePayload)
   {
       Response response = given()
               .contentType(ContentType.JSON)
               .accept(ContentType.JSON)
               .body(storePayload)
               .when()
               .post(Routes.postStore_url);
       return response;

   }
    }

