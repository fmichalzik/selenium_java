package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesPage {

    private WebDriver driver;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public NestedFramesPage goToNestedFramePage() {
        driver.findElement(By.linkText("Nested Frames")).click();
        return new NestedFramesPage(driver);
    }

    public class NestedFramesPage {
        private WebDriver driver;
        private WebDriver frameDriver;
        private By bodyText = By.cssSelector("body");

        private String topFrame = "frame-top";
        private String middleFrameSet = "frameset-middle";
        private String leftFrame = "frame-left";
        private String bottomFrame = "frame-bottom";


        public NestedFramesPage(WebDriver driver) {
            this.driver = driver;
        }

        private void switchTopFrame() {
            driver.switchTo().frame(topFrame);
        }
        private void switchLeftFrame() {
            switchTopFrame();
            driver.switchTo().frame(leftFrame);
        }

        private void switchBottomFrame() {
            driver.switchTo().frame(bottomFrame);
        }

        private void switchToFrameSet() {
            switchTopFrame();
            driver.switchTo().frame(middleFrameSet);
        }

        private void switchToMainArea() {
            driver.switchTo().parentFrame();
        }

        public String getTextFromLeftFrameBody() {
            switchLeftFrame();
            String text = driver.findElement(bodyText).getText();
            switchToMainArea();
            switchToMainArea();
            return text;
        }

        public String getTextFromBottomFrameBody() {
            switchBottomFrame();
            String text = driver.findElement(bodyText).getText();
            switchToMainArea();
            return text;
        }

    }

}
