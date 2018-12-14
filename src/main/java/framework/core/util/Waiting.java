package framework.core.util;

import framework.core.driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.List;

public class Waiting {
    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 15;

    public static void waitForElementVisible(WebElement element) {
        new WebDriverWait(Driver.getWebDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementEnabled(WebElement element) {
        new WebDriverWait(Driver.getWebDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementVisibleEnabled(WebElement element) {
        new WebDriverWait(Driver.getWebDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOf(element),
                        ExpectedConditions.elementToBeClickable(element)));
    }


    public static boolean waitForListElementIsPresent(WebDriver driver, List<WebElement> element) {
        FluentWait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.ignoring(TimeoutException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        try {
            wait.until(ExpectedConditions.visibilityOf(element.get(0)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static void waitForElementPresent(WebDriver driver, WebElement element) {
        FluentWait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.ignoring(TimeoutException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementRefreshed(WebDriver driver, WebElement element, String oldValue) {
        try {
            FluentWait<WebDriver> wait = new WebDriverWait(driver, 10);
            wait.ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(element, "value", oldValue)));
        } catch (TimeoutException e) {
        }
    }

    public static boolean waitForTextOnElementIsPresent(WebDriver driver, WebElement element, String text) {
        FluentWait<WebDriver> wait = new WebDriverWait(driver, 20);
        wait.ignoring(NoSuchElementException.class);
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static void waitForPageIsLoaded(int timeout) {
        try {
            FluentWait<WebDriver> wait = new WebDriverWait(Driver.getWebDriverInstance(), timeout);
            ExpectedCondition<Boolean> pageLoadCondition = driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
            wait.until(pageLoadCondition);
        } catch (TimeoutException ignored) {
        }
    }
}
