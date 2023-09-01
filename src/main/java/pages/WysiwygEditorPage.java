package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WysiwygEditorPage {

    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By increaseIndentButton = By.xpath("//button[@title='Increase indent']");
    private By editorIframeBody = By.id("tinymce");

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * made private because the actual test should have to worry about switching iframes
     */
    private void switchToEditArea() {
        driver.switchTo().frame(editorIframeId);
    }

    public void clearText() {
        switchToEditArea();
        driver.findElement(editorIframeBody).clear();
        switchToMainArea();
    }

    public void setText(String text) {
        switchToEditArea();
        driver.findElement(editorIframeBody).sendKeys(text);
        switchToMainArea();
    }

    public String getText() {
        switchToEditArea();
        String text = driver.findElement(editorIframeBody).getText();
        switchToMainArea();
        return text;
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }

    public void clickIncreaseIndentButton() {
        driver.findElement(increaseIndentButton).click();
    }

}
