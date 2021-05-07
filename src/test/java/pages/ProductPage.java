package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.TestRunner;

import java.util.List;

import static testSteps.RunDefaults.sleepSeconds;

public class ProductPage extends TestRunner {

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(className = "span=\"a-button-input\"")
    public List<WebElement> toastContainerElements;


    @FindBy(xpath = "//h1[@class='a-size-medium a-text-bold']")
    public WebElement cartMessage;


    public void addToCart() {
        addToCartButton.click();
    }

        public void popupWindowClose() {
            String noThanks = "No thanks";
        for (WebElement element : toastContainerElements) {
            if (noThanks.equalsIgnoreCase(element.getText().trim())) ;
            sleepSeconds(1);
            element.click();
        }
    }

        public boolean popupIsPresented() {
            boolean presented = false;
            String noThanks = "No thanks";
            for (WebElement element : toastContainerElements) {
                if (noThanks.equalsIgnoreCase(element.getText().trim())) {
                    presented = true;
                } else {
                    presented = false;
                }
            }
            return presented;
        }


    public String cartMessageConfirmation() {
        return cartMessage.getText();
    }

}

