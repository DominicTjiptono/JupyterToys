package jupytertoys.pages;

import jupytertoys.components.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    public Product getProduct(String title) {
        Product matchingProduct = null;
        for (Product product : getProducts()) {
            if (product.getTitle().equals(title)) {
                matchingProduct = product;
                break;
            }
        }

        return matchingProduct;
    }

    public Product getProduct(double price) {
        Product matchingProduct = null;
        for (Product product : getProducts()) {
            if (product.getPrice() == price) {
                matchingProduct = product;
                break;
            }
        }

        return matchingProduct;
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        List<WebElement> webElementsForTitles = driver.findElements(By.className("product-title"));
        List<WebElement> webElementsForPrices = driver.findElements(By.className("product-price"));
        List<WebElement> buyButtons = driver.findElements(By.className("btn-success"));
        for (int i = 0; i < webElementsForTitles.size(); i++) {
            String title = webElementsForTitles.get(i).getText();
            double price = Double.parseDouble(webElementsForPrices.get(i).getText().substring(1));
            WebElement buyButton = buyButtons.get(i);
            Product product = new Product(title, price, buyButton);
            products.add(product);
        }

        return products;
    }
}
