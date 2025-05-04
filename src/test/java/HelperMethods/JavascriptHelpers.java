package HelperMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavascriptHelpers {
    WebDriver driver;
    JavascriptExecutor js;

    public JavascriptHelpers(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }
    public void scroll(int x, int y){
        //facem un scroll ca sa fie elementul vizibil in caz ca nu incape pe pagina
        //JavascriptExecutor ajuta atunci cand metodele standard din selenium nu ajuta

        // scroll down till the bottom of the page
        js.executeScript("window.scrollBy("+ x +","+ y +")");
    }

    public void scrollDown(int y){
        scroll(0,y);
    }

    public void scrollRight(int x){
        scroll(x,0);
    }

    public void forceClick(WebElement element){
        //cand nu poti face click pe un element (ex. o reclama se suprapune)
        //JavascriptExecutor iti permite sa faci acest lucru
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));
        js.executeScript("arguments[0].click();",element);
    }
}
