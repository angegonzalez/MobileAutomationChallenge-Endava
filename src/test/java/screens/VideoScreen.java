package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class VideoScreen extends BaseScreen {
    By txtSeeAll = By.xpath("//android.widget.TextView[@content-desc=\"See all Popular trailers\"]");
    By btnSort = By.id("com.imdb.mobile:id/refine_button");
    By txtSortBy = By.xpath("//android.widget.TextView[@text=\"Sort By\"]");
    By txtAlphabetical = By.xpath("//android.widget.TextView[@text=\"Alphabetical\"]");
    By txtPopularTitle = By.xpath("//android.widget.TextView[@text=\"Popular trailers\"]");
    By videoTitles = By.xpath("//android.widget.TextView[@resource-id=\"com.imdb.mobile:id/video_title\"]");

    public VideoScreen(AppiumDriver driver) {
        super(driver);
    }

    public VideoScreen seeAllPopularTrailers() {
        waitForElementPresence(txtSeeAll);
        tapElement(mapToElement(txtSeeAll));
        return this;
    }

    public VideoScreen sortAlphabetically() {
        waitForElementPresence(btnSort);
        tapElement(mapToElement(btnSort));
        waitForElementPresence(txtSortBy);
        tapElement(mapToElement(txtSortBy));
        waitForElementPresence(txtAlphabetical);
        tapElement(mapToElement(txtAlphabetical));
        tapElement(mapToElement(txtPopularTitle));
        return this;
    }

    public List<String> getVideoTitles(){
        List<String> videoTitlesList = new ArrayList<>();
        List<WebElement> webElements = mapToElements(videoTitles);
        webElements.forEach((WebElement element)->{
            videoTitlesList.add(element.getText());
        });
        return videoTitlesList;
    }
}
