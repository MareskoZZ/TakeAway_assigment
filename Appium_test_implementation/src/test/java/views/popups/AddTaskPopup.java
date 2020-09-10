package views.popups;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import objects.Task;
import org.openqa.selenium.support.PageFactory;
import views.BaseView;
import views.elements.Input;

public class AddTaskPopup extends BaseView {


    private final String ADD_TASK_INPUT_XPATH = "//*[@id='add_task']";
    private final String TITLE_FIELD_XPATH = "//*[@id='alertTitle']";
    private final String TEXT_FIELD_XPATH = "//*[@id='message']";
    private final String ADD_BUTTON_XPATH = "//*[@id='button1']";
    private final String CANCEL_BUTTON_XPATH = "//*[@id='button2']";


    @AndroidFindBy(xpath = ADD_TASK_INPUT_XPATH)
    public MobileElement addTaskInput;

    @AndroidFindBy(xpath = TITLE_FIELD_XPATH)
    public MobileElement titleField;

    @AndroidFindBy(xpath = TEXT_FIELD_XPATH)
    public MobileElement textField;

    @AndroidFindBy(xpath = ADD_BUTTON_XPATH)
    public MobileElement addButton;

    @AndroidFindBy(xpath = CANCEL_BUTTON_XPATH)
    public MobileElement cancelButton;

    public AddTaskPopup(AndroidDriver<AndroidElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(drv), this);
    }

    public Boolean isAddTask(){
        if(titleField.getText().equals("Add task"))
            if(textField.getText().equals("Add a new task to your list"))
                return true;
        return false;
    }

    public void createTask(Task task){
        Input title = new Input(drv, addTaskInput);
        title.setValue(task.title);
        addButton.click();
    }
}
