package waits;

import base.BaseTests;
import com.google.errorprone.annotations.Var;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;

import static org.testng.Assert.assertEquals;

public class DynamicLoadsTests extends BaseTests {

    @Test
    public void testDynamicLoading1() {
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoadingLink();
        DynamicLoadingPage.Example1 example1 = dynamicLoadingPage.clickExample1();
        example1.clickStart();
        assertEquals(example1.getText(), "Hello World!"
                , "Incorrect text or text not present");

    }

    @Test
    public void testDynamicLoading2() {
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoadingLink();
        DynamicLoadingPage.Example2 example2 = dynamicLoadingPage.clickExample2();
        assertEquals(example2.clickStartAndGetText(), "Hello World!"
                , "Incorrect text or text not present");
    }



}
