package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver driver;
    private By dropdownList = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }
    public void selectOptionFromDropdown(String option) {
        // Select dropdownElement = findDropdownElement();
        findDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptionsFromDropdown() {
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        return selectedElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    // Helper Method to find dropdownElement
    // soll nicht von Test ausgeführt werden, daher private
    private Select findDropdownElement() {
        return new Select(driver.findElement(dropdownList));
    }
}
