package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import framework.common.pages.CloudPage;
import framework.common.pages.PicturesFolderCloudPage;

public class CloudTest extends BaseTest {

    private CloudPage cloudPage;

    @Test(description = "Login test")
    public void loginTest() {
        Assert.assertTrue(isUserSignedIn(), "Authentication failed");
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
}
