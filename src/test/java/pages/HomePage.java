package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.TestRunner;

public class HomePage extends TestRunner {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id = "nav-search-submit-text")
    public WebElement submitButton;

    public void productSearch(String productName) {
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(productName);
        submitButton.click();
    }
}