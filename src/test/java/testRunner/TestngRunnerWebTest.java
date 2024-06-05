package testRunner;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import factory.BaseClass;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ServerManager;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@CucumberOptions(
        plugin= {"pretty", "html:reports/myreport29.html",
//                "rerun:target/rerun.txt",
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        features = {"src/test/resources"},
        glue="stepDefinitions",

//        dryRun=false,    // checks mapping between scenario steps and step definition methods
//        monochrome=true,    // to avoid junk characters in output
//        publish=true,   // to publish report in cucumber server
//        strict = true,
        tags= "@WebApp"  // this will execute scenarios tagged with @sanity)
)

public class TestngRunnerWebTest {
    private String scenarioName;
    private TestNGCucumberRunner testNGCucumberRunner;
    BaseClass baseClass = BaseClass.getInstance();
    ServerManager serverManager = ServerManager.getInstance();

    @Parameters({"deviceName","udid","platformVersion","platformName","browserName","automationName"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(String deviceName, String udid, String platformVersion, String platformName, String browserName, String automationName) throws Exception {
        serverManager.startServer();
        baseClass.initializeWebDriver(deviceName, udid, platformVersion, platformName, browserName, automationName);
        System.out.println(serverManager.getServer().getUrl());

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber scenarios", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature) throws Throwable {
        scenarioName = pickleEvent.getPickle().getName().replaceAll("/", "");
        testNGCucumberRunner.runScenario(pickleEvent.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
            System.out.println(serverManager.getServer().getUrl() + " if it is null, the server is offed");
        }

        testNGCucumberRunner.finish();
    }

//    @AfterMethod
//    public void AddScreenshot(ITestResult result) throws IOException {
//        String imagePath = "screenshots" + File.separator + scenarioName + ".png";
//        String completeImagePath = System.getProperty("user.dir") + File.separator + "target" + File.separator + imagePath;
//        if (!(baseClass.getDriver() == null)) {
//            if (result.getStatus() == ITestResult.FAILURE) {
//                File sourcePath = ((TakesScreenshot) baseClass.getDriver()).getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(sourcePath, new File(completeImagePath));
//                byte[] encoded = null;
//                try {
//                    encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(sourcePath));
//                } catch (IOException e1) {
//                    // TODO Auto-generated catch block
//                    e1.printStackTrace();
//                }
//                ExtentCucumberAdapter.getCurrentStep().fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromBase64String((new String(encoded, StandardCharsets.US_ASCII)), "Failed image").build());
//            }
////            baseClass.getDriver().quit();
//        } else {
//            Assert.fail("Driver is not initialized. Could be error from server-side");
//        }
//    }

//    @AfterMethod(alwaysRun=true)
//    public void catchExceptions(ITestResult result) throws IOException {
////        Calendar calendar = Calendar.getInstance();
////        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
////        String methodName = result.getName();
//        if (baseClass.getDriver() != null) {
//            if(result.getStatus() == ITestResult.FAILURE){
//                File scrFile = ((TakesScreenshot) baseClass.getDriver()).getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + File.separator + "reports" + File.separator + scenarioName + ".png"));
//            }
//        }
//
//    }

}
