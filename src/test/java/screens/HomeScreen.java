package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomeScreen extends BaseScreen {
    By btnSearch = By.xpath("//android.widget.FrameLayout[@content-desc='Search']");
    By btnVideo = By.xpath("//android.widget.FrameLayout[@content-desc='Video']");
    By btnLogin = By.id("com.imdb.mobile:id/imdb_auth_portal");

    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }

    public SearchScreen clickSearch() {
        waitForElementPresence(btnSearch);
        mapToElement(btnSearch).click();
        return new SearchScreen(driver);
    }
    public VideoScreen clickVideo(){
        waitForElementPresence(btnVideo);
        mapToElement(btnVideo).click();
        return new VideoScreen(driver);
    }

    public HomeScreen signIn(){
        waitForElementPresence(btnLogin);
        mapToElement(btnLogin).click();
        SignInScreen signInScreen = new SignInScreen(driver);
        signInScreen.signInWithCredentials();
        return this;
    }
}
