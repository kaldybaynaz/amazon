package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.TestRunner;

import java.util.List;

public class ProductSearchPage extends TestRunner {

    public ProductSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class=\"a-normal\"][1]")
    public WebElement secondPage;

    @FindBy(xpath = "//a[@class=\"a-link-normal a-text-normal\"]")
    public List<WebElement> listOfProducts;

    public void navigateToSecondPage() {
        secondPage.click();
    }

    public void selectProduct(int productNumber) {
        listOfProducts.get(productNumber - 1).click();
    }
}