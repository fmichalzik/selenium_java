package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecurePage;


import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickFormAuthenticationLink();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecurePage securePage = loginPage.clickLoginButton();
        assertTrue(securePage.getMessageText().contains("You logged into a secure area!"),
                "Message incorrect!");
    }
}
