package screens;

import common.Global;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

public class MovieScreen extends BaseScreen{

    By txtMovie = By.id("com.imdb.mobile:id/title");
    By txtAddWatchList= By.id("com.imdb.mobile:id/state_off");
    By btnProfile = By.xpath("//android.widget.FrameLayout[@content-desc='You']");
    By btnRate = By.id("com.imdb.mobile:id/empty_rating_star");
    By txtSavedMessage = By.xpath("//android.widget.TextView[@resource-id=\"com.imdb.mobile:id/title\"]");


    public MovieScreen(AppiumDriver driver) {
        super(driver);
    }

    public String getMovieTitle(){
        return mapToElement(txtMovie).getText();
    }
    public MovieScreen addToWatchList(){
        waitForElementPresence(txtAddWatchList);
        tapElement(mapToElement(txtAddWatchList));
        return this;
    }
    public ProfileScreen goToProfile(){
        waitForElementPresence(btnProfile);
        mapToElement(btnProfile).click();
        return new ProfileScreen(driver);
    }

    public RatingScreen goToReviewSection(){
        scrollIntoView(Global.USER_REVIEW_TITLE);
        waitForElementPresence(btnRate);
        tapElement(mapToElement(btnRate));
        return new RatingScreen(driver);
    }

    public String getSavedMessage(){
        waitForElementPresence(txtSavedMessage);
        return mapToElement(txtSavedMessage).getText();
    }

}
