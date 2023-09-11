package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.KeyPressesPage;

import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTests {

    @Test
    public void testBackspace() {
        KeyPressesPage keyPressesPage = homePage.clickKeyPressesLink();
        keyPressesPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPressesPage.getResultText(), "You entered: BACK_SPACE!");
    }

    @Test
    public void testSpecialKey() {
        KeyPressesPage keyPressesPage = homePage.clickKeyPressesLink();
        keyPressesPage.enterSpecial();
        assertEquals(keyPressesPage.getResultText(), "You entered: 4");
    }
}
