package jupytertoys.tests;

import org.testng.annotations.Test;
import jupytertoys.pages.ContactPage;

import static org.testng.Assert.*;

public class ContactTests extends BaseTests {
    @Test
    public void testCase01() {
        // Going to the contact page
        ContactPage contactPage = homePage.clickContactPage();

        // Populating the email field with "thisisnotavalidemail"
        contactPage.setEmail("thisisnotavalidemail");

        // Clicking the submit button
        contactPage.clickSubmitButton();

        // Asserting that the email error is displayed with text "Please enter a valid email"
        assertEquals(contactPage.getEmailErrorText(), "Please enter a valid email");
    }

    @Test
    public void testCase02() {
        // Going to the contact page
        ContactPage contactPage = homePage.clickContactPage();

        // Clicking the submit button
        contactPage.clickSubmitButton();

        // Ensuring that the errors "Forename is required",
        // "Email is required", and "Message is required" are shown.
        assertEquals(contactPage.getForenameErrorText(), "Forename is required");
        assertEquals(contactPage.getEmailErrorText(), "Email is required");
        assertEquals(contactPage.getMessageErrorText(), "Message is required");

        // Populating mandatory fields
        contactPage.setForename("ex");
        contactPage.setEmail("example@gmail.com");
        contactPage.setMessage("I am new!");

        // Ensuring that the mandatory errors are no longer displayed.
        String forenameError = contactPage.getForenameErrorText();
        String emailError = contactPage.getEmailErrorText();
        String messageError = contactPage.getMessageErrorText();
        assertEquals(forenameError, "");
        assertEquals(emailError, "");
        assertEquals(messageError, "");
    }

    @Test
    public void testCase03() {
        // Going to the contact page
        ContactPage contactPage = homePage.clickContactPage();

        // Populating mandatory fields
        contactPage.setForename("ex");
        contactPage.setEmail("example@gmail.com");
        contactPage.setMessage("I am new!");

        // Clicking the submit button
        contactPage.clickSubmitButton();

        // Verifying "Thanks" message text
        assertEquals(contactPage.getAlertText(), "Thanks ex, we appreciate your feedback.");
    }
}
