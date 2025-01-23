package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void automationMethod (){

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

        // declaram un element
        WebElement ElementsField = driver.findElement(By.xpath("//h5[text()='Elements']"));
        ElementsField.click();

        // declaram un element
        WebElement WebTableField = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        WebTableField.click();

        WebElement AddButtonField = driver.findElement(By.id("addNewRecordButton"));
        AddButtonField.click();

        // completam un fieldul firstName cu o valoare
        WebElement FirstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue ="Dorel";
        FirstNameField.sendKeys(firstNameValue);

        // completam un fieldul lastName cu o valoare
        WebElement LastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue ="Baciu";
        LastNameField.sendKeys(lastNameValue);

        // completam un fieldul email cu o valoare
        WebElement EmailField = driver.findElement(By.id("userEmail"));
        String emailValue ="baciu.dorel@yahoo.com";
        EmailField.sendKeys(emailValue);

        // completam un fieldul age cu o valoare
        WebElement AgeField = driver.findElement(By.id("age"));
        String ageValue ="37";
        AgeField.sendKeys(ageValue);

        // completam un fieldul salary cu o valoare
        WebElement SalaryField = driver.findElement(By.id("salary"));
        String salaryValue ="2800";
        SalaryField.sendKeys(salaryValue);

        // completam un fieldul department cu o valoare
        WebElement DepartmentField = driver.findElement(By.id("department"));
        String departmentValue ="testing";
        DepartmentField.sendKeys(departmentValue);

        WebElement SubmitButtonField = driver.findElement(By.id("submit"));
        SubmitButtonField.click();

        //inchidem browserul
        driver.quit();
    }

}
