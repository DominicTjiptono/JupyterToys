package jupytertoys.tests;

import jupytertoys.pages.ShopPage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ShopTests extends BaseTests {
    @Test
    public void testCase06() {
        // Going to the shop page
        ShopPage shopPage = homePage.clickShopPage();

        // Verifying the price for each product in the shop page
    }
}
