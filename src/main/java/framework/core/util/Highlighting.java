package framework.core.util;

import framework.core.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Highlighting {

    public static void highlightElement(WebElement element) {
        ((JavascriptExecutor) Driver.getWebDriverInstance()).executeScript("arguments[0].style.border='3px solid green'", element);
    }

    public static void unHighlightElement(WebElement element) {
        ((JavascriptExecutor) Driver.getWebDriverInstance()).executeScript("arguments[0].style.border='0px'", element);
    }
}
