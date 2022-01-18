package jupytertoys.tests;

import jupytertoys.components.ContactData;
import org.openqa.selenium.By;
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
        contactPage.setForename("ex");
        contactPage.setEmail("example@gmail.com");
        contactPage.setMessage("I am new!");
        assertEquals(contactPage.getErrorText(By.id("forename-err")), "",
                "Forename error should not exist!");
        assertEquals(contactPage.getErrorText(By.id("email-err")), "",
                "Email error should not exist!");
        assertEquals(contactPage.getErrorText(By.id("message-err")), "",
                "Message error should not exist!");
    }

    @Test
    public void testCase03() {
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.populateFieldsFromContactData(new ContactData("ex", "",
                "example@gmail.com", "", "I am new!"));
        contactPage.clickSubmitButton();
        assertEquals(contactPage.getErrorText(By.className("alert-success")), "Thanks ex, we appreciate your feedback.",
                "Alert text should have appeared!");
    }
}
