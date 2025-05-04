package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptHelpers js;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.js = new JavascriptHelpers(driver);
        PageFactory.initElements(driver,this);
    }

    // identificam webelement-ele specifice pt. pagina
//    @FindBy(xpath = "//h5")
//    List<WebElement> elements;

    // facem metode specifice pt. pagina
    public void goToDesiredMenu(String menu) {

        js.scrollDown(400);
        List<WebElement> menuItems = driver.findElements(By.xpath("//h5"));
        elementsMethods.selectElementFromListByText(menuItems,menu);
    }

}
