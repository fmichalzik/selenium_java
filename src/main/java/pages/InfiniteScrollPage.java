package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {

    private WebDriver driver;
    By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * Scroll until paragraph with index specified is in vie
     * @param index 1-based
     */
    public void scrollToParagraph(int index) {
        // There is a Js function scrollTo() on the window object/element
        // scrollTo() takes to int x for horizontal y for vertical
                                        //document.body.scrollHeight represents a "normal user scroll"
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        // We have to pass the driver to the JavascriptExecutor - cast
        // So we get a JavascriptExecutor object and assign it to jsExecutor var
        var jsExecutor = (JavascriptExecutor)driver;


        while(getNumberOfParagraphsPresent() < index) {
            // executeScript takes a String with the JS code
            jsExecutor.executeScript(script);
        }
    }

    // Gives us the amount of textBlocks elements
    private int getNumberOfParagraphsPresent() {
        return driver.findElements(textBlocks).size();
    }

}
