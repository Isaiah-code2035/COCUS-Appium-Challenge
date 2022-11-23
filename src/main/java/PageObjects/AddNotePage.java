package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/*
/ The first page on launch of application that contains the add note button
 */
public class AddNotePage extends PageBase {

    /*
    /constructor for the class AddNotePage
     */
    public AddNotePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    /*
    / select the header element
     */
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.TextView")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Title'")
    WebElement header;

    /*
    / select the + sign to add note
     */
    @AndroidFindBy(id = "fab_add_notes")
    @iOSXCUITFindBy()
    WebElement addNoteBtn;

/*
/ method to verify the + sign clicks and redirect to the page to add note title and desc

 */
public void clickAddTaskBtn() {
        click(addNoteBtn);
    }

    /*
    / method to check if header exist
     */
    public void verifyHeader() {
        Assert.assertTrue(elementIsDisplayed(header));

    }
}
