package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {
    private WebDriver driver;
    private By largeTable = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToTable() {
        WebElement tableElement = driver.findElement(largeTable);
        // We have to pass the driver to the JavascriptExecutor - cast
        // So we get a JavascriptExecutor object
                    // executeScript takes a String with the JS code
                    // We cannot use the WebElement in the String itself (we want tableElement.scrollIntoView()
                    // so arguments[] works as a placeholder and scrollIntoView() function call to the js function
                    String script = "arguments[0].scrollIntoView()";
                                                // pass in tableElement object for arguments[0]
        ((JavascriptExecutor)driver).executeScript(script, tableElement);
    }
}
