package api.test;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests2 {
    Faker faker;
    User userpayload;
    String payload;
    public Logger logger;

    @BeforeClass
    void setupData() throws JsonProcessingException {
        faker = new Faker();
        userpayload = new User();
        userpayload.setId(faker.idNumber().hashCode());
        userpayload.setUsername(faker.name().username());
        userpayload.setFirstName(faker.name().firstName());
        userpayload.setLastName(faker.name().lastName());
        userpayload.setEmail(faker.internet().safeEmailAddress());
        userpayload.setPassword(faker.internet().password(5, 10));
        userpayload.setPassword(faker.phoneNumber().cellPhone());
        //for logs
        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void testPostUser() {
        logger.info("********* creating user *******");
        Response response = UserEndPoints2.createUser(userpayload);
        response.then().log().body();
        System.out.println(response);
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("********* user created *******");
    }

    @Test(priority = 2)
    public void testGetUserByName() {
        logger.info("********* reading user *******");
        Response response = UserEndPoints2.getUser(this.userpayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("*********  user info displayed *******");
    }

    @Test(priority = 3)
    public void testUpdateUser() {
        logger.info("********* updating user *******");
        //update data using payload
        userpayload.setFirstName(faker.name().firstName());
        userpayload.setLastName(faker.name().lastName());
        userpayload.setEmail(faker.internet().safeEmailAddress());
        Response response = UserEndPoints.updateUser(this.userpayload.getUsername(), userpayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("*********  user updated *******");
        //checking data after update
        Response responseafterupdate = UserEndPoints2.getUser(this.userpayload.getUsername());
        Assert.assertEquals(responseafterupdate.getStatusCode(), 200);

    }

    @Test(priority = 4)
    public void testDeleteUserByName() {
        logger.info("********* deleting user *******");
        Response response = UserEndPoints2.deleteUser(this.userpayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("*********  user deleted *******");
    }

    @Test
    public void testGitThing() {
        System.out.println("hello git");
    }

}
