package jupytertoys.tests;

import jupytertoys.pages.ContactPage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginTests extends BaseTests {
    @Test
    public void testCase04() {
        // Clicking the login menu from the home page
        homePage.clickLoginPage();

        // Entering username "anyvaluewilldo" and password "letmein"
        homePage.setUsername("anyvaluewilldo");
        homePage.setPassword("letmein");

        // Clicking the login button
        homePage.clickLoginButton();

        // Verifying that the username appears in the menu bar
        assertEquals(homePage.getUsernameInMenuBar(), "anyvaluewilldo");
    }

    @Test
    public void testCase05() {
        // Going to the contact page
        ContactPage contactPage = homePage.clickContactPage();

        // Clicking the login menu from the contact page
        contactPage.clickLoginPage();

        // Entering username "anyvaluewilldo" and password "letmein"
        contactPage.setUsername("anyvaluewilldo");
        contactPage.setPassword("letmein");

        // Clicking the logout menu
        contactPage.clickLogoutMenu();

        // Clicking the logout button
        contactPage.clickLogoutButton();

        // Validating that the username is not displayed
        try {
            String username = contactPage.getUsernameInMenuBar();
            System.out.println("There is something wrong! Username is not supposed to be displayed. Actual: ");
            System.out.println("Username: " + username);
            fail(); // fail this test case since the username is displayed
        }
        catch (Exception e) {
            assertTrue(true);
        }
    }
}
