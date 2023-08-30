package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage {

    private WebDriver driver;
    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }

    private By successfulLoginMessage = By.id("flash");

    public String getMessageText() {
       return driver.findElement(successfulLoginMessage).getText();
    }
}
