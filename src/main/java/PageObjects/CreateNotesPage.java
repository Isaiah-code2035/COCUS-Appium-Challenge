package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

/*
/ This is a class that creates the notes adding the title and description and get it saved
 */

public class CreateNotesPage extends PageBase {

    //class constructor
    public CreateNotesPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

/*
/   Select the element for adding note title
 */
    @AndroidFindBy(id = "add_note_title")
    @iOSXCUITFindBy()
    WebElement noteNameTxt;


    /*
    /   Select the element for adding note description
     */
    @AndroidFindBy(id = "add_note_description")
    @iOSXCUITFindBy()
    WebElement noteDescTxt;


    /*
/   Select the element for the save button
 */
    @AndroidFindBy(id = "fab_add_notes")
    @iOSXCUITFindBy()
    WebElement saveBtn;


    /*
methods to create note with title and decription to return the next page
 */
   //method to enter the note name
    public void enterNotesName(String noteName) {
        clear(noteNameTxt);
        sendText(noteNameTxt, noteName);
    }

    //method to enter the note description
    public void enterNoteDesc(String descText) {
        clear(noteDescTxt);
        sendText(noteDescTxt, descText);
    }


    //method to save the notes
    public NotesPage clickSaveBtn() {
        click(saveBtn);
        return new NotesPage(driver);
    }





}
