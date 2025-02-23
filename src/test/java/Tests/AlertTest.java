package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {
    public WebDriver driver;

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

        // facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,400)");

        // declaram un element
        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameWindowElement.click();

        // declaram un element
        WebElement alertElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertElement.click();

        //primul alert
        WebElement alertOkElement = driver.findElement(By.id("alertButton"));
        alertOkElement.click();

        // ne mutam cu focusul pe alerta
        Alert alertOk=driver.switchTo().alert();

        alertOk.accept();

        //al 2-lea alert
        WebElement alertDelayOkElement = driver.findElement(By.id("timerAlertButton"));
        alertDelayOkElement.click();

        // definim un wait explicit ca sa astepte dupa alerta
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        // ne mutam cu focusul pe alerta
        Alert alertDelayOk=driver.switchTo().alert();

        alertDelayOk.accept();

        //al 3-lea alert
        WebElement alertConfirmElement = driver.findElement(By.id("confirmButton"));
        alertConfirmElement.click();

        Alert alertConfirm=driver.switchTo().alert();
        alertConfirm.dismiss();

        //al 4-lea alert
        WebElement alertPromptElement = driver.findElement(By.id("promptButton"));
        alertPromptElement.click();

        Alert alertPrompt=driver.switchTo().alert();
        alertPrompt.sendKeys("text from alert");
        alertPrompt.accept();

    }
}
