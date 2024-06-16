package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
public class OverviewCheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    By finishButton = By.id("finish");

    public OverviewCheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickFinishButton() {
        WebElement finishButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton));
        finishButtonElement.click();
    }
}
