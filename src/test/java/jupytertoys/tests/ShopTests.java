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
                "Name of first item is supposed to be 'Teddy Bear'.");
        assertEquals(webElementsForPrices.get(0).getText(), "$12.99",
                "Cost of 'Teddy Bear' is supposed to be $12.99.");
        assertEquals(webElementsForTitles.get(1).getText(), "Stuffed Frog",
                "Name of second item is supposed to be 'Stuffed Frog'.");
        assertEquals(webElementsForPrices.get(1).getText(), "$10.99",
                "Cost of 'Stuffed Frog' is supposed to be $10.99.");
        assertEquals(webElementsForTitles.get(2).getText(), "Handmade Doll",
                "Name of third item is supposed to be 'Handmade Doll'.");
        assertEquals(webElementsForPrices.get(2).getText(), "$10.99",
                "Cost of 'Handmade Doll' is supposed to be $10.99.");
        assertEquals(webElementsForTitles.get(3).getText(), "Fluffy Bunny",
                "Name of fourth item is supposed to be 'Fluffy Bunny'.");
        assertEquals(webElementsForPrices.get(3).getText(), "$9.99",
                "Cost of 'Fluffy Bunny' is supposed to be $9.99.");
        assertEquals(webElementsForTitles.get(4).getText(), "Smiley Bear",
                "Name of fifth item is supposed to be 'Smiley Bear'.");
        assertEquals(webElementsForPrices.get(4).getText(), "$14.99",
                "Cost of 'Smiley Bear' is supposed to be $14.99.");
        assertEquals(webElementsForTitles.get(5).getText(), "Funny Cow",
                "Name of sixth item is supposed to be 'Funny Cow'.");
        assertEquals(webElementsForPrices.get(5).getText(), "$10.99",
                "Cost of 'Funny Cow' is supposed to be $10.99.");
        assertEquals(webElementsForTitles.get(6).getText(), "Valentine Bear",
                "Name of seventh item is supposed to be 'Valentine Bear'.");
        assertEquals(webElementsForPrices.get(6).getText(), "$14.99",
                "Cost of 'Valentine Bear' is supposed to be $14.99.");
        assertEquals(webElementsForTitles.get(7).getText(), "Smiley Face",
                "Name of eighth item is supposed to be 'Smiley Face'.");
        assertEquals(webElementsForPrices.get(7).getText(), "$9.99",
                "Cost of 'Smiley Face' is supposed to be $9.99.");
    }
}
