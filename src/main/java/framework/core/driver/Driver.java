package framework.core.driver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getWebDriverInstance() {
        if (driver == null) {
            WebDriverCreator creator = new ChromeDriverCreator();
            driver = creator.FactoryMethod();
            driver = new DriverDecorator();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }
}
