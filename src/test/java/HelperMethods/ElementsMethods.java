package HelperMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ElementsMethods {

    WebDriver driver;
    Actions action;

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);

    }

    public void clickOnElements(WebElement element){
        element.click();
    }

    public void fillElement(WebElement element, String value){
        element.sendKeys(value);
    }

    public void uploadPicture(WebElement element){
        File file = new File("src/test/resources/IDP2.png");
        element.sendKeys(file.getAbsolutePath());
    }

//    public void selectElementFromListByText(List<WebElement> elementsList, String value){
//        for (int i = 0; i < elementsList.size(); i++){
//            if (elementsList.get(i).getText().equals(value)){
//                clickOnElements(elementsList.get(i));
//            }
//        }
//    }

    public void selectElementFromListByText(List<WebElement> elementsList, String value){
        for (WebElement element: elementsList){
            if (element != null && element.isDisplayed() && element.getText().equals(value)){
                clickOnElements(element);
                break;
            }
        }
    }

    public void displayContentOfElement(WebElement element){
        String text = element.getText();
        System.out.println("textul din new frame este: "+text);
    }

    public void fillwithActions(WebElement webElement,String value){
        action.sendKeys(value).perform();
        waitVisibilityElement(webElement);
        action.sendKeys(Keys.ENTER).perform();
    }

    public void waitVisibilityElement(WebElement webElement){
        //definim un wait explicit sa astepte dupa element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void fillMultippleValues(WebElement webElement,List<String> list){
        for(String value:list){
            webElement.sendKeys(value);
            webElement.sendKeys(Keys.ENTER);
        }
    }

    public void clickMultipleValues(List<WebElement> webElements,List<String> list){
        for(String value:list){
            for (WebElement webElement:webElements){
                //verificam daca textul de pe element
                if (webElement.getText().equals(value)){
                    webElement.click();
                }
            }

        }
    }

}
