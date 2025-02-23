package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowTab {
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


        WebElement browserWindowsElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        browserWindowsElement.click();

        //primul buton
        WebElement tabElement = driver.findElement(By.id("tabButton"));
        tabElement.click();

        // getWindowHandles returneaza toate windowsurile deschise
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));


        //get text from new tab
        WebElement sampleHeadingElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("textul din new tab este: "+sampleHeadingElement.getText());

        // inchidem noul tab
        driver.close();

        //revenim la window-ul initial
        driver.switchTo().window(tabList.get(0));

        // al 2-lea buton
        WebElement windowButtonElement = driver.findElement(By.id("windowButton"));
        windowButtonElement.click();

        //mutam focusul pe noul window
        // getWindowHandles returneaza toate windowsurile deschise
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        //get text from new window
        WebElement sampleHeadingWindowElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("textul din new window este: "+sampleHeadingWindowElement.getText());

        driver.close();
        //revenim la window-ul initial
        driver.switchTo().window(windowList.get(0));

    }

}
