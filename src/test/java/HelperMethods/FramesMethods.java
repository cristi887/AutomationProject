package HelperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesMethods {
    WebDriver driver;

    public FramesMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame(WebElement element){
        //schimbam focusul pe un anume frame
        driver.switchTo().frame(element);
    }

    public void switchToMainFrame(){
        //mutam focusul inapoi pe pagina principala
        driver.switchTo().defaultContent();
    }

}
