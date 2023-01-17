package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {
    @Step("Add new task to tasks list")
    public static void newTask(String taskName) {
        UIActions.updateText(todoMain.txtCreate, taskName);
        UIActions.insertKey(todoMain.txtCreate, Keys.RETURN);
    }

    @Step("Count and return tasks number")
    public static int getTasksNumber() {
        return todoMain.listTasks.size();
    }

    @Step("Clear all tasks on list")
    public static void clearList() {
        for (int i = 0; i < getTasksNumber(); i++)
            UIActions.mouseHover(todoMain.btnDelete);
    }
}
