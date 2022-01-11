package login;

import base.BaseTests;
import jupytertoys.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {
    @Test
    public void testCase04() {
        // Clicking the login menu from the home page
        LoginPage loginPage = homePage.clickLoginPage();
    }
}
