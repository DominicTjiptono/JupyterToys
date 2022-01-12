package jupytertoys.tests;

import jupytertoys.pages.ContactPage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginTests extends BaseTests {
    @Test
    public void testCase04() {
        homePage.clickLoginPage();
        homePage.setUsername("anyvaluewilldo");
        homePage.setPassword("letmein");
        homePage.clickLoginButton();
        assertEquals(homePage.getUsernameInMenuBar(), "anyvaluewilldo",
                "Username should have appeared in the menu bar!");
    }

    @Test
    public void testCase05() {
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.clickLoginPage();
        contactPage.setUsername("anyvaluewilldo");
        contactPage.setPassword("letmein");
        contactPage.clickLoginButton();
        contactPage.clickLogoutMenu();
        contactPage.clickLogoutButton();
        assertEquals(contactPage.getUsernameInMenuBar(), "",
                "Username is not supposed to appear in the menu bar!");
    }
}
