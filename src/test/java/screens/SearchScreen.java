package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.nativekey.AndroidKey;

import java.util.List;
import java.util.Random;

public class SearchScreen extends BaseScreen {
    By txtSearch = By.className("android.widget.AutoCompleteTextView");
    By lstSearch = By.xpath("//android.widget.LinearLayout[@resource-id=\"com.imdb.mobile:id/holder\"]");
    By lstNames = By.xpath("//android.widget.TextView[@resource-id=\"com.imdb.mobile:id/suggestion\"]");
    By txtTopMovies = By.xpath("//android.widget.TextView[@text=\"Top 250 movies\"]");
    By movies = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.imdb.mobile:id/list\"]/android.widget.LinearLayout");

    public SearchScreen(AppiumDriver driver) {
        super(driver);
    }
    public SearchScreen searchMovie(String movie){
        waitForElementPresence(txtSearch);
        tapElement(mapToElement(txtSearch));
        mapToElement(txtSearch).sendKeys(movie);
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        return this;
    }
    public MovieScreen selectFirstMovie(){
        waitForElementPresence(lstSearch);
        mapToElements(lstSearch).get(0).click();
        return new MovieScreen(driver);
    }
    public String selectAnyMovie(){
        waitForElementPresence(lstSearch);
        List<WebElement> webElements = mapToElements(lstSearch);
        Random random = new Random();
        int selectedIndex = random.ints(0, webElements.size()).findFirst().getAsInt();
        String movieTitle = mapToElements(lstNames).get(selectedIndex).getText();
        webElements.get(selectedIndex).click();
        return movieTitle;
    }

    public MovieScreen selectAMovie(){
        waitForElementPresence(txtTopMovies);
        tapElement(mapToElement(txtTopMovies));
        waitForElementPresence(movies);
        List<WebElement> webElement = mapToElements(movies);
        Random random = new Random();
        int selectedIndex = random.ints(0, webElement.size()).findFirst().getAsInt();
        webElement.get(selectedIndex).click();
        return new MovieScreen(driver);
    }
}
