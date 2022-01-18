package jupytertoys.tests;

import jupytertoys.components.Product;
import jupytertoys.pages.CartPage;
import jupytertoys.pages.ShopPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class CartTests extends BaseTests {
    @Test
    public void testCase10() {
        ShopPage shopPage = homePage.clickShopPage();
        Product stuffedFrog = shopPage.getProduct(p -> p.getTitle().equals("Stuffed Frog"));
        assertNotEquals(stuffedFrog, null);
        Product fluffyBunny = shopPage.getProduct(p -> p.getTitle().equals("Fluffy Bunny"));
        assertNotEquals(fluffyBunny, null);
        Product valentineBear = shopPage.getProduct(p -> p.getTitle().equals("Valentine Bear"));
        assertNotEquals(valentineBear, null);
        stuffedFrog.buyProduct(2);
        fluffyBunny.buyProduct(5);
        valentineBear.buyProduct(3);
        CartPage cartPage = shopPage.clickCartPage();
        assertEquals(cartPage.getNthProductPrice(1), 10.99);
        assertEquals(cartPage.getNthProductPrice(2), 8.99);
        assertEquals(cartPage.getNthProductPrice(3), 13.99);
        assertEquals(cartPage.getNthProductPrice(1) * cartPage.getNthProductQuantity(1),
                cartPage.getNthProductSubtotal(1));
        assertEquals(cartPage.getNthProductPrice(2) * cartPage.getNthProductQuantity(2),
                cartPage.getNthProductSubtotal(2));
        assertEquals(cartPage.getNthProductPrice(3) * cartPage.getNthProductQuantity(3),
                cartPage.getNthProductSubtotal(3));
        assertEquals(cartPage.getCalculatedTotal(), cartPage.getActualTotal());
    }
}
