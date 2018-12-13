package framework.common.pages;

import framework.core.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class AbstractPage {
    protected WebDriver driver;

    protected AbstractPage() {
        this.driver = Driver.getWebDriverInstance();
        PageFactory.initElements(driver, this);
    }

    public void refresh(){
            Driver.getWebDriverInstance().navigate().refresh();
    }

    protected void highlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid green'", element);
    }

    protected void unHighlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", element);
    }
}
