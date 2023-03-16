package screens;

import common.Global;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseScreen {
    protected AppiumDriver driver;
    protected WebDriverWait wait;
    protected TouchAction touchAction;

    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Global.TIMEOUT));
        touchAction = new TouchAction((AndroidDriver) driver);
    }

    public WebElement mapToElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> mapToElements(By locator) {
        return driver.findElements(locator);
    }

    public void waitForElementPresence(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void tapElement(WebElement element){
        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(element))).perform();
    }
    public void scrollIntoView(String text){
        driver.findElement(new AppiumBy.
                ByAndroidUIAutomator(
                        String.format("new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"));", text)));
    }
}
