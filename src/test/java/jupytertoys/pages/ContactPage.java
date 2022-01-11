package jupytertoys.pages;

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
    private By submitButton = By.className("btn-primary");
    private By forenameError = By.id("forename-err");
    private By emailError = By.id("email-err");
    private By messageError = By.id("message-err");
    private By statusAlert = By.className("alert-success");
    private By backButton = By.className("btn");

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

    public void clickSubmitButton(){
        driver.findElement(submitButton).click();
    }

    public String getForenameErrorText() {
        return driver.findElement(forenameError).getText();
    }

    public String getEmailErrorText() {
        return driver.findElement(emailError).getText();
    }

    public String getMessageErrorText() {
        return driver.findElement(messageError).getText();
    }

    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }

    public ContactPage clickBackButton(){
        driver.findElement(backButton).click();
        return new ContactPage(driver);
    }
}
