import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestReport {
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;

@BeforeSuite
    public void reportSetUp() {
        htmlReporter   = new ExtentHtmlReporter("test-report.html");
        extent  = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }


@AfterSuite
    public void reportTearDown() {
        extent.flush();
    }


}
