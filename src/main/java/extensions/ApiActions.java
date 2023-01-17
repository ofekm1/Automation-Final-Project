package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;


public class ApiActions extends CommonOps {
    @Step("Get data from server")
    public static Response get(String paramValues) {
        response = httpRequest.get(paramValues);
        return response;
    }

    @Step("Post data to server")
    public static void post(JSONObject params, String resource) {
        httpRequest.header("Content-type", "application/JSON");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
    }

    @Step("Update data on server")
    public static void put(JSONObject params, String resource) {
        httpRequest.header("Content-type", "application/JSON");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
    }

    @Step("Delete data on server")
    public static void delete(String id) {
        response = httpRequest.delete("api/users" + id);
    }

    @Step("Extract value from JSON")
    public static String extractFromJSON(Response response, String path) {
        jsonPath = response.jsonPath();
        return jsonPath.get(path).toString();
    }

}