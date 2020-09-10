package views.activitys;

import com.google.gson.internal.$Gson$Preconditions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import objects.Task;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import views.BaseView;
import views.popups.AddTaskPopup;

import java.util.List;

public class MainActivity extends BaseView {

    AddTaskPopup addTaskPopup;

    private final String ADD_BUTTON_XPATH = "//*[@id='add']";
    private final String ACTIVE_TASK_TAB_XPATH = "//*[@id='tabs']//*[text()='ACTIVE TASKS']";
    private final String COMPLETED_TASK_TAB_XPATH = "//*[@id='tabs']//*[text()='COMPLETED TASKS']";
    private final String TASK_ROW_XPATH = "//*[@id='item_task_title']";
    private final String COMPLETE_TASK_OPTION = "//*[@id='task_options_complete']";
    private final String DELETE_TASK_OPTION = "//*[@id='task_options_delete']";

    @AndroidFindBy(xpath = ADD_BUTTON_XPATH)
    public MobileElement addButton;

    @AndroidFindBy(xpath = ACTIVE_TASK_TAB_XPATH)
    public MobileElement taskTab;

    @AndroidFindBy(xpath = COMPLETED_TASK_TAB_XPATH)
    public MobileElement completedTab;

    @AndroidFindBy(xpath = TASK_ROW_XPATH)
    public List<MobileElement> taskList;

    @AndroidFindBy(xpath = COMPLETE_TASK_OPTION)
    public MobileElement completeTaskOption;

    @AndroidFindBy(xpath = DELETE_TASK_OPTION)
    public MobileElement deleteTaskOption;

    public MainActivity(AndroidDriver<AndroidElement> drv) {
        super(drv);
        PageFactory.initElements(new AppiumFieldDecorator(drv), this);
        addTaskPopup = new AddTaskPopup(drv);
    }

    public void creteTask(Task task){
        openCreateTaskPopup();
        Assert.assertTrue(addTaskPopup.isAddTask(), "opened popup is not AddTask popup");
        addTaskPopup.createTask(task);
    }

    public void openCreateTaskPopup(){
        addButton.click();
    }

    public int getTaskCount(){
        return taskList.size();
    }

    public MobileElement getTask(Task task){
        MobileElement result = null;
        if(getTaskCount() > 0){
            for(MobileElement elem: taskList){
                if(elem.getText().equals(task.title))
                    result = elem;
            }
        }
        return result;
    }

    public void completeTask(Task task, SoftAssert softAssert){
        MobileElement taskRow = getTask(task);
        if(taskRow != null){
            taskRow.click();
            completeTaskOption.click();
        }else{
            softAssert.fail("Task row '" + task.title + "' is not exist");
        }
    }

    public void deleteTask(Task task, SoftAssert softAssert){
        MobileElement taskRow = getTask(task);
        if(taskRow != null){
            taskRow.click();
            deleteTaskOption.click();
        }else{
            softAssert.fail("Task row '" + task.title + "' is not exist");
        }
    }

    public void switchToCompletedTab(){
        completedTab.click();
    }

    public void switchToTaskTab(){
        taskTab.click();
    }


}
