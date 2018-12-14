package tests;

import framework.common.bo.User;
import framework.common.pages.HomePage;
import framework.common.pages.InboxPage;
import framework.core.driver.Driver;
import framework.core.util.Waiting;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected InboxPage inbox;
    protected User user = new User();

    @BeforeClass
    public void login() {
        inbox = new HomePage().open().fillUsername(user.getUsername()).fillPassword(user.getPass()).signIn();
        Waiting.waitForPageIsLoaded(25000);
    }

    public boolean isUserSignedIn() {
        return inbox.getUserName().equals(user.getUsername());
    }

    @AfterClass(description = "closePanel browser")
    public void kill() {
        Driver.getWebDriverInstance().quit();
    }
}
