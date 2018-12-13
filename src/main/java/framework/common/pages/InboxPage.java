package framework.common.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class InboxPage extends AbstractPage {


    @FindBy(xpath = "//*[@id='b-toolbar__left']//span")
    private WebElement createNewMailButton;

    @FindBy(xpath = "//span[@class='js-text-inner pm-toolbar__button__text__inner' and contains(string(), 'Облако')]")
    private WebElement cloudButton;

    public void openWriteNewMail() {
        createNewMailButton.click();
    }

    public CloudPage openCloudPage() {
        cloudButton.click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new CloudPage();
    }
}
