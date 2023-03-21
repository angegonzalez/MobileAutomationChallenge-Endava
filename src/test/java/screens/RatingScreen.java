package screens;

import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class RatingScreen extends BaseScreen {

    By stars = By.xpath("//android.widget.FrameLayout" +
            "[@resource-id=\"com.imdb.mobile:id/star_row\"]/" +
            "android.widget.LinearLayout/android.widget.ImageView");
    By btnRate = By.id("com.imdb.mobile:id/rate_title_button");

    public RatingScreen(AppiumDriver driver) {
        super(driver);
    }

    public MovieScreen rateMovie(){
        waitForElementPresence(stars);
        List<WebElement> webElement = mapToElements(stars);
        Random random = new Random();
        int selectedIndex = random.ints(1, 6).findFirst().getAsInt();
        tapElement(webElement.get(selectedIndex));
        waitForElementPresence(btnRate);
        tapElement(mapToElement(btnRate));
        return new MovieScreen(driver);
    }
}
