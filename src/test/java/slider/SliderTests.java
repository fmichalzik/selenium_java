package slider;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

import static org.testng.Assert.assertEquals;

public class SliderTests extends BaseTests {

    @Test
    public void testSlider() {
        HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSliderLink();
        horizontalSliderPage.setSlider(8);
        assertEquals(horizontalSliderPage.getValue(), "4");
    }
}
