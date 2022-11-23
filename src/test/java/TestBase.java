import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/*
/ This is the class for the testbase which contains the android setup method and ios setup method and extend the test report class as well as the tear down method
 */
public class TestBase extends TestReport {
    public static AppiumDriver driver;

    //setup androidDesiredCapabilities
    public static void androidSetup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("app", System.getProperty("user.dir") + "/app/app-mock-debug.apk");
        caps.setCapability("avd", "Pixel_XL_API_33");
        caps.setCapability("avdLaunchTimeout", 180000);


        driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
    }

    
    //setup ios desired capabilities
    public static void iosSetup() throws MalformedURLException{

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformVersion", "15.5");
        caps.setCapability("deviceName", "iphone 13");
        caps.setCapability("udid", "");
        caps.setCapability("xcodeOrgId", "Isaiah's Iphone");
        caps.setCapability("xcodeSigningId", "iphone Developer");
        caps.setCapability("simulatorStartupTimeout", 180000);
        caps.setCapability("app", System.getProperty("user.dir")+"/app/");
        driver = new AppiumDriver (new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);

    }

    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }

    }
}
