package contact;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;

public class ContactTests extends BaseTests {
    @Test
    public void testCase01() {
        // Going to the contact page
        ContactPage contactPage = homePage.clickContactPage();

        // Populating the email field with "thisisnotavalidemail"
        contactPage.setEmail("thisisnotavalidemail");

        // Asserting that the email error is displayed with text "Please enter a valid email"
        assertTrue(contactPage.getEmailErrorText().contains("Please enter a valid email"));
    }
}
