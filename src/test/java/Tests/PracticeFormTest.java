package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeFormTest {

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
        WebElement FormField = driver.findElement(By.xpath("//h5[text()='Forms']"));
        FormField.click();

        // declaram un element
        WebElement PracticeFormField = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        PracticeFormField.click();

        // completam un fieldul firstName cu o valoare
        WebElement FirstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue ="Alexandru";
        FirstNameField.sendKeys(firstNameValue);

        // completam un fieldul lastName cu o valoare
        WebElement LastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue ="Popescu";
        LastNameField.sendKeys(lastNameValue);

        // completam un fieldul email cu o valoare
        WebElement EmailField = driver.findElement(By.id("userEmail"));
        String emailValue ="alexandru.popescu@yahoo.com";
        EmailField.sendKeys(emailValue);

        // completam fieldul radio button Gender
        WebElement maleField = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleField = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherField = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String genderValue = "Male";

        if (maleField.getText().equals(genderValue)){
            maleField.click();
        } else if (femaleField.getText().equals(genderValue)) {
            femaleField.click();
        }
        else if (otherField.getText().equals(genderValue)){
            otherField.click();
        }


        // completam un fieldul mobile number cu o valoare
        WebElement MobileNumberField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String MobileNumberValue ="0800123456";
        MobileNumberField.sendKeys(MobileNumberValue);

        // completam un fieldul upload picture cu o valoare
        WebElement pictureField = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/IDP2.png");
        pictureField.sendKeys(file.getAbsolutePath());

        // completam un fieldul Subject number cu o valoare
        WebElement SubjectField = driver.findElement(By.id("subjectsInput"));
        String subjectValue ="Social Studies";
        SubjectField.sendKeys(subjectValue);
        SubjectField.sendKeys(Keys.ENTER);

        // completam un fieldul State cu o valoare
        WebElement StateField = driver.findElement(By.id("react-select-3-input"));
        js.executeScript("arguments[0].click();",StateField);
        StateField.sendKeys("NCR");
        StateField.sendKeys(Keys.ENTER);

        // completam un fieldul City cu o valoare
        WebElement CityField = driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click();",CityField);
        CityField.sendKeys("Delhi");
        CityField.sendKeys(Keys.ENTER);

    }
}
