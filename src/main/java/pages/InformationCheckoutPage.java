package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class InformationCheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    By firstNameInformation = By.id("first-name");
    By lastNameInformation = By.id("last-name");
    By zipInformation = By.id("postal-code");
    By continueButton = By.id("continue");

    public InformationCheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void inputFirstName(String firstName) {
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInformation));
        firstNameElement.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInformation));
        lastNameElement.sendKeys(lastName);
    }

    public void inputZip(Integer zipCode) {
        WebElement zipCodeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(zipInformation));
        zipCodeElement.sendKeys(zipCode.toString());
    }

    public void clickContinueButton() {
        WebElement continueButtonElement = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButtonElement.click();
    }
}
