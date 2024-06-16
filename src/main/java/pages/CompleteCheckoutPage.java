package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompleteCheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    By backHomeButton = By.name("back-to-products");

    By completeText = By.xpath("//div[contains(@class, 'complete-text')]");

    public CompleteCheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickBackHomeButton() {
        WebElement backHomeButtonElement = wait.until(ExpectedConditions.elementToBeClickable(backHomeButton));
        backHomeButtonElement.click();
    }

    public String completeTextGetText() {
        WebElement completeTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(completeText));
        return completeTextElement.getText();
    }
}
