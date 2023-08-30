package contextactions;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

import static org.testng.Assert.assertEquals;

public class ContextActionsTests extends BaseTests {

    @Test
    public void testContextAction() {
        ContextMenuPage contextMenuPage = homePage.clickContextMenuLink();
        contextMenuPage.rightClickOnBox();
        String alertText = contextMenuPage.alert_getText();
        contextMenuPage.alert_clickToAccept();
        assertEquals(alertText, "You selected a context menu", "Incorect or not text");
    }

}
