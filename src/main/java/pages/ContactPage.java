package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {

    // Class attributes
    private WebDriver driver;
    private By forenameField = By.id("forename");
    private By surnameField = By.id("surname");
    private By emailField = By.id("email");
    private By telephoneField = By.id("telephone");
    private By messageField = By.id("message");
    private By submitButton = By.cssSelector("#submit button");
    private By emailError = By.id("email-err");

    public ContactPage(WebDriver driver){
        this.driver = driver;
    }

    public void setForename(String forename){
        driver.findElement(forenameField).sendKeys(forename);
    }

    public void setSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setTelephone(String telephone){
        driver.findElement(telephoneField).sendKeys(telephone);
    }

    public void setMessage(String message){
        driver.findElement(messageField).sendKeys(message);
    }

    public SecureAreaPage clickSubmitButton(){
        driver.findElement(submitButton).click();
        return new SecureAreaPage(driver);
    }

    public String getEmailErrorText() {
        return driver.findElement(emailError).getText();
    }
}
