package jupytertoys.tests;

import jupytertoys.components.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jupytertoys.pages.ContactPage;

import static org.testng.Assert.assertEquals;

public class ContactTests extends BaseTests {
    @Test
    public void testCase01() {
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.setEmail("thisisnotavalidemail");
        contactPage.clickSubmitButton();
        assertEquals(contactPage.getErrorText(By.id("email-err")), "Please enter a valid email",
                "Email error is supposed to occur!");
    }

    @Test
    public void testCase02() {
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.clickSubmitButton();
        assertEquals(contactPage.getErrorText(By.id("forename-err")), "Forename is required",
                "Forename error is supposed to occur!");
        assertEquals(contactPage.getErrorText(By.id("email-err")), "Email is required",
                "Email error is supposed to occur!");
        assertEquals(contactPage.getErrorText(By.id("message-err")), "Message is required",
                "Message error is supposed to occur!");
        contactPage.populateFieldsFromContactData(new ContactData("ex", "",
                "example@gmail.com", "", "I am new!"));
        assertEquals(contactPage.getErrorText(By.id("forename-err")), "",
                "Forename error should not exist!");
        assertEquals(contactPage.getErrorText(By.id("email-err")), "",
                "Email error should not exist!");
        assertEquals(contactPage.getErrorText(By.id("message-err")), "",
                "Message error should not exist!");
    }

    @Test (dataProvider = "contactFieldsData")
    public void testCase03(String forename, String surname, String email, String telephone,
                           String message) {
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.populateFieldsFromContactData(new ContactData(forename, surname, email,
                telephone, message));
        contactPage.clickSubmitButton();
        assertEquals(contactPage.getErrorText(By.className("alert-success")),
                "Thanks " + forename + ", we appreciate your feedback.",
                "Alert text should have appeared!");
    }

    @DataProvider
    public Object[][] contactFieldsData() {
        Object[][] data = new Object[5][5];
        data[0][0] = "ex";
        data[0][1] = "";
        data[0][2] = "example@gmail.com";
        data[0][3] = "";
        data[0][4] = "I am new!";
        data[1][0] = "new user";
        data[1][1] = "one";
        data[1][2] = "newUserOne@gmail.com";
        data[1][3] = "";
        data[1][4] = "Website improvement needed!";
        data[2][0] = "new user";
        data[2][1] = "two";
        data[2][2] = "newUserTwo@gmail.com";
        data[2][3] = "029 8822 6655";
        data[2][4] = "I am new!";
        data[3][0] = "new user";
        data[3][1] = "";
        data[3][2] = "newUser@gmail.com";
        data[3][3] = "053 2312 3112";
        data[3][4] = "I am new!";
        data[4][0] = "random";
        data[4][1] = "";
        data[4][2] = "random@gmail.com";
        data[4][3] = "";
        data[4][4] = "This is awesome!";
        return data;
    }
}
