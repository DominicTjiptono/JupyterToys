package jupytertoys.tests;

import jupytertoys.components.Product;
import jupytertoys.pages.CartPage;
import jupytertoys.pages.ShopPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class CartTests extends BaseTests {
    @Test
    public void testCase10() {
        ShopPage shopPage = homePage.clickShopPage();
        Product stuffedFrog = shopPage.getProduct(p -> p.getTitle().equals("Stuffed Frog"));
        assertNotNull(stuffedFrog, "Stuffed Frog not found on Shop Page!");
        Product fluffyBunny = shopPage.getProduct(p -> p.getTitle().equals("Fluffy Bunny"));
        assertNotNull(fluffyBunny, "Fluffy Bunny not found on Shop Page!");
        Product valentineBear = shopPage.getProduct(p -> p.getTitle().equals("Valentine Bear"));
        assertNotNull(valentineBear, "Valentine Bear not found on Shop Page!");
        stuffedFrog.buyProduct(2);
        fluffyBunny.buyProduct(5);
        valentineBear.buyProduct(3);
        CartPage cartPage = shopPage.clickCartPage();
        assertEquals(cartPage.getNthProductPrice(1), 10.99,
                "Invalid Stuffed Frog price.");
        assertEquals(cartPage.getNthProductPrice(2), 8.99,
                "Invalid Fluffy Bunny price.");
        assertEquals(cartPage.getNthProductPrice(3), 13.99,
                "Invalid Valentine Bear price.");
        assertEquals(cartPage.getNthProductPrice(1) * cartPage.getNthProductQuantity(1),
                cartPage.getNthProductSubtotal(1), "Invalid Stuffed Frog subtotal.");
        assertEquals(cartPage.getNthProductPrice(2) * cartPage.getNthProductQuantity(2),
                cartPage.getNthProductSubtotal(2), "Invalid Fluffy Bunny subtotal.");
        assertEquals(cartPage.getNthProductPrice(3) * cartPage.getNthProductQuantity(3),
                cartPage.getNthProductSubtotal(3), "Invalid Valentine Bear subtotal.");
        assertEquals(cartPage.getCalculatedTotal(), cartPage.getActualTotal(),
                "Invalid calculated total price.");
    }
}
