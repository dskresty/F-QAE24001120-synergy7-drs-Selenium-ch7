import config.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;
import java.util.List;

public class SwagLabsFeature extends Hooks {

    @Test
    public void loginSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        //assertion url dashboard
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        //assertion products text
        WebElement textProducts = driver.findElement(By.xpath("//span[contains(@class, 'title')]"));
        Assert.assertEquals(textProducts.getText(), "Products");

        //assertion cart icon
        WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'shopping_cart_link')]")));
        assert cartIcon.isDisplayed();
    }

    @Test
    public void loginFailed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //fill valid username and invalid password
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secretsauce");
        loginPage.clickLoginButton();

        //assertion text failed login
        WebElement errorText = driver.findElement(By.xpath("//h3[contains(@data-test, 'error')]"));
        Assert.assertEquals(errorText.getText(), "Epic sadface: Username and password do not match any user in this service");

        //assertion error login button
        //WebElement buttonError = driver.findElement(By.xpath("//button[contains(@class, 'error-button')]"));
        WebElement buttonError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'error-button')]")));
        assert buttonError.isDisplayed();
    }

    @Test
    public void sortingItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
        homePage.clickSortButton();
        homePage.clickSortButtonHiLo();
        List<Double> prices = homePage.getItemPrices();
        Assert.assertTrue(prices.get(0) > prices.get(1), "The first item price is not higher than the second item price.");
    }

    @Test
    public void checkoutItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        YourCartPage yourCartPage = new YourCartPage(driver);
        InformationCheckoutPage informationCheckoutPage = new InformationCheckoutPage(driver);
        OverviewCheckoutPage overviewCheckoutPage = new OverviewCheckoutPage(driver);
        CompleteCheckoutPage completeCheckoutPage = new CompleteCheckoutPage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
        homePage.addFirstProductToCart();
        homePage.addSecondProductToCart();
        homePage.clickCartButton();
        yourCartPage.clickCheckoutButton();

        informationCheckoutPage.inputFirstName("Do Re");
        informationCheckoutPage.inputLastName("Mi");
        informationCheckoutPage.inputZip(1234);
        informationCheckoutPage.clickContinueButton();

        overviewCheckoutPage.clickFinishButton();

        //assert text success checkout
        WebElement successCheckoutText = driver.findElement(By.xpath("//h2[contains(@class, 'complete-header')]"));
        Assert.assertEquals(successCheckoutText.getText(), "Thank you for your order!");

        //assert completed order text
        Assert.assertEquals(completeCheckoutPage.completeTextGetText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
}
