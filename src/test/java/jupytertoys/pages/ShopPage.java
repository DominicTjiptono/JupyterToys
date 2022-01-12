package jupytertoys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShopPage {

    // Class attributes
    private WebDriver driver;

    public ShopPage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getWebElementsForTitles() {
        return driver.findElements(By.className("product-title"));
    }

    public List<WebElement> getWebElementsForPrices() {
        return driver.findElements(By.className("product-price"));
    }
}
