package HelperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowsMethods {

    WebDriver driver;

    public WindowsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToOpenedTab(){
        //driver.getWindowHandles() -> returneaza toate window-urile deshise
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
    }

    public void switchToMainTab(){
        switchToMainTab();
    }

    public void switchToOpenedWindow(){
        switchToOpenedWindow();
    }

    private void close(){
        driver.close();
    }

    public void closeTab(){
        close();
    }
    public void closeWindow(){
        close();
    }
    public void switchToMainWindow(){
        switchToMain();
    }

    private void switchToMain(){
        //driver.getWindowHandles() -> returneaza toate window-urile deshise
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(0));
    }
}
