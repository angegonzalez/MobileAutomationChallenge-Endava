package stepdefs;

import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import screens.HomeScreen;
import screens.MainScreen;
import screens.MovieScreen;
import screens.SearchScreen;

public class SearchMovie {
    AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
    private final MainScreen mainScreen = new MainScreen(driver);
    private HomeScreen homeScreen = new HomeScreen(driver);
    private SearchScreen searchScreen = new SearchScreen(driver);
    private MovieScreen movieScreen = new MovieScreen(driver);
    private String movie;

    @Given("the user is in the main page of the app")
    public void userIsInTheMainPage(){

    }
    @And("the user skips the login process")
    public void userSkipsLogin(){
        homeScreen = mainScreen.skipLogin();
    }
    @When("the user searches for the movie {string}")
    public void userSearchesForMovie(String movie){
        this.movie = movie;
        searchScreen = homeScreen.clickSearch();
        searchScreen.searchMovie(this.movie);
    }
    @And("the user selects the first result")
    public void userSelectsFirstResult(){
        movieScreen = searchScreen.selectFirstMovie();
    }
    @Then("the overview must match with an existing overviewed text")
    public void overviewMatching(){
        String movieTitle = movieScreen.getMovieTitle();
        Assertions.assertThat(this.movie).isEqualTo(movieTitle);
    }
}
