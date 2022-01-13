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
        Product product = shopPage.getProduct("Teddy Bear");
        assertEquals(product.getPrice(), 12.99,
                        "Invalid Teddy Bear price.");
    }

    @Test
    public void testCase07() {
        ShopPage shopPage = homePage.clickShopPage();
        Product product = shopPage.getProduct(9.99);
        product.getBuy().click();
        assertEquals(shopPage.getCartMenuText(), "Cart (1)",
                "Incorrect number of items in cart.");
    }
}
