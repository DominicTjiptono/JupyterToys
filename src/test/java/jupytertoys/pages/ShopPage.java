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

    public ShopPage(WebDriver driver){
        this.driver = driver;
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        List<WebElement> webElementsForTitles = driver.findElements(By.className("product-title"));
        List<WebElement> webElementsForImages = new ArrayList<>();
        for (WebElement element : driver.findElements(By.tagName("img"))) {
            if (!(element.getAttribute("src").equals("images/src-embed/teddy.jpg"))) {
                webElementsForImages.add(element);
            }
        }

        List<WebElement> webElementsForPrices = driver.findElements(By.className("product-price"));
        for (int i = 0; i < webElementsForTitles.size(); i++) {
            String title = webElementsForTitles.get(i).getText();
            String imageSource = webElementsForImages.get(i).getText();
            String price = webElementsForPrices.get(i).getText();
            Product product = new Product(title, imageSource, price);
            products.add(product);
        }

        return products;
    }
}
