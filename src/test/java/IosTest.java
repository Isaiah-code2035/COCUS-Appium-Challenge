import PageObjects.AddNotePage;
import PageObjects.CreateNotesPage;
import PageObjects.NotesPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;


public class IosTest extends TestBase {

    public IosTest() {
        super();
    }
    CreateNotesPage createNotesPage;
    AddNotePage titleListPage;

    NotesPage notesPage;
    ExtentTest test;


    @BeforeTest
    public void setup() throws MalformedURLException {
        test = extent.createTest("Android Setup");
        test.log(Status.PASS,"The android application setup should be successful");
        iosSetup();
        titleListPage = new AddNotePage(driver);
        createNotesPage = new CreateNotesPage(driver);
        notesPage = new NotesPage(driver);

    }

    @Test(priority = 1)
    public void headerVerify() {
        ExtentTest test = extent.createTest("Verify the application is opened");
        test.log(Status.PASS, "A test to verify the application is opened through the header");
        titleListPage.verifyHeader();

    }

    @Test(priority = 2)
    public void addTask() {
        test = extent.createTest("Click on the add note button");
        test.log(Status.PASS,"The add note button should be clickable and redirect to enter note page");
        titleListPage.clickAddTaskBtn();

    }

    @DataProvider(name = "results")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJSONdata
                (System.getProperty("user.dir") + "/data/testData.json"
                        , "results", 2);
    }

    @Test(priority = 3, dataProvider = "results")
    public void createTitle(String title, String Desc) throws InterruptedException {
        test = extent.createTest("Add note title and Description");
        test.log(Status.PASS,"This test adds notes title and Description and save the note to redirect to the note page");
        createNotesPage.enterNotesName(title);
        createNotesPage.enterNoteDesc(Desc);
        createNotesPage.clickSaveBtn();
        Thread.sleep(5000);
    }

    @Test(priority =4)
    public void textBoxVerify () {
        test = extent.createTest("Verify the text box that saves the notes exist");
        test.log(Status.PASS,"The test verifies that the text box exists");
        Assert.assertTrue(notesPage.verifyTextBox());
    }

    @Test(priority = 5)
    public void textBoxClick () {
        test = extent.createTest("Check the text box that saves note is clickable");
        test.log(Status.PASS,"The test should click on the text box of the saved note and redirect to another page with the note details and icon");
        notesPage.clickTextBox();
    }

    @Test(priority = 6)
    public void noteIconVerify () {
        test = extent.createTest("Check that the note icon is present");
        test.log(Status.PASS,"The test should show that he note icon is present to confirm it opens another page");
        notesPage.verifyNoteIcon();
    }

    @Test(priority =7)
    public void backBtnClick() {
        test = extent.createTest("Click on the back button");
        test.log(Status.PASS,"The test should verify that the back button is clickable and returns to the previous page");
        notesPage.clickBackBtn();
    }

    @Test(priority = 8)
    public void hamBurgerVerify() {
        test = extent.createTest("Check the hamburger button exist");
        test.log(Status.PASS,"The test verify that the hamburger exist on the page");
        notesPage.verifyHamburger();
    }

    @Test(priority = 9)
    public void hamBurgerClick() {
        test = extent.createTest("Click on the hamburger button");
        test.log(Status.PASS,"The test should indicate that the hamburger is clickable and redirects to the sidebar");
        notesPage.clickHamBurger();
    }

    @Test(priority = 10)
    public void menuIconVerify() {
        test = extent.createTest("Check menu icon on side bar exist");
        test.log(Status.PASS,"The test should verify that he menu icon on the sidebar of the application shows");
        notesPage.verifyMenuIcon();
    }

    @Test(priority = 11)
    public void closeDriver(){
        test = extent.createTest("Close the mobile device");
        test.log(Status.PASS,"The test should verify that the mobile device is closed");
        tearDown();

    }

}
