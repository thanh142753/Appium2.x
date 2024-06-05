//package stepDefinitions;
//
//import java.io.IOException;
//import java.sql.DriverManager;
//import java.util.Properties;
//
//import factory.BaseClass;
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Scenario;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//import io.cucumber.java.Before;
//import utilities.ServerManager;
//
//
//public class Hooks {
//
//	 Properties p;
//     BaseClass baseClass = BaseClass.getInstance();
//     ServerManager serverManager = ServerManager.getInstance();
//
//	@Before
//    public void setup()
//    {
//        serverManager.startServer();
//        baseClass.initializeDriver("Pixel 3a API 28","emulator-5556", "9", "Android", "com.swaglabsmobileapp", "com.swaglabsmobileapp.SplashActivity", "UiAutomator2");
////        System.out.println(serverManager.getServer().getUrl());
////    	p=BaseClass.getProperties();
////        System.out.println("Alo + " + p.getProperty("screenshot.dir"));
//	}
//
//
//    @After
//    public void tearDown() {
//
//        if(serverManager.getServer() != null){
//            System.out.println("stop server");
//            serverManager.getServer().stop();
//        }
//
//    }
//
//
//    @AfterStep
//    public void addScreenshot(Scenario scenario) {
//
//    	// this is for cucumber junit report
//        if(scenario.isFailed()) {
//
//        	TakesScreenshot ts=(TakesScreenshot) baseClass.getDriver();
//        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
//
////        	scenario.attach(screenshot, "image/png",scenario.getName());
//
//        }
//
//    }
//
//}
