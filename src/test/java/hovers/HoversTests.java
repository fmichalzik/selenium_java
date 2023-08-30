package hovers;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HoversPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoversTests extends BaseTests {

    @Test
    public void testHoverUser1() {
        HoversPage hoversPage = homePage.clickHoversLink();
        HoversPage.FigureCaption figureCaption = hoversPage.hoverOverFigure(1);
        assertTrue(figureCaption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals( figureCaption.getTitle(), "name: user1", "Caption title incorrect");
        assertEquals(figureCaption.getLinkText(), "View profile", "Caption link text incorrect");
        assertTrue(figureCaption.getLink().endsWith("/users/1"), "Link incorrect");

    }
}
