package framework.common.pages;

import framework.core.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = Driver.getWebDriverInstance();
        PageFactory.initElements(driver, this);
    }

    public void refresh() {
        Driver.getWebDriverInstance().navigate().refresh();
    }

}
