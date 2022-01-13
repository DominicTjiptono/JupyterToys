package jupytertoys.components;

import org.openqa.selenium.WebElement;

public class Product {
    // Class attributes
    private String title;
    private double price;
    WebElement buy;

    public Product(String title, double price, WebElement buy) {
        this.title = title;
        this.price = price;
        this.buy = buy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public WebElement getBuy() {
        return buy;
    }

    public void setBuy(WebElement buy) {
        this.buy = buy;
    }
}
