package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProvidersTests {

    @Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)
    public void testPostUser(String UserID,String username,String firstname,String lastname,String email,String pwd,String phno)
    {
        User userpayload = new User();
        userpayload.setId(Integer.parseInt(UserID));
        userpayload.setUsername(username);
        userpayload.setFirstName(firstname);
        userpayload.setLastName(lastname);
        userpayload.setEmail(email);
        userpayload.setPassword(pwd);
        userpayload.setPhone(phno);
        Response response = UserEndPoints.createUser(userpayload);
        response.then().log().body();
        System.out.println(response);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 2,dataProvider = "Usernames",dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String username) {
        Response response = UserEndPoints.deleteUser(username);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
