package utils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Set;

public class WindowManager {

    private WebDriver driver;

    // create Navigation object and assign it to navigate
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack() {

        // driver.navigate().back(); → as we would have to repeat driver.navigate() for every navigation method
        // we instantiate the Navigation object via the constructor (see above)

        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void refreshPage() {
        navigate.refresh();
    }

    public void goTo(String url) {
        navigate.to(url);
    }

    // Method takes name of a tab we want to switch to
    public void switchToTabWithTitle(String tabTitle) {
        // getWindowHandles will return us handles to all of the open windows/tabs
        Set<String> windows = driver.getWindowHandles();

        System.out.println("Number of tabs: " + windows.size());
        // as windows is a set of Strings (handles are unique identifier) we can println forEach
        windows.forEach(System.out::println);

        for (String window : windows) {
            System.out.println("Switching to window: " + window);
            // we know switchTo() from the FramesPage object
            // we can also switch to windows/tabs with .window(String s)
            // for the String we provide the handle we want to switch to
            driver.switchTo().window(window);

            // we can get the title of the current window/tab with .getTitle()
            System.out.println("Current window title: " + driver.getTitle());

            // if the tabTitle we want fits the current getTitle - break out
            if (tabTitle.equals(driver.getTitle())) {
                break;
            }
        }
    }

    public void switchToSecondTab() {
        // Creates an array list with the handles of the open windows
        // and switches to the windows with the handle at index 1 (second)
        // asserts might be error prone when some other tabs are open for what ever reason
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    // the method iterates through all elements (handles of present windows/tabs)
    // and executes driver.switchTo().window(passing each handle once at a time)
    // ending with the last handle - leaving the last (newest) tab open
    public void switchToNewTab() {
        Set<String> tabs = driver.getWindowHandles();
        tabs.forEach(driver.switchTo()::window);
    }

}
