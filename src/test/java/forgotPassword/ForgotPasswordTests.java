package forgotPassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.HomePage;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testRetrievePassword() throws InterruptedException {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.setEmail("test");
        forgotPasswordPage.clickRetrievePasswordButton();
    }
}
