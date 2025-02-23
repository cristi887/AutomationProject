package Tests.WebElementsTestSites;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;

public class FindWebElemnts {

    public WebDriver driver;

    @Test
    public void letCode(){
        driver = new ChromeDriver();
        driver.get("https://letcode.in/forms");
        driver.manage().window().maximize();

        WebElement countryCodeDropDown = driver.findElement(By.xpath("//label[text()='Country code']/following-sibling::div[@class='control']/div[@class='select']/select"));
        countryCodeDropDown.click();
        Select selectCode = new Select(countryCodeDropDown);
        selectCode.selectByVisibleText("Brazil (+55)");
        countryCodeDropDown.click();

        WebElement countryDropDown = driver.findElement(By.xpath("//label[text()='Country']/following-sibling::div[@class='control']/div[@class='select']/select"));
        countryDropDown.click();
        Select select = new Select(countryDropDown);
        select.selectByVisibleText("Brazil");
        countryDropDown.click();

    }


}
