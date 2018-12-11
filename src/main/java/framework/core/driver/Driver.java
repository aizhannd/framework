package framework.core.driver;

import framework.common.exception.UnknownDriverTypeException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Driver {
	private static final String DEFAULT_WEB_DRIVER = "DEFAULT_WEB_DRIVER";

	private static WebDriverTypes defaultDriverType = WebDriverTypes.CHROME;

	private static HashMap<String, WebDriver> instances;

	static {
		instances = new HashMap<String, WebDriver>();
	}

	public static WebDriver getWebDriverInstance(String name, WebDriverTypes type) throws IllegalStateException{
		WebDriver driver;
            if (!instances.containsKey(name)) {
                switch (type) {
                    case FIREFOX: {
                        driver = new FirefoxDriver();
                        break;
                    }
                    case IE: {
                        System.setProperty("webdriver.ie.driver", "src/main/resources/driverbinaries/IEDriverServer.exe");
                        driver = new InternetExplorerDriver();
                        break;
                    }
                    case CHROME: {
                        System.setProperty("webdriver.chrome.driver", "src/main/resources/driverbinaries/chromedriver.exe");
                        driver = new ChromeDriver();
                        break;
                    }
                    default:
                        throw new UnknownDriverTypeException("Unknown web driver specified: " + type);
                }
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                instances.put(name, driver);
            }
            else {
                driver = instances.get(name);
            }
			return driver;
		}

	public static WebDriver getWebDriverInstance() throws IllegalStateException{
		return getWebDriverInstance(DEFAULT_WEB_DRIVER, defaultDriverType);
	}

	public static void setDefaultWebDriverType(WebDriverTypes type) {
		defaultDriverType = type;
	}
}
