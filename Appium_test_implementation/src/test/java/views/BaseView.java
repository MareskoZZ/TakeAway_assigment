package views;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseView {

    public static final int DEFAULT_TIMEOUT = 30;
    public AndroidDriver<AndroidElement> drv;
    public static WebDriverWait wait;

    public BaseView(AndroidDriver<AndroidElement> driver) {
        this.drv = driver;
        wait = new WebDriverWait(driver,DEFAULT_TIMEOUT);
    }
}
