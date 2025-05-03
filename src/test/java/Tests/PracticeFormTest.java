package Tests;

import HelperMethods.ElementsMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest {

    public WebDriver driver;
    public ElementsMethods elementsMethods;

    @Test
    public void automationMethod (){

        //dechidem un browser de Chrome
        driver = new ChromeDriver();

        // accesam o pagina web
        driver.get("https://demoqa.com/");

        // facem browserul in modul maximize
        driver.manage().window().maximize();

        //
        elementsMethods = new ElementsMethods(driver);

        // facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,400)");

        // declaram un element
        WebElement FormField = driver.findElement(By.xpath("//h5[text()='Forms']"));
        // FormField.click();
        elementsMethods.clickOnElements(FormField);

        // declaram un element
        WebElement PracticeFormField = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        // PracticeFormField.click();
        elementsMethods.clickOnElements(PracticeFormField);

        // completam un fieldul firstName cu o valoare
        WebElement FirstNameField = driver.findElement(By.id("firstName"));
        //String firstNameValue ="Alexandru";
        //FirstNameField.sendKeys(firstNameValue);
        elementsMethods.fillElement(FirstNameField,"Alexandru");

        // completam un fieldul lastName cu o valoare
        WebElement LastNameField = driver.findElement(By.id("lastName"));
        // String lastNameValue ="Popescu";
        // LastNameField.sendKeys(lastNameValue);
        elementsMethods.fillElement(LastNameField,"Popescu");

        // completam un fieldul email cu o valoare
        WebElement EmailField = driver.findElement(By.id("userEmail"));
//        String emailValue ="alexandru.popescu@yahoo.com";
//        EmailField.sendKeys(emailValue);
        elementsMethods.fillElement(EmailField,"alexandru.popescu@yahoo.com");

        // completam fieldul radio button Gender
        WebElement maleField = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleField = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherField = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        List<WebElement> genderElement = new ArrayList<>();
        genderElement.add(maleField);
        genderElement.add(femaleField);
        genderElement.add(otherField);
        elementsMethods.selectElementFromListByText(genderElement,"Male");

//        String genderValue = "Male";
//
//        if (maleField.getText().equals(genderValue)){
//            maleField.click();
//        } else if (femaleField.getText().equals(genderValue)) {
//            femaleField.click();
//        }
//        else if (otherField.getText().equals(genderValue)){
//            otherField.click();
//        }


        // completam un fieldul mobile number cu o valoare
        WebElement MobileNumberField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
//        String MobileNumberValue ="0800123456";
//        MobileNumberField.sendKeys(MobileNumberValue);
        elementsMethods.fillElement(MobileNumberField,"0800123456");

        // completam un fieldul upload picture cu o valoare
        WebElement pictureField = driver.findElement(By.id("uploadPicture"));
//        File file = new File("src/test/resources/IDP2.png");
//        pictureField.sendKeys(file.getAbsolutePath());
        elementsMethods.uploadPicture(pictureField);

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
