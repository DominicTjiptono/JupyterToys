package jupytertoys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    // Class attributes
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage clickHomePage() {
        clickButton("#nav-home");
        return new HomePage(driver);
    }

    public ContactPage clickContactPage() {
        clickButton("#nav-contact");
        return new ContactPage(driver);
    }

    public ShopPage clickShopPage() {
        clickButton("#nav-shop");
        return new ShopPage(driver);
    }

    public LoginPage clickLoginPage() {
        clickButton("#nav-login");
        return new LoginPage(driver);
    }

    public CartPage clickCartPage() {
        clickButton("#nav-cart");
        return new CartPage(driver);
    }

    // Creating a method to click a button in the page.
    private void clickButton(String buttonId) {
        driver.findElement(By.cssSelector(buttonId));
    }
}
