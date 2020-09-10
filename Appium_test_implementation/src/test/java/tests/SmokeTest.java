package tests;

import objects.Task;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SmokeTest extends BaseTest{

    Task task1 = new Task("first test task");
    Task task2 = new Task("second test task");
    Task task3 = new Task("third test task");


    @Test(description = "create task - verify task")
    public void create_task_test() {
        SoftAssert softAssert = new SoftAssert();
        mainActivity.creteTask(task1);
        softAssert.assertNotNull(mainActivity.getTask(task1), "task '"+task1.title+"' wasn't found");
        softAssert.assertEquals(mainActivity.getTaskCount(), 1, "count of tasks is not equal 1");
        softAssert.assertAll();
    }

    @Test(description = "delete task - verify task was deleted")
    public void delete_task_test() {
        SoftAssert softAssert = new SoftAssert();
        mainActivity.creteTask(task1);
        mainActivity.deleteTask(task1, softAssert);
        softAssert.assertEquals(mainActivity.getTaskCount(), 0, "count of tasks more then 0");
        softAssert.assertAll();
    }

    @Test(description = "complete task - verify task was completed")
    public void complete_task_test() {
        SoftAssert softAssert = new SoftAssert();
        mainActivity.creteTask(task1);
        mainActivity.completeTask(task1, softAssert);
        softAssert.assertEquals(mainActivity.getTaskCount(), 0, "count of tasks more then 0");
        mainActivity.switchToCompletedTab();
        softAssert.assertNotNull(mainActivity.getTask(task1), "task '"+task1.title+"' wasn't found");
        softAssert.assertEquals(mainActivity.getTaskCount(), 1, "count of tasks is not equal 1");
        softAssert.assertAll();
    }

    //additional tests

    @Test(description = "create few row - complete and delete task in one session - verify all steps")
    public void several_tasks_advanced_test() {
        SoftAssert softAssert = new SoftAssert();
        mainActivity.creteTask(task1);
        mainActivity.creteTask(task2);
        mainActivity.creteTask(task3);
        softAssert.assertEquals(mainActivity.getTaskCount(), 3, "count of tasks more then 3");
        mainActivity.completeTask(task2, softAssert);
        mainActivity.completeTask(task3, softAssert);
        softAssert.assertEquals(mainActivity.getTaskCount(), 1, "count of tasks more then 2");
        mainActivity.switchToCompletedTab();
        softAssert.assertEquals(mainActivity.getTaskCount(), 2, "count of tasks is not equal 1");
        softAssert.assertNotNull(mainActivity.getTask(task2), "task '"+task2.title+"' wasn't found");
        softAssert.assertNotNull(mainActivity.getTask(task2), "task '"+task3.title+"' wasn't found");
        mainActivity.switchToTaskTab();
        softAssert.assertEquals(mainActivity.getTaskCount(), 1, "count of tasks more then 2");
        mainActivity.deleteTask(task1, softAssert);
        softAssert.assertEquals(mainActivity.getTaskCount(), 0, "count of tasks more then 0");
        mainActivity.switchToCompletedTab();
        softAssert.assertEquals(mainActivity.getTaskCount(), 2, "count of tasks is not equal 1");
        softAssert.assertAll();
    }


}
