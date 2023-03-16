package common;

import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void before() {
        DriverManager.configureDriver();
    }
    @After(order = 0)
    public void quitBrowser(){
        DriverManager.getDriver().quit();
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
