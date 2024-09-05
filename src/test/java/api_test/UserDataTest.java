package api_test;

import api_endpoints.UserEndPoints;
import api_payload.User;
import api_testdata.UserData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserDataTest {

    @Test(priority = 1,dataProvider = "userData",dataProviderClass = UserData.class)
    public void testPostUserByData(String userID,String userName,String fname,String lname,String usermail,String pwd,String mobileno)
    {
        User payload = new User() {{
            setId(Integer.parseInt(userID));
            setUsername(userName);
            setFirstName(fname);
            setLastName(lname);
            setEmail(usermail);
            setPassword(pwd);
            setPhone(mobileno);
        }};

        Response response = UserEndPoints.createUser(payload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 2,dataProvider = "userNames",dataProviderClass = UserData.class)
    public void testDeleteByData(String userName)
    {
        Response response = UserEndPoints.deleteUser(userName);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
