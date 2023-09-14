package base;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;



public class BaseTests {
    private WebDriver driver;
    protected HomePage  homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        // getChromeOptions() is passed in for the ChromeOptions class - see down below)
        driver = new ChromeDriver(getChromeOptions());
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        goHome();

        homePage = new HomePage(driver);
    }
    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            // we need to cast the driver to a different selenium class (TakesScreenshot)
            var camera = (TakesScreenshot)driver;
            // saving the screenshot as file using the java io package
            // getScreenshotAs takes Output type
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            // FileUtils comes from org.apache.commons.io.FileUtils see dependency in pom
            FileUtils.copyFile(screenshot,new File("resources/screenshots/failed_" + result.getName() + ".png"));
            // Print out the path of screenshot
            System.out.println("Screenshot taken");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    // a method to pass the driver to the WindowManager object → see comment in NavigationTests.java
    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    // ChromeOptions class can be used to make changes to the Chrome browser (itself) used for automated test
    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        // The argument "disable-infobars" will get rid of the "im controlled by automated software" banner
        options.addArguments("disable-infobars");
        // This will run the test without actually opening the browser
        options.addArguments("--headless=new");
        return options;
    }
}
