package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {
    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptHelpers js;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.js = new JavascriptHelpers(driver);
        PageFactory.initElements(driver,this);
    }

    // identificam webelement-ele specifice pt. subpagina
    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> elements;

    // facem metode specifice pt. pagina
    public void goToDesiredSubMenu(String submenu) {
        js.scrollDown(400);
        elementsMethods.selectElementFromListByText(elements,submenu);
    }

}
