package pages;

import HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage {

WebDriver driver;
ElementsMethods elementsMethods;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);

        //asta e partea de driver.findElement
        PageFactory.initElements(driver,this);
    }

@FindBy(id = "fisrtName")
    WebElement FirstNameField;

@FindBy(id = "lastName")
    WebElement LastNameField;

@FindBy(id = "userEmail")
    WebElement EmailField;

@FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleField;

@FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleField;

@FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherField;

@FindBy(css = "input[placeholder='Mobile Number']")
    WebElement MobileNumberField;

@FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement SportsField;

@FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement ReadingField;

@FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement MusicField;

@FindBy(id = "uploadPicture")
    WebElement pictureField;

//@FindBy(xpath = "//div[@id='subjectsContainer']")
//    WebElement SubjectField;
@FindBy(id = "subjectsContainer")
WebElement SubjectField;

@FindBy(id = "currentAddress")
    WebElement addressField;

@FindBy(id = "react-select-3-input")
    WebElement StateField;

@FindBy(id = "react-select-4-input")
    WebElement CityField;

public void completeFirstRegion(String firstName,String lastName, String email,String address,String mobileNumber){
    elementsMethods.fillElement(FirstNameField,firstName);
    elementsMethods.fillElement(LastNameField,lastName);
    elementsMethods.fillElement(EmailField,email);
    elementsMethods.fillElement(addressField,address);
    elementsMethods.fillElement(MobileNumberField,mobileNumber);

}

public void completeGender(String gender){
    switch (gender){
        case "Male":
            elementsMethods.clickOnElements(maleField);
            break;
        case "Female":
            elementsMethods.clickOnElements(femaleField);
            break;
        case "Other":
            elementsMethods.clickOnElements(otherField);
            break;
    }
}

public void completeSubject(String subject){
    elementsMethods.clickOnElements(SubjectField);
    elementsMethods.fillwithActions(SubjectField,subject);
}

public void completeSubjectWithList(List<String> list){
    elementsMethods.clickOnElements(SubjectField);
    elementsMethods.fillMultippleValues(SubjectField,list);
}

public void completeHobies(List<String> hobies){
    List<WebElement> hobiesElement = new ArrayList<>();
    hobiesElement.add(SportsField);
    hobiesElement.add(ReadingField);
    hobiesElement.add(MusicField);
    elementsMethods.clickMultipleValues(hobiesElement,hobies);
}

}
