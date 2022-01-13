package jupytertoys.tests;

import jupytertoys.components.Product;
import jupytertoys.pages.ShopPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ShopTests extends BaseTests {
    @Test
    public void testCase06() {
        ShopPage shopPage = homePage.clickShopPage();
        Product product = shopPage.getProduct(p -> p.getTitle().equals("Teddy Bear"));
        assertNotEquals(product, null);
        assertEquals(product.getPrice(), 12.99,
                "Invalid Teddy Bear price.");
    }

    @Test
    public void testCase07() {
        ShopPage shopPage = homePage.clickShopPage();
        Product product = shopPage.getProduct(p -> p.getPrice() == 9.99);
        assertNotEquals(product, null);
        int before = shopPage.getNumberOfItemsInCart();
        product.getBuy().click();
        assertEquals(shopPage.getNumberOfItemsInCart() - before, 1,
                "Incorrect number of items in cart.");
    }
}
