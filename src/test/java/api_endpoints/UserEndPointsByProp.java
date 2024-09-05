package api_endpoints;

import api_payload.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

//created to perform Create,update,read,delete requests to the user API
public class UserEndPointsByProp {

    //Getting the Urls from the Properties file
    static ResourceBundle getURL(){
        ResourceBundle routes=ResourceBundle.getBundle("routes"); //Load the properties
        return routes;
    }

   public static Response createUser(User payload){
       String post_url = getURL().getString("post_url");
       Response response = RestAssured
               .given()
               .contentType(ContentType.JSON)
               .body(payload)
               .when()
               .post(post_url);
       return response;
    }

    public static Response readUser(String userName){

        String get_url = getURL().getString("get_url");
        Response response = RestAssured
                .given()
                .pathParam("username", userName)
                .when()
                .get(get_url);
        return response;
    }

    public static Response updateUser(String username,User payload){

        String update_url = getURL().getString("update_url");
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .body(payload)
                .when()
                .put(update_url);
        return response;
    }

    public static Response deleteUser(String userName){

        String delete_url = getURL().getString("delete_url");
        Response response = RestAssured
                .given()
                .pathParam("username",userName)
                .when()
                .delete(delete_url);

        return response;
    }


}
