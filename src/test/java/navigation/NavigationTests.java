package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator () {
        homePage.clickDynamicLoadingLink().clickExample1();
        // So WindowManager takes a driver but the driver isn't passed along the way it is within the Page Objects
        // e.g.
        /*    public InfiniteScrollPage clickInfiniteScrollLink() {
                clickLink("Infinite Scroll");
                return new InfiniteScrollPage(driver);
              }
        */
        // But as the class extends BaseTests (which has access to the driver) we can get it from there
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void testSwitchTab() {
       homePage.clickMultipleWindowsLink().clickClickHereLink();
       getWindowManager().switchToTabWithTitle("New Window");
    }
}
