package frames;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.WysiwygEditorPage;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg() {
        WysiwygEditorPage wysiwygEditorPage =homePage.clickWysiwygEditorLink();
        wysiwygEditorPage.clearText();

        String text1 = "hello";
        String text2 = "world";

        wysiwygEditorPage.setText(text1);
        wysiwygEditorPage.clickIncreaseIndentButton();
        wysiwygEditorPage.setText(text2);

        assertEquals(wysiwygEditorPage.getText(), text1+text2, "Text incorrect or not present");
    }

    @Test
    public void testFrames() {
        FramesPage framesPage = homePage.clickFramesLink();
        FramesPage.NestedFramesPage nestedFramesPage = framesPage.goToNestedFramePage();

        String leftFrameText = nestedFramesPage.getTextFromLeftFrameBody();
        String bottomFrameText = nestedFramesPage.getTextFromBottomFrameBody();

        assertEquals(leftFrameText, "LEFT", "Incorrect or not present");
        assertEquals(bottomFrameText, "BOTTOM", "Incorrect or not present");

    }
}
