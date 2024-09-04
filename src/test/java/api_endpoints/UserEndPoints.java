package api_endpoints;

import api_payload.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//created to perform Create,update,read,delete requests to the user API
public class UserEndPoints {

   public static Response createUser(User payload){
       Response response = RestAssured
               .given()
               .contentType(ContentType.JSON)
               .body(payload)
               .when()
               .post(Routes.post_url);
       return response;
    }

    public static Response readUser(String userName){

        Response response = RestAssured
                .given()
                .pathParam("username", userName)
                .when()
                .get(Routes.get_url);
        return response;
    }

    public static Response updateUser(String username,User payload){
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .body(payload)
                .when()
                .put(Routes.update_url);
        return response;
    }

    public static Response deleteUser(String userName){
        Response response = RestAssured
                .given()
                .pathParam("username",userName)
                .when()
                .delete(Routes.delete_url);

        return response;
    }


}
