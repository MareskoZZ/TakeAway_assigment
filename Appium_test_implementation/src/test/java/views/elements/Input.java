package views.elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import views.BaseView;

public class Input extends BaseView {

    private MobileElement elem;

    public Input(AndroidDriver<AndroidElement> driver, MobileElement elem) {
        super(driver);
        this.elem = elem;
    }

    public void setValue(String value){
        elem.sendKeys(value);
    }

    public void getValue(){
        //elem.
    }

}
