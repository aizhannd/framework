package framework.common.pages;

import framework.core.driver.DriverDecorator;
import framework.core.util.Waiting;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CloudPage extends DriverDecorator {
    private Actions action = new Actions(driver);

    @FindBy(xpath = "//div[@data-id='/Pictures']/*[@class='b-thumb__content']")
    private WebElement picturesFolder;

    @FindBy(xpath = "//div[@class='b-panel__close__icon']")
    private WebElement closepanel;

    @FindBy(xpath = "//span[contains(string(), 'Создать папку')]")
    private WebElement createFolderButton;

    @FindBy(xpath = "//div[@class='b-filename__text']")
    private List<WebElement> fileNameList;

    @FindBy(xpath = "//div[@data-id='/Новая папка']//div[@class='b-checkbox__box']")
    private WebElement newFolderCheckbox;

    @FindBy(xpath = "//span[contains(string(), 'Удалить')]")
    private WebElement remove;

    @FindBy(xpath = "//button[@data-name='remove']")
    private WebElement removeButton;

    @FindBy(xpath = "//div[@class='layer__footer']/button[@data-name='close']")
    private WebElement okClose;

    public void closePanel() {
        closepanel.click();
    }

    private List<WebElement> getFileNameList() {
        return fileNameList;
    }

    public CloudPage moveMouseToPicturesFolder() {
        Waiting.waitForElementEnabled(picturesFolder);
        action.moveToElement(picturesFolder).perform();
        return this;
    }

    public PicturesFolderCloudPage doubleClick() {
        action.doubleClick().perform();
        return new PicturesFolderCloudPage();
    }

    public void createFolder() {
        Waiting.waitForElementEnabled(createFolderButton);
        action
                .click(createFolderButton)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }

    public void removeTheNewFolder() {
        action
                .click(newFolderCheckbox)
                .click(remove)
                .click(removeButton)
                .click(okClose)
                .build()
                .perform();
    }

    public boolean isFolderExist() {
        List<WebElement> list = getFileNameList();
        boolean isExist = false;
        for (WebElement filename : list) {
            if (isExist = filename.getText().equals("Новая папка")) {
                highlightElement(filename);
                break;
            }
        }
        return isExist;
    }
}
