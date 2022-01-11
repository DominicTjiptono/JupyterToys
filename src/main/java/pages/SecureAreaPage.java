package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {

    // Class attributes
    private WebDriver driver;
    private By statusAlert = By.className("alert alert-success");
    private By backButton = By.cssSelector("#back button");

    public SecureAreaPage(WebDriver driver){
        this.driver = driver;
    }

    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }

    public ContactPage clickBackButton(){
        driver.findElement(backButton).click();
        return new ContactPage(driver);
    }
}
