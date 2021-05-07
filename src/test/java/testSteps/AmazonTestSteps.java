package testSteps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.ProductSearchPage;
import runner.TestRunner;

import static testSteps.RunDefaults.sleepSeconds;

public class AmazonTestSteps extends TestRunner {

    private static Logger logger = LoggerFactory.getLogger(AmazonTestSteps.class);

    private HomePage homePage;
    private ProductSearchPage productSearchPage;
    private ProductPage productPage;
    private static String url = RunDefaults.setProperties("url");
    private static String product = RunDefaults.setProperties("product");
    private static String expectedMessage = RunDefaults.setProperties("cartConfirmation");

    @Test
    public void amazon() {
        homePage = new HomePage(driver);
        productSearchPage = new ProductSearchPage(driver);
        productPage = new ProductPage(driver);

        driver.navigate().to(url);
        logger.info("Navigating to {}", url);
        sleepSeconds(1);

        homePage.productSearch(product);
        logger.info("Entering {} product to search", product);
        sleepSeconds(1);

        productSearchPage.navigateToSecondPage();
        logger.info("Navigating to second page");
        sleepSeconds(1);

        productSearchPage.selectProduct(3);
        logger.info("Selecting third product from the list");
        sleepSeconds(1);


        try {
            productPage.addToCart();
            logger.info("Adding product to Cart");
            sleepSeconds(1);
            try {
                if(productPage.popupIsPresented())
                    productPage.popupWindowClose();
                sleepSeconds(1);
            } catch (Exception e) {
                logger.info("No interruption window");
            }
            Assert.assertEquals(productPage.cartMessageConfirmation().trim(), expectedMessage);
            logger.info("Product added to cart");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
