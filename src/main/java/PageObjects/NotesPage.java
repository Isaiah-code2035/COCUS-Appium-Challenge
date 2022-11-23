package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

/*
/ the class that contains the notepage after the note has been created
 */
public class NotesPage extends PageBase {

    // get the textBox that save the note
    @AndroidFindBy(className = "android.widget.FrameLayout")
    @iOSXCUITFindBy()
    WebElement textBox;


    //the note icon
    @AndroidFindBy(id = "com.example.android.testing.notes.mock:id/note_detail_image")
    @iOSXCUITFindBy()
    WebElement noteIcon;


    //back button
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    @iOSXCUITFindBy()
    WebElement backBtn;

    //hamburger element
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    @iOSXCUITFindBy()
    WebElement hamBurger;

    //menu icon element
    @AndroidFindBy(className = "android.widget.ImageView")
    @iOSXCUITFindBy()
    WebElement menuIcon;


    public NotesPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    /*
    /methods for actions to be performed on this notepage
     */

    //verify that he textBox exist
    public boolean verifyTextBox() {
        return textBox.isDisplayed();
    }

    //verify that the text box is clickable
    public void clickTextBox() {
        click(textBox);
    }

    //verify the note icon is present
    public boolean verifyNoteIcon() {
        return noteIcon.isDisplayed();
    }


    //click the back btn
    public void clickBackBtn() {
        click(backBtn);

    }

    //verify the hamburger is present
    public boolean verifyHamburger() {
        return hamBurger.isDisplayed();
    }


    //click the hamburger
    public void clickHamBurger() {
        click(hamBurger);
    }


    //verify the menuIcon
    public boolean verifyMenuIcon() {
        return menuIcon.isDisplayed();
    }

}


