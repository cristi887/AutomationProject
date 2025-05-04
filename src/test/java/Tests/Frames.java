package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;

public class Frames {
    public WebDriver driver;
    public JavascriptHelpers js;
    public ElementsMethods elementsMethods;
    public FramesMethods framesMethods;
    public HomePage homePage;
    public CommonPage commonPage;

    @Test
    public void automationMethod () {

        //dechidem un browser de Chrome
        driver = new ChromeDriver();

        // accesam o pagina web
        driver.get("https://demoqa.com/");

        // facem browserul in modul maximize
        driver.manage().window().maximize();

        //
        js = new JavascriptHelpers(driver);
        elementsMethods = new ElementsMethods(driver);
        framesMethods = new FramesMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

        // facem un scroll
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        // scroll down till the bottom of the page
        //js.executeScript("window.scrollBy(0,400)");
        js.scrollDown(400);


//        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        //alertFrameWindowElement.click();
//        elementsMethods.clickOnElements(alertFrameWindowElement);
        homePage.goToDesiredMenu("Alerts, Frame & Windows");


//        WebElement frameElement = driver.findElement(By.xpath("//span[text()='Frames']"));
//        //frameElement.click();
//        elementsMethods.clickOnElements(frameElement);
//       // js.scrollDown(400);
        commonPage.goToDesiredSubMenu("Frames");

        js.scrollDown(400);

        // frame1
        WebElement frame1Element = driver.findElement(By.id("frame1"));
        //driver.switchTo().frame(frame1Element);
        framesMethods.switchToFrame(frame1Element);

        //get text from new window
        WebElement sampleHeadingFrame1Element = driver.findElement(By.id("sampleHeading"));
       // System.out.println("textul din new frame este: "+sampleHeadingFrameElement.getText());
        elementsMethods.displayContentOfElement(sampleHeadingFrame1Element);

        // ne ducem cu focusul inapoi pe pagina principala
        //driver.switchTo().defaultContent();
        framesMethods.switchToMainFrame();

        // frame 2
        WebElement frame2Element = driver.findElement(By.id("frame2"));
        //driver.switchTo().frame(frame2Element);
        framesMethods.switchToFrame(frame2Element);

        // scroll from iframe2
        // Thread.sleep(2000);
        //driver.quit();
        //js.executeScript("window.scrollBy(200,200)");
        js.scroll(50,50);

    }
}
