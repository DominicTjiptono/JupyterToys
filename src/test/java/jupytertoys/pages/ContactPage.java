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
    private By usernameMenuBar = By.id("nav-user");
    private By usernameField = By.id("loginUserName");
    private By passwordField = By.id("loginPassword");

    public ContactPage(WebDriver driver){
        this.driver = driver;
    }

    public void setForename(String forename){
        driver.findElement(forenameField).sendKeys(forename);
    }

    public void setSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
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
        var elements = driver.findElements(forenameError);
        if (elements.size() == 0) {
            return "";
        }
        return elements.get(0).getText();
    }

    public String getEmailErrorText() {
        var elements = driver.findElements(emailError);
        if (elements.size() == 0) {
            return "";
        }
        return elements.get(0).getText();
    }

    public String getMessageErrorText() {
        var elements = driver.findElements(messageError);
        if (elements.size() == 0) {
            return "";
        }
        return elements.get(0).getText();
    }

    public String getAlertText(){
        var elements = driver.findElements(statusAlert);
        if (elements.size() == 0) {
            return "";
        }
        return elements.get(0).getText();
    }

    public void clickBackButton(){
        driver.findElement(backButton).click();
    }

    public void clickLoginPage() {
        clickButton("#nav-login");
    }

    public void clickLogoutMenu() {
        clickButton("#nav-logout");
    }

    public void clickLogoutButton() {
        clickButton("btn-success");
    }

    public String getUsernameInMenuBar() {
        return driver.findElement(usernameMenuBar).getText();
    }

    // Creating a method to click a button in the page.
    private void clickButton(String buttonId) {
        driver.findElement(By.cssSelector(buttonId)).click();
    }
}
