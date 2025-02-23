package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {
    public WebDriver driver;

    @Test
    public void automationMethod () {

        //dechidem un browser de Chrome
        driver = new ChromeDriver();

        // accesam o pagina web
        driver.get("https://demoqa.com/");

        // facem browserul in modul maximize
        driver.manage().window().maximize();

        // facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,400)");


        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameWindowElement.click();


        WebElement frameElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        frameElement.click();

        // frame1
        WebElement frame1Element = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1Element);

        //get text from new window
        WebElement sampleHeadingFrameElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("textul din new frame este: "+sampleHeadingFrameElement.getText());

        // ne ducem cu focusul inapoi pe pagina principala
        driver.switchTo().defaultContent();

        // frame 2
        WebElement frame2Element = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frame2Element);

        // scroll from iframe2
        js.executeScript("window.scrollBy(200,200)");

    }
}
