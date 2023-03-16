package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProfileScreen extends BaseScreen{
    By films = By.xpath("//android.widget.TextView[@resource-id=\"com.imdb.mobile:id/main_line\"]");
    public ProfileScreen(AppiumDriver driver) {
        super(driver);
    }

    public String getMovieInWatchListTitle(){
        waitForElementPresence(films);
        return mapToElements(films).get(0).getText();
    }
}
