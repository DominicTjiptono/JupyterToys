package jupytertoys.tests;

import jupytertoys.pages.ShopPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ShopTests extends BaseTests {
    @Test
    public void testCase06() {
        ShopPage shopPage = homePage.clickShopPage();
        List<WebElement> webElementsForTitles = shopPage.getWebElementsForTitles();
        List<WebElement> webElementsForPrices = shopPage.getWebElementsForPrices();
        assertEquals(webElementsForTitles.get(0).getText(), "Teddy Bear",
                "Invalid name of first item.");
        assertEquals(webElementsForPrices.get(0).getText(), "$12.99",
                "Invalid Teddy Bear price.");
    }
}
