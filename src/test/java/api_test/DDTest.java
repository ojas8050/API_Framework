package api_test;

import api_endpoints.UserEndPoints;
import api_payload.User;
import api_utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
public class DDTest {
    @Test(dataProvider = "Data",dataProviderClass = DataProviders.class,priority = 1)
    public void testPostUser(String userID,String userName,String fname,String lname,String usermail,String pwd,String ph)
    {
        User userpayload=new User();
        userpayload.setId(Integer.parseInt(userID));
        userpayload.setUsername(userName);
        userpayload.setFirstName(fname);
        userpayload.setLastName(lname);
        userpayload.setEmail(usermail);
        userpayload.setPhone(ph);
        userpayload.setPassword(pwd);

        Response response = UserEndPoints.createUser(userpayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
    public void DeleteUserByName(String Username){
        Response response = UserEndPoints.deleteUser(Username);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
