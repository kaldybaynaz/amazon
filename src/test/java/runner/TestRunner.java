package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import testSteps.RunDefaults;

public class TestRunner {

    private static Logger logger = LoggerFactory.getLogger(TestRunner.class);
    private static String browser = RunDefaults.setProperties("browser");
    public WebDriver driver;

    @BeforeClass
    public void setupClass() {
        BasicConfigurator.configure();
        logger.info("Starting WebDriver");
        switch (Integer.valueOf(browser)) {
            case 1:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case 2:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case 3:
                WebDriverManager.chromedriver().setup();
                driver = new SafariDriver();
                break;
        }
        logger.info("Maximizing the browser window");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDownClass() {
        if (driver != null) {
            logger.info("Shutting down Web browser");
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}