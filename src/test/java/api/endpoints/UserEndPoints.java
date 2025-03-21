package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

//creted to perform CRUD operations
//create,read,update,delete
public class UserEndPoints {
    //post request
    public static Response createUser(User payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(Routes.post_url);
return response;
    }
    //get user
    public static Response getUser(String username) {
       Response response = given()
               .pathParam("username",username)

                .when()
                .get(Routes.get_url);
return response;
    }
    //put

    public static Response updateUser(String username, User payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("username",username)

                .when()
                .put(Routes.put_url);
        return response;
    }
    //delete
    public static Response deleteUser(String username) {
        Response response = given()
                .pathParam("username",username)

                .when()
                .get(Routes.delete_url);
        return response;
    }

}
