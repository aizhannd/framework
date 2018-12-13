package tests;

import framework.common.bo.Letter;
import org.testng.Assert;
import org.testng.annotations.Test;
import framework.common.pages.*;

public class MailTest extends BaseTest {
    private Letter mail = new Letter("ayzhan7797@mail.ru", "test(module 4.2)", "Hello!");
    private Letter secondMail = new Letter("<Не указано>", "<Без темы>", "-- Name LastName");
    private DraftsFolderPage draftsFolderPage;
    private CreateNewMailPage newMailPage;

    @Test(description = "Login test")
    public void loginTest() {
        Assert.assertTrue(isUserSignedIn(), "Authentication failed");
    }

    @Test(dependsOnMethods = "loginTest")
    public void saveNewMailTest() {
        inbox.openWriteNewMail();
        newMailPage = new CreateNewMailPage();
        newMailPage.fillAddressee(mail.getAddressee());
        newMailPage.fillSubject(mail.getSubject());
        newMailPage.fillBody(mail.getBody());
        newMailPage.saveDraft();
        Assert.assertTrue(newMailPage.isMailSaved(), "The mail is not saved");
    }

    @Test(dependsOnMethods = "saveNewMailTest")
    public void testContent() {
        newMailPage.openDraftsFolder();
        newMailPage.refresh();
        Assert.assertTrue(draftsFolderPage.isSavedMailExist(mail), "The draft content isn't the same as in mail");
    }

    @Test(dependsOnMethods = "testContent")
    public void testSecondMail() {
        Assert.assertTrue(draftsFolderPage.isSavedMailExist(secondMail), "The second mail isn't found");
    }

    @Test(dependsOnMethods = "testSecondMail")
    public void sendMailTest() {
        draftsFolderPage = new DraftsFolderPage();
        draftsFolderPage.openMail(mail);
        draftsFolderPage.refresh();
        newMailPage.sendMail();
        draftsFolderPage.openDraftsFolder();
        draftsFolderPage.refresh();
        Assert.assertFalse(draftsFolderPage.isSavedMailExist(mail), "The mail didn't disappear from 'Drafts' folder");
    }

    @Test(dependsOnMethods = "sendMailTest")
    public void sentFolderTest() {
        draftsFolderPage.openSentFolder();
        draftsFolderPage.refresh();
        SentFolderPage sentPage = new SentFolderPage();
        Assert.assertTrue(sentPage.isSentMailExist(mail), "The sent letter isn't in 'Sent' folder");
    }
}
