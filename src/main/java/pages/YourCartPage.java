package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class YourCartPage {
    WebDriver driver;
    WebDriverWait wait;

    By checkoutButton = By.id("checkout");

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public void clickCheckoutButton() {
        WebElement checkoutButtonElement = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButtonElement.click();
    }
}
