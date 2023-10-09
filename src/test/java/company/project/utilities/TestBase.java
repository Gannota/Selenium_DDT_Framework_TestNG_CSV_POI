package company.project.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Base64;

public class TestBase {

    @AfterMethod
    public void tearDown(ITestResult test) {

        if (test.getStatus()==ITestResult.FAILURE) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            org.testng.Reporter.log("Capturing screenshot for: ", true);
            org.testng.Reporter.log("<img src='data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot) + "' />", true);
        }
        //System.out.println("This is how @After annotation is working, after each scenario");
        Driver.closeDriver();
    }
    @BeforeMethod
    public void setUp(){

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

}
