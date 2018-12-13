package tests;

import framework.common.bo.User;
import framework.common.pages.HomePage;
import framework.common.pages.InboxPage;
import framework.core.driver.Driver;
import framework.core.util.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected InboxPage inbox;
    protected User user = new User();

    @FindBy(xpath = "//*[@id='PH_user-email']")
    private WebElement userEmailIdentificator;

    @BeforeClass
    public void login() {
        inbox = new HomePage().open().fillUsername(user.getUsername()).fillPassword(user.getPass()).signIn();
        Waiting.waitForPageIsLoaded(25000);
        Waiting.waitForElementVisibleEnabled(userEmailIdentificator);
    }

    public boolean isUserSignedIn() {
        return userEmailIdentificator.getText().contains(user.getUsername());
    }

    @AfterClass(description = "closePanel browser")
    public void kill() {
        Driver.getWebDriverInstance().quit();
    }
}
