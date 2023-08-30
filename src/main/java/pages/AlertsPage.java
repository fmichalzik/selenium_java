package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver driver;
    private By result = By.id("result");

    private By triggerAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private By triggerConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath("//button[text()='Click for JS Prompt']");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickJsAlertButton() {
        driver.findElement(triggerAlertButton).click();
    }

    public void clickJsConfirmButton() {
        driver.findElement(triggerConfirmButton).click();
    }

    public void clickJsPromptButton() {
        driver.findElement(triggerPromptButton).click();
    }

    public void alert_sendKeys(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void alert_clickToAccept() {
        driver.switchTo().alert().accept();
    }

    public void alert_clickToDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public String getResult() {
        return driver.findElement(result).getText();
    }

    public String alert_getText() {
       return driver.switchTo().alert().getText();
    }
}
