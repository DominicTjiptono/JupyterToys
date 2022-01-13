package jupytertoys.tests;

import jupytertoys.components.Product;
import jupytertoys.pages.ShopPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ShopTests extends BaseTests {
    @Test
    public void testCase06() {
        ShopPage shopPage = homePage.clickShopPage();
        List<Product> products = shopPage.getProducts();
        for (Product product : products) {
            if (product.getTitle().equals("Teddy Bear")) {
                assertEquals(product.getPrice(), "$12.99",
                        "Invalid Teddy Bear price.");
                break;
            }
        }
    }
}
