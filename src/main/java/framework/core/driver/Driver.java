package framework.core.driver;

import framework.core.util.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver instance;

    public static WebDriver getWebDriverInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = init();
    }

    private static WebDriver init() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driverbinaries/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        MyLogger.LOGGER.info("New driver instantiated");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MyLogger.LOGGER.info("Implicit wait applied on the driver for 10 seconds");
        driver.manage().window().maximize();
        return driver;
    }
}
