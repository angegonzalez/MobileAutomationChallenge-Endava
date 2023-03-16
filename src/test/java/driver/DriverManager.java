package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.plugin.event.Node;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.log4testng.Logger;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverManager {
    public static Logger logger = Logger.getLogger(DriverManager.class);
    public static AppiumDriver driver;
    public static Properties properties;

    public static void configureDriver() {
        properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/config.properties"));
        } catch (FileNotFoundException e) {
            logger.error("Properties file was not found!");
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.error("Error while opening properties file!");
            throw new RuntimeException(e);
        }
        File app = new File(properties.getProperty("APP_PATH"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("DEVICE_NAME"));
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, properties.getProperty("AUTOMATION_NAME"));

        URL localhost;

        try {
            localhost = new URL(properties.getProperty("APPIUM_HOST"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver = new AndroidDriver(localhost, capabilities);
    }
    public static AppiumDriver getDriver() {
        return driver;
    }
}
