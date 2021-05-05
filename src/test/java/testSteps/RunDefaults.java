package testSteps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RunDefaults {
    private static Logger logger = LoggerFactory.getLogger(RunDefaults.class);
    private static Properties prop;

    public static String setProperties(String key) {
        try {
            String dir = "src/test/resources/config.properties";
            FileInputStream inputStream = new FileInputStream(dir);
            prop = new Properties();
            prop.load(inputStream);
        } catch (IOException e) {
            logger.error("Can not find Properties file");
        }
        return prop.getProperty(key);
    }

    public static void sleepSeconds(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
