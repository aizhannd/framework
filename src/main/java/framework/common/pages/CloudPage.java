package framework.common.pages;

import framework.core.util.MyLogger;
import framework.core.util.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CloudPage extends BasePage {

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

    public void openPicturesFolder() {
        Waiting.waitForElementEnabled(picturesFolder);
        MyLogger.LOGGER.info("Clicking 'Pictures folder' icon");
        picturesFolder.click();
    }

    public void createFolder() {
        Waiting.waitForElementEnabled(createFolderButton);
        MyLogger.LOGGER.info("Clicking the 'Create folder' button");
        createFolderButton.click();
        MyLogger.LOGGER.info("Pressing ENTER");
        driver.findElement(By.cssSelector(" input[placeholder]")).sendKeys(Keys.ENTER);
    }

    public void removeTheNewFolder() {
        MyLogger.LOGGER.info("Clicking 'New folder' checkbox");
        newFolderCheckbox.click();
        MyLogger.LOGGER.info("Clicking 'Remove' button");
        remove.click();
        MyLogger.LOGGER.info("Confirming at pop-up window that we want to delete this folder");
        removeButton.click();
        MyLogger.LOGGER.info("Close pop-up window");
        okClose.click();
    }

    public boolean isFolderExist() {
        List<WebElement> list = getFileNameList();
        boolean isExist = false;
        for (WebElement filename : list) {
            if (isExist = filename.getText().equals("Новая папка")) {
                break;
            }
        }
        return isExist;
    }
}
