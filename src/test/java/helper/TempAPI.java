package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TempAPI {
    RequestSpecification httpRequest;
    Response response;
    String url = "https://reqres.in/";

    @Test
    public void test() {
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
//        Get Request
       response = httpRequest.get("/api/users");

//        Post Request
        JSONObject params = new JSONObject();
//        params.put("name","morpheus");
//        params.put("job","leader");
//        httpRequest.header("Content-type", "application/JSON");
//        httpRequest.body(params.toJSONString());
//        response = httpRequest.post("api/users");
//        params.put("name","morpheus");
//        params.put("job","zion resident");
//        response = httpRequest.put("api/users/2");
//        response = httpRequest.delete("api/users/2");
        System.out.println(response.statusCode());


        response.prettyPrint();
    }
}
