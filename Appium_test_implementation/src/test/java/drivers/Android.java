package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class Android {

    public AndroidDriver<AndroidElement> driver;
    private DesiredCapabilities dc;
    static String baseDir = System.getProperty("user.dir");
    private String port;

    public Android(String udid, String port){
        dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.UDID, udid);
        this.port = port;
    }

    public AndroidDriver launch() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, "RF8N12EK7LK");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.justeat.androiduitechtest");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        Assert.assertNotNull(driver);
        return driver;
    }

    public void install() throws MalformedURLException {
        dc.setCapability("app",baseDir + "\\src\\apk\\app-debug.apk");
        driver = new AndroidDriver<>(new URL("http://localhost:"+ port +"/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
        Assert.assertNotNull(driver);
        driver.closeApp();
        driver.quit();
    }
}
