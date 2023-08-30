package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

    private WebDriver driver;

    private By fileInputField = By.id("file-upload");

    private By fileSubmitButton = By.id("file-submit");
    private By uploadFileText = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void submitFile() {
        driver.findElement(fileSubmitButton).click();
    }

    /**
     * Provides path of file to the form then clicks upload button
     * @param absolutePathOfFile The complete path of the file to upload
     */

    public void uploadFile(String absolutePathOfFile) {
        driver.findElement(fileInputField).sendKeys(absolutePathOfFile);
        submitFile();
    }

    public String getUploadFileText() {
        return driver.findElement(uploadFileText).getText();
    }
}
