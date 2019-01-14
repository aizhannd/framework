package tests;

import framework.common.bo.User;
import framework.common.pages.HomePage;
import framework.common.pages.InboxPage;
import framework.core.driver.Driver;
import framework.core.util.MyLogger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected InboxPage inbox;
    private User user = new User();

    @BeforeClass
    public void login() {
        inbox = new HomePage().open().fillUsername(user.getUsername()).fillPassword(user.getPass()).signIn();
    }

    public boolean isUserSignedIn() {
        return inbox.getUserName().equals(user.getUsername());
    }

    @AfterClass
    public static void quitBrowser() {
        Driver.getWebDriverInstance().quit();
        MyLogger.LOGGER.info("Browser closed");
    }
}
