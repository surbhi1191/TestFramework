package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

//creted to perform CRUD operations
//create,read,update,delete
public class UserEndPoints2 {
   // method to get urls from properties file
   static ResourceBundle getUrl()
   {
       ResourceBundle routes =ResourceBundle.getBundle("routes"); //load properties file
       return routes;
   }


    //post request
    public static Response createUser(User payload) {
       String post_url = getUrl().getString("post_url");
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(post_url);
return response;
    }
    //get user
    public static Response getUser(String username) {
        String get_url = getUrl().getString("get_url");

       Response response = given()
               .pathParam("username",username)

                .when()
                .get(get_url);
return response;
    }
    //put

    public static Response updateUser(String username, User payload) {
        String put_url = getUrl().getString("put_url");
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("username",username)

                .when()
                .put(put_url);
        return response;
    }
    //delete
    public static Response deleteUser(String username) {
        String delete_url= getUrl().getString("delete_url");
        Response response = given()
                .pathParam("username",username)

                .when()
                .get(delete_url);
        return response;
    }

}
