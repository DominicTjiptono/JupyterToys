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
                assertEquals(product.getPrice(), 12.99,
                        "Invalid Teddy Bear price.");
                break;
            }
        }
    }

    @Test
    public void testCase07() {
        ShopPage shopPage = homePage.clickShopPage();
        List<Product> products = shopPage.getProducts();
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() == 9.99) {
                index = i;
                break;
            }
        }

        products.get(index).getBuy().click();
        assertEquals(shopPage.getCartMenuText(), "Cart (1)");
    }
}
