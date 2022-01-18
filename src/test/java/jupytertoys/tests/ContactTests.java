package jupytertoys.tests;

import org.testng.annotations.Test;
import jupytertoys.pages.ContactPage;

import static org.testng.Assert.assertEquals;

public class ContactTests extends BaseTests {
    @Test
    public void testCase01() {
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.setEmail("thisisnotavalidemail");
        contactPage.clickSubmitButton();
        assertEquals(contactPage.getErrorText("email"), "Please enter a valid email",
                "Email error is supposed to occur!");
    }

    @Test
    public void testCase02() {
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.clickSubmitButton();
        assertEquals(contactPage.getErrorText("forename"), "Forename is required",
                "Forename error is supposed to occur!");
        assertEquals(contactPage.getErrorText("email"), "Email is required",
                "Email error is supposed to occur!");
        assertEquals(contactPage.getErrorText("message"), "Message is required",
                "Message error is supposed to occur!");
        contactPage.setForename("ex");
        contactPage.setEmail("example@gmail.com");
        contactPage.setMessage("I am new!");
        assertEquals(contactPage.getErrorText("forename"), "",
                "Forename error should not exist!");
        assertEquals(contactPage.getErrorText("email"), "",
                "Email error should not exist!");
        assertEquals(contactPage.getErrorText("message"), "",
                "Message error should not exist!");
    }

    @Test
    public void testCase03() {
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.setForename("ex");
        contactPage.setEmail("example@gmail.com");
        contactPage.setMessage("I am new!");
        contactPage.clickSubmitButton();
        assertEquals(contactPage.getAlertText(), "Thanks ex, we appreciate your feedback.",
                "Alert text should have appeared!");
    }
}
