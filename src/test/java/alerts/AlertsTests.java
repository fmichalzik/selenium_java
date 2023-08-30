package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AlertsPage;

import static org.testng.Assert.assertEquals;

public class AlertsTests extends BaseTests {

    @Test
    public void testJsAlert() {
        AlertsPage alertsPage = homePage.clickAlertPageLink();
        alertsPage.clickJsAlertButton();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),"You successfully clicked an alert", "Not the expected result");
    }

    @Test
    public void testJsConfirmAccept() {
        AlertsPage alertsPage = homePage.clickAlertPageLink();
        alertsPage.clickJsConfirmButton();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),"You clicked: Ok", "Not the expected result");
    }

    @Test
    public void testJsConfirmDismiss() {
        AlertsPage alertsPage = homePage.clickAlertPageLink();
        alertsPage.clickJsConfirmButton();
        assertEquals(alertsPage.alert_getText(),"I am a JS Confirm", "Not the expected result");
        alertsPage.alert_clickToDismiss();
        assertEquals(alertsPage.getResult(),"You clicked: Cancel", "Not the expected result");
    }

    @Test
    public void testJsPromptConfirm() {
        AlertsPage alertsPage = homePage.clickAlertPageLink();
        alertsPage.clickJsPromptButton();
        alertsPage.alert_sendKeys("I'm the greatest!");
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),"You entered: I'm the greatest!", "Not the expected result");
    }

}
