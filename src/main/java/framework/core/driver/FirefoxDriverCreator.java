package framework.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class FirefoxDriverCreator extends WebDriverCreator {
    @Override
    public WebDriver FactoryMethod() {
        FirefoxBinary binary = new FirefoxBinary(new File("src/main/resources/driverbinaries/geckodriver.exe"));
        FirefoxProfile profile = new FirefoxProfile(new File(
                "d:\\webdrivers\\"));
        driver = new FirefoxDriver(binary, profile);
        return driver;
    }
}
