package tests;

import drivers.Android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.*;
import views.activitys.MainActivity;

import java.net.MalformedURLException;

public class BaseTest {

    public AndroidDriver<AndroidElement> drv;
    MainActivity mainActivity;

    private boolean isFirst = true;

    @Parameters({"udid","port"})
    @BeforeTest
    public void installApp(String udid, String port) throws MalformedURLException {
        Android android = new Android(udid, port);
        android.install();
    }

    @Parameters({"udid","port"})
    @BeforeClass
    public void beforeAll(String udid, String port) throws MalformedURLException {
        Android android = new Android(udid, port);
        drv = android.launch();
        mainActivity = new MainActivity(drv);
    }

    @BeforeMethod
    public void beforeEach(){
        if (isFirst)
            isFirst = false;
        else
            drv.launchApp();
    }

    @AfterMethod
    public void afterEach(){
        drv.closeApp();
    }

}
