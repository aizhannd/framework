package tests;

import framework.core.util.MyLogger;
import org.testng.Assert;
import org.testng.annotations.Test;
import framework.common.pages.CloudPage;
import framework.common.pages.PicturesFolderCloudPage;

public class CloudTest extends BaseTest {

    private CloudPage cloudPage;

    @Test(description = "Login test")
    public void loginTest() {
        MyLogger.LOGGER.info("Asserting that user signed in");
        Assert.assertTrue(isUserSignedIn());
    }

    @Test(dependsOnMethods = "loginTest")
    public void createFolder() {
        cloudPage = inbox.openCloudPage();
        cloudPage.closePanel();
        cloudPage.createFolder();
        cloudPage.refresh();
        MyLogger.LOGGER.info("Asserting that the folder was created");
        Assert.assertTrue(cloudPage.isFolderExist());
    }

    @Test(dependsOnMethods = "createFolder")
    public void removeTheFolder() {
        cloudPage.removeTheNewFolder();
        MyLogger.LOGGER.info("Asserting that folder is removed");
        Assert.assertFalse(cloudPage.isFolderExist());
    }

    @Test(dependsOnMethods = "removeTheFolder")
    public void openPicturesFolderTest() {
        cloudPage.openPicturesFolder();
        PicturesFolderCloudPage picturesFolderPage = new PicturesFolderCloudPage();
        MyLogger.LOGGER.info("Asserting that we on 'Pictures folder' page");
        Assert.assertEquals(picturesFolderPage.getTitle(), "Pictures / Облако Mail.Ru");
    }
}
