package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage {

    private WebDriver driver;
    private By example1Link = By.xpath("//a[@href='/dynamic_loading/1']");
    private By example2Link = By.xpath("//a[@href='/dynamic_loading/2']");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public Example1 clickExample1() {
        driver.findElement(example1Link).click();
        return new Example1(driver);
    }

    public Example2 clickExample2() {
        driver.findElement(example2Link).click();
        return new Example2(driver);
    }

    public class Example1 {
        private WebDriver driver;

        private By startButton = By.cssSelector("button");
        private By loadingIndicator = By.id("loading");
        private By text = By.cssSelector("#finish h4");

        public Example1(WebDriver driver) {
            this.driver = driver;
        }

        public void clickStart() {
            driver.findElement(startButton).click();
/*            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));*/

            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
        }
        public String getText() {
            return driver.findElement(text).getText();
        }

    }

    public class Example2 {
        private WebDriver driver;
        private By startButton = By.cssSelector("button");

        private By text = By.cssSelector("#finish h4");

        public String clickStartAndGetText() {
            driver.findElement(startButton).click();
            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.presenceOfElementLocated(text));
            return driver.findElement(text).getText();
        }

        public Example2(WebDriver driver) {
            this.driver = driver;
        }
    }


}
