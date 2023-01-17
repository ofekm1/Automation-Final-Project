package sanity;

import extensions.Verification;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)

public class TodoElectron extends CommonOps {
    @Test(description = "Test01 - add and verify new task")
    @Description("This test adds and verify new task to the list")
    public void test01_addAndVerifyNewTask() {
        ElectronFlows.newTask("Learn java");
        Verification.verifyNumber(ElectronFlows.getTasksNumber(), 1);
    }
//    @Test(description = "Test01 - add and verify new task")
//    @Description("This test adds and verify new task to the list")
//    public void test01_addAndVerifyNewTasks() {
//        ElectronFlows.newTask("Learn java");
//        ElectronFlows.newTask("Learn java");
//        ElectronFlows.newTask("Learn java");
//        Verification.verifyNumber(ElectronFlows.getTasksNumber(),22);
//    }
}
