package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By slider = By.cssSelector("input");
    private By value = By.id("range");
    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSlider(int amountOfKeystrokes) {
        for (int i = 1; i <= amountOfKeystrokes; i++ ) {
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getValue() {
       return driver.findElement(value).getText();
    }
}
