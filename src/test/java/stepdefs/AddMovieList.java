package stepdefs;

import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import screens.HomeScreen;
import screens.MovieScreen;
import screens.ProfileScreen;
import screens.SearchScreen;

public class AddMovieList {

    private final AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
    private final HomeScreen homeScreen = new HomeScreen(driver);
    private final SearchScreen searchScreen = new SearchScreen(driver);
    private final MovieScreen movieScreen = new MovieScreen(driver);
    private final ProfileScreen profileScreen = new ProfileScreen(driver);
    private String selectedMovie;
    @Given("the user is logged into the app")
    public void userIsLogged(){
        homeScreen.signIn();
    }
    @And("the user selects any movie")
    public void userSelectsAnyMovie(){
        selectedMovie = searchScreen.selectAnyMovie();
    }
    @And("the user adds the movie to the watch list")
    public void userAddsTheMovie(){
        movieScreen.addToWatchList();
    }
    @And("the user sees its watchlist")
    public void userSeesWatchList(){
        movieScreen.goToProfile();
    }
    @Then("the watch list must contain the previous searched movie")
    public void watchListContainsMovie(){
        String movieTitle = profileScreen.getMovieInWatchListTitle();
        Assertions.assertThat(selectedMovie).isEqualTo(movieTitle);
    }
}
