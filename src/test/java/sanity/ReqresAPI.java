package sanity;

import extensions.Verification;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;
@Listeners(utilities.Listeners.class)
public class ReqresAPI extends CommonOps {
    @Test(description = "Get username from reqres")
    @Description("This test verify username property")
    public void test01_VerifyUsername(){
        Verification.verifyText(ApiFlows.getNameProperty("data[1].first_name"),"Janet");
        System.out.println(response.statusCode());

    }
    @Test(description = "Create new username at reqres")
    @Description("This test creates new username and verify it")
    public void test02_CreateUsername(){
        ApiFlows.postUsername("morpheus","leader");
        System.out.println(response.statusCode());
        Verification.verifyText(response.jsonPath().get("name").toString(),"morpheus");
    }
    @Test(description = "Update a username job at reqres")
    @Description("This test update a username job and verify it")
    public void test03_UpdateUsernameJob(){
        ApiFlows.updateUsername("morpheus","zion resident","2");
        System.out.println(response.statusCode());
        response.prettyPrint();
        Verification.verifyText(response.jsonPath().get("job").toString(),"zion resident");
    }
    @Test(description = "Delete username from reqres")
    @Description("This test delete username and verify it")
    public void test04_DeleteUsernameJob(){
        ApiFlows.deleteUsername("2");
        System.out.println(response.statusCode());
        Verification.verifyText(String.valueOf(response.statusCode()),"204");
    }
}
