package tests.mail;

import framework.core.ui.driver.Driver;
import tests.mail.bo.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import tests.mail.pages.CloudPage;
import tests.mail.pages.HomePage;
import tests.mail.pages.InboxPage;
import tests.mail.pages.PicturesFolderCloudPage;

public class CloudTest {
    private InboxPage inbox;
    private CloudPage cloudPage;
    private User user = new User("new_account_2018", "password2018");

    @Test(description = "Login test")
    public void loginTest() {
        inbox = new HomePage().open().fillUsername(user.getUsername()).fillPassword(user.getPass()).chooseDomain().signIn();
        Assert.assertTrue(inbox.isUserSignedIn(), "Authentication failed");
    }

    @Test(dependsOnMethods = "loginTest")
    public void createFolder() {
        cloudPage = inbox.openCloudPage();
        cloudPage.closePanel();
        cloudPage.createFolder();
        cloudPage.refresh();
        Assert.assertTrue(cloudPage.isFolderExist(), "The folder doesn't created");
    }

    @Test(dependsOnMethods = "createFolder")
    public void removeTheFolder() {
        cloudPage.removeTheNewFolder();
        Assert.assertFalse(cloudPage.isFolderExist(), "The folder doesn't removed");
    }

    @Test(dependsOnMethods = "removeTheFolder")
    public void doubleClickTest() {
        PicturesFolderCloudPage picturesFolderPage = cloudPage.moveMouseToPicturesFolder().doubleClick();
        Assert.assertEquals(picturesFolderPage.getTitle(), "Pictures / Облако Mail.Ru", "The title is wrong");
    }

    @AfterClass(description = "closePanel browser")
    public void kill() throws Exception {
        Driver.getWebDriverInstance().quit();
    }
}
