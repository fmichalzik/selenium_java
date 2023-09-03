package javascript;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import pages.InfiniteScrollPage;
import pages.LargeAndDeepDomPage;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable() {
         LargeAndDeepDomPage largeAndDeepDomPage = homePage.clickLargeAndDeepDom();
         largeAndDeepDomPage.scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph() {
        InfiniteScrollPage infiniteScrollPage = homePage.clickInfiniteScrollLink();
        infiniteScrollPage.scrollToParagraph(5);
    }
}
