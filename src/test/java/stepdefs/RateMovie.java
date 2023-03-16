package stepdefs;

import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import screens.HomeScreen;
import screens.MovieScreen;
import screens.RatingScreen;
import screens.SearchScreen;

public class RateMovie {
    AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
    HomeScreen homeScreen = new HomeScreen(driver);
    SearchScreen searchScreen = new SearchScreen(driver);
    MovieScreen movieScreen = new MovieScreen(driver);
    RatingScreen ratingScreen = new RatingScreen(driver);

    @And("the user searches for a movie")
    public void userSearchesForAMovie(){
        homeScreen.clickSearch();
        searchScreen.selectAMovie();
    }
    @When("user rates the selected movie")
    public void userRatesSelectedMovie(){
        movieScreen.goToReviewSection();
        ratingScreen.rateMovie();
    }
    @Then("the message {string} is displayed to the user")
    public void userSeesMessage(String message){
        String savedMessage = movieScreen.getSavedMessage();
        Assertions.assertThat(savedMessage).isEqualTo(message);
    }
}
