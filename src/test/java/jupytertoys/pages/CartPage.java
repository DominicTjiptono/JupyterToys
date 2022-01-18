package jupytertoys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    // Class attributes
    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public int getNumProducts() {
        return driver.findElements(By.name("quantity")).size();
    }

    public int getNthProductQuantity(int n) {
        return Integer.parseInt(driver.findElements(By.className("input-mini")).get(n - 1).getAttribute("value"));
    }

    public double getNthProductPrice(int n) {
        return Double.parseDouble(driver.findElements
                (By.tagName("td")).get(5 * n - 3).getText().substring(1));
    }

    public double getNthProductSubtotal(int n) {
        return Double.parseDouble(driver.findElements
                (By.tagName("td")).get(5 * n - 2).getText().substring(1));
    }

    public double getActualTotal() {
        return Double.parseDouble(driver.findElements
                (By.tagName("td")).get(driver.findElements
                (By.tagName("td")).size() - 2).getText().split(" ")[1]);
    }

    public double getCalculatedTotal() {
        double total = 0; // initial value
        for (int i = 1; i <= getNumProducts(); i++) {
            total += getNthProductSubtotal(i);
        }
        return total;
    }
}
