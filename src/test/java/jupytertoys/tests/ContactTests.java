package jupytertoys.tests;

import org.testng.annotations.Test;
import jupytertoys.pages.ContactPage;

import static org.testng.Assert.*;

public class ContactTests extends BaseTests {
    @Test
    public void testCase01() {
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.setEmail("thisisnotavalidemail");
        contactPage.clickSubmitButton();
        assertEquals(contactPage.getEmailErrorText(), "Please enter a valid email",
                "Email error occurs");
    }

    @Test
    public void testCase02() {
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.clickSubmitButton();
        assertEquals(contactPage.getForenameErrorText(), "Forename is required",
                "Forename error occurs");
        assertEquals(contactPage.getEmailErrorText(), "Email is required",
                "Email error occurs");
        assertEquals(contactPage.getMessageErrorText(), "Message is required",
                "Message error occurs");
        contactPage.setForename("ex");
        contactPage.setEmail("example@gmail.com");
        contactPage.setMessage("I am new!");
        assertEquals(contactPage.getForenameErrorText(), "",
                "Forename error does not exist");
        assertEquals(contactPage.getEmailErrorText(), "",
                "Email error does not exist");
        assertEquals(contactPage.getMessageErrorText(), "",
                "Message error does not exist");
    }

    @Test
    public void testCase03() {
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.setForename("ex");
        contactPage.setEmail("example@gmail.com");
        contactPage.setMessage("I am new!");
        contactPage.clickSubmitButton();
        assertEquals(contactPage.getAlertText(), "Thanks ex, we appreciate your feedback.",
                "Alert text appears");
    }
}
