package fileupload;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        FileUploadPage fileUploadPage = homePage.clickFileUploadLink();
        fileUploadPage.uploadFile("C:/Users/michalzik/IdeaProjects/selenium_java/resources/chromedriver.exe");
        assertEquals(fileUploadPage.getUploadFileText(), "chromedriver.exe", "Correct file uploaded");
    }

}
