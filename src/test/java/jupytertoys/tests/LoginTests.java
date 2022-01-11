package jupytertoys.tests;

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
}
