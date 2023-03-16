package stepdefs;

import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import screens.HomeScreen;
import screens.VideoScreen;

import java.util.List;

public class SortTrailers {
    private final AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
    private final HomeScreen homeScreen= new HomeScreen(driver);
    private final VideoScreen videoScreen = new VideoScreen(driver);

    @And("the user goes to the video section")
    public void userGoesVideoSection(){
        homeScreen.clickVideo();
    }
    @And("the user sees all popular trailers")
    public void userSeesAllPopularTrailers(){
        videoScreen.seeAllPopularTrailers();
    }
    @When("the user sorts trailers alphabetically")
    public void userSortsTrailersAlphabetically(){
        videoScreen.sortAlphabetically();
    }
    @Then("trailers are sorted alphabetically")
    public void trailersAreSortedAlphabetically(){
        List<String> videoTitles = videoScreen.getVideoTitles();
        Assertions.assertThat(videoTitles).isSorted();
    }
}
