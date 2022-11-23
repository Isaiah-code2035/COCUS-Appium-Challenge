package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
/ this is the base page class that contains reusable methods in other pages.
 */
public class PageBase {
    AppiumDriver driver;

    //wait method
    public static final Duration WAIT = Duration.ofMillis(1000);

    public PageBase(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        driver = appiumDriver;
    }

    // method to wait for element visibility
    public void waitForVisibility(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // clear text in element method
    public void clear(WebElement element) {
        waitForVisibility(element);
        element.clear();
    }

    //click method
    public void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    //send text method
    public void sendText(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    //method to check if element is displayed
    public boolean elementIsDisplayed(WebElement element) {

        waitForVisibility(element);
        return element.isDisplayed();


    }


}
