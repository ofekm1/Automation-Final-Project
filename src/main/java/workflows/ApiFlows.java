package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utilities.CommonOps;


public class ApiFlows extends CommonOps {
    @Step("Business flow: get name property")
    public static String getNameProperty(String jPath) {
        response = ApiActions.get("api/users");
        return ApiActions.extractFromJSON(response, jPath);
    }

    @Step("Business flow: create new username")
    public static void postUsername(String name, String job) {
        params.put("name", name);
        params.put("job", job);
        ApiActions.post(params, "api/users");
    }

    @Step("Business flow: update username job")
    public static void updateUsername(String name, String job, String id) {
        params.put("name", name);
        params.put("job", job);
        ApiActions.put(params, "api/users/" + id);
    }

    @Step("Business flow: delete username on reqres")
    public static void deleteUsername(String id) {
        ApiActions.delete(id);
    }
}