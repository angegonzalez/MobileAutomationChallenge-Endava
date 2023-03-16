package common;

import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void before() {
        DriverManager.configureDriver();
    }
    @After(order = 0)
    public void quitBrowser() {
        DriverManager.getDriver().quit();
    }
    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = DriverManager.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot...");
        }
    }

//    @After(order = 1)
//    public void tearDown(Scenario scenario) {
//        if (scenario.isFailed()) {
//            Date now = new Date();
//            String timestamp = now.toString();
//            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            try {
//                FileUtils.copyFile(srcFile,
//                        new File("./src/test/resources/screenshots/" + scenario.getName() + " [" + timestamp + "].png"));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
}
