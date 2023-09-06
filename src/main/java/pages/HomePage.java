package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // private By formAuthenticationLink = By.linkText("Form Authentication");
    // private By dropdownLink = By.linkText("Dropdown");

    public LoginPage clickFormAuthenticationLink() {
        // driver.findElement(formAuthenticationLink).click();
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropdownLink() {
       // driver.findElement(dropdownLink).click();
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public ForgotPasswordPage clickForgotPasswordLink() {
        clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }

    public HoversPage clickHoversLink() {
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSliderLink() {
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public KeyPressesPage clickKeyPressesLink() {
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public AlertsPage clickAlertPageLink() {
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public FileUploadPage clickFileUploadLink() {
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public ContextMenuPage clickContextMenuLink() {
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public WysiwygEditorPage clickWysiwygEditorLink() {
        clickLink("WYSIWYG Editor");
        return new WysiwygEditorPage(driver);
    }

    public FramesPage clickFramesLink() {
        clickLink("Frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoadingLink() {
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeAndDeepDomPage clickLargeAndDeepDom() {
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }

    public InfiniteScrollPage clickInfiniteScrollLink() {
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindowsLink() {
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }

    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

}
