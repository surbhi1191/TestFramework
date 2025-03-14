package api.test;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreTests {
  //  Faker faker;
    Store storePayload;

    @BeforeClass
            void Setup()
    {
       // faker = new Faker();
        storePayload = new Store();
        storePayload.setId(1);
        storePayload.setPetId(1);
        storePayload.setQuantity(2);
        storePayload.setShipDate("2025-03-06T11:05:49.228Z");
        storePayload.setStatus("placed");
        storePayload.setComplete("True");
    }




    @Test
    void postStoreTest()
    {
        Response res = StoreEndPoints.putStore(storePayload);
        res.then().log().all();
       Assert.assertEquals(res.getStatusCode(),200);
    }
}
