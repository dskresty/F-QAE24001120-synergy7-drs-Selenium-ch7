package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    By textProducts = By.xpath("//span[contains(@class, 'title')]");
    By iconCartItems = By.xpath("//a[contains(@class, 'shopping_cart_link')]");
    By sortButton = By.xpath("//select[contains(@class, 'product_sort_container')]");
    By sortButtonHiLo = By.xpath("//option[contains(@value, 'hilo')]");
    By itemPrices = By.className("inventory_item_price");
    By addFirstProduct = By.id("add-to-cart-sauce-labs-backpack");
    By addSecondProduct = By.id("add-to-cart-sauce-labs-bike-light");
    By clickCartButton = By.xpath("//a[contains(@class, 'shopping_cart_link')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String checkTextProducts() {
        WebElement textProductsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(textProducts));
        return textProductsElement.getText();
    }

    public boolean iconCartItemsIsDisplayed() {
        WebElement iconCartItemsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(iconCartItems));
        return iconCartItemsElement.isDisplayed();
    }

    public void clickSortButton() {
        WebElement sortButtonElement = wait.until(ExpectedConditions.elementToBeClickable(sortButton));
        sortButtonElement.click();
    }

    public void clickSortButtonHiLo() {
        WebElement sortButtonHiLoElement = wait.until(ExpectedConditions.elementToBeClickable(sortButtonHiLo));
        sortButtonHiLoElement.click();
    }

    public List<Double> getItemPrices() {
        List<Double> prices = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itemPrices));
        List<WebElement> priceElements = driver.findElements(itemPrices);
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "");
            System.out.println("Harga yang ditemukan: " + priceText);
            prices.add(Double.parseDouble(priceText));
        }
        return prices;
    }

    public void addFirstProductToCart() {
        WebElement addFirstProductElement = wait.until(ExpectedConditions.elementToBeClickable(addFirstProduct));
        addFirstProductElement.click();
    }

    public void addSecondProductToCart() {
        WebElement addSecondProductElement = wait.until(ExpectedConditions.elementToBeClickable(addSecondProduct));
        addSecondProductElement.click();
    }

    public void clickCartButton() {
        WebElement clickCartButtonElement = wait.until(ExpectedConditions.elementToBeClickable(clickCartButton));
        clickCartButtonElement.click();
    }
}
