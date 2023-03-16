package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MainScreen extends BaseScreen {

    private final By btnSkip = By.id("com.imdb.mobile:id/splash_not_now");

    public MainScreen(AppiumDriver driver) {
        super(driver);
    }

    public HomeScreen skipLogin() {
        waitForElementPresence(btnSkip);
        mapToElement(btnSkip).click();
        return new HomeScreen(driver);
    }
}
