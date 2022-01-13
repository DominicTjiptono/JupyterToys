package jupytertoys.pages;

import jupytertoys.components.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ShopPage {

    // Class attributes
    private WebDriver driver;
    private By cartMenu = By.id("nav-cart");

    public ShopPage(WebDriver driver){
        this.driver = driver;
    }

    public String getCartMenuText() {
        return driver.findElement(cartMenu).getText();
    }

    public Product getProduct(Function<Product, Boolean> comparison) {
        for (Product product : getProducts()) {
            if (comparison.apply(product)) {
                return product;
            }
        }

        return null;
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        List<WebElement> items = driver.findElements(By.className("product"));
        for (WebElement item : items) {
            products.add(new Product(item.findElement(By.cssSelector(".product-title")).getText(),
                    Double.parseDouble(item.findElement(By.cssSelector(".product-price"))
                            .getText().replace("$", "")),
                    item.findElement(By.className("btn-success"))));
        }

        return products;
    }
}
