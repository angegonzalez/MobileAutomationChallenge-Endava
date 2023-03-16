package screens;

import io.appium.java_client.AppiumDriver;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.By;

public class SignInScreen extends BaseScreen{

    By txtEmail = By.xpath("//android.widget.EditText[@resource-id=\"ap_email\"]");
    By txtPassword = By.xpath("//android.widget.EditText[@resource-id=\"ap_password\"]");
    By btnSignIn = By.className("android.widget.Button");

    private final Dotenv dotenv = Dotenv.load();
    private final String email = dotenv.get("EMAIL");
    private final String password = dotenv.get("PASSWORD");


    public SignInScreen(AppiumDriver driver) {
        super(driver);
    }

    public void signInWithCredentials(){
        waitForElementPresence(txtEmail);
        waitForElementPresence(txtPassword);
        waitForElementPresence(btnSignIn);
        mapToElement(txtEmail).sendKeys(email);
        mapToElement(txtPassword).sendKeys(password);
        mapToElement(btnSignIn).click();
    }
}
