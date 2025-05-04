package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;

import java.time.Duration;

public class AlertTest {
    public WebDriver driver;
    public ElementsMethods elementsMethods;
    public AlertMethods alertMethods;
    public JavascriptHelpers js;
    public HomePage homePage;
    public CommonPage commonPage;

    @Test
    public void automationMethod (){

        //dechidem un browser de Chrome
        driver = new ChromeDriver();

        // accesam o pagina web
        driver.get("https://demoqa.com/");

        // definim un wait implicit pt. un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // facem browserul in modul maximize
        driver.manage().window().maximize();

        //
        elementsMethods = new ElementsMethods(driver);
        alertMethods = new AlertMethods(driver);
        js = new JavascriptHelpers(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

        // facem un scroll
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        // scroll down till the bottom of the page
       // js.executeScript("window.scrollBy(0,400)");
//        js.scrollDown(400);
//
//        // declaram un element
//        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        // alertFrameWindowElement.click();
//        elementsMethods.clickOnElements(alertFrameWindowElement);
        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        // declaram un element
//        WebElement alertElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
//        //alertElement.click();
//        elementsMethods.clickOnElements(alertElement);
        commonPage.goToDesiredSubMenu("Alerts");

        //primul alert
        WebElement alertOkElement = driver.findElement(By.id("alertButton"));
        //alertOkElement.click();
        elementsMethods.clickOnElements(alertOkElement);

        // ne mutam cu focusul pe alerta
//        Alert alertOk=driver.switchTo().alert();
//        alertOk.accept();
        alertMethods.interractWithAlertsOK();

        //al 2-lea alert
        WebElement alertDelayOkElement = driver.findElement(By.id("timerAlertButton"));
        //alertDelayOkElement.click();
        elementsMethods.clickOnElements(alertDelayOkElement);

        // definim un wait explicit ca sa astepte dupa alerta
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
        // ne mutam cu focusul pe alerta
//        Alert alertDelayOk=driver.switchTo().alert();
//        alertDelayOk.accept();

        alertMethods.interractWithDelayAlert();

        //al 3-lea alert
        WebElement alertConfirmElement = driver.findElement(By.id("confirmButton"));
        //alertConfirmElement.click();
        elementsMethods.clickOnElements(alertConfirmElement);

        Alert alertConfirm=driver.switchTo().alert();
        alertConfirm.dismiss();

        //al 4-lea alert
        WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
        //alertPromptElement.click();
        elementsMethods.clickOnElements(alertPromptElement);

        Alert alertPrompt=driver.switchTo().alert();
        alertPrompt.sendKeys("text from alert");
        alertPrompt.accept();

    }
}
