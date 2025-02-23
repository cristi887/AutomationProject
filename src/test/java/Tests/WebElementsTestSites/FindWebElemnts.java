package Tests.WebElementsTestSites;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.time.Duration;

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
    @Test
    public void airBnb(){
        driver = new ChromeDriver();
        driver.get("https://www.airbnb.ie/");
        driver.manage().window().maximize();

    }
    public void chooseFromMainMenu(String subMenu, String pageTitle){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement menuButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='category-item--Tropical--checked']")));
        menuButton.click();
        WebElement subMenuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//div[contains(text(), '" + subMenu + "')]")));
        subMenuElement.click();
        WebElement pageHeader = driver.findElement(By.xpath("//h1[@data-element-name='title']"));
        Assert.assertEquals(pageHeader.getText(),pageTitle);
    }

    @Test
    public void barnesAndNobles(){
        driver = new ChromeDriver();
        driver.get("https://www.barnesandnoble.com/");
        driver.manage().window().maximize();

        WebElement subMenu = driver.findElement(By.xpath("//a[text()='Nonfiction']/parent::li"));
        Actions actions = new Actions(driver);
        actions.moveToElement(subMenu).pause(500).perform();

        WebElement siblingElement = driver.findElement(By.xpath("//a[text()='Nonfiction']/following-sibling::div"));
        Assert.assertTrue(siblingElement.isDisplayed());
        actions.moveToElement(siblingElement).pause(500).click().perform();
        Assert.assertTrue(driver.getTitle().contains("Nonfiction"));
    }

}
