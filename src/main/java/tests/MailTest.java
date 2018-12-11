package tests;

import framework.core.driver.Driver;
import framework.common.bo.Letter;
import framework.common.bo.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import framework.common.pages.*;

public class MailTest {
    private InboxPage inbox;
    private Letter mail = new Letter("ayzhan7797@mail.ru", "test(module 4.2)", "Hello!");
    private Letter secondMail = new Letter("<Не указано>", "<Без темы>", "-- Name LastName");
    private User user = new User("new_account_2018", "password2018");
    private DraftsFolderPage draftsFolderPage;
    private CreateNewMailPage newMailPage;
    private SentFolderPage sentPage;

    @BeforeClass
    private void init() {
        inbox = new InboxPage();
        newMailPage = new CreateNewMailPage();
        draftsFolderPage = new DraftsFolderPage();
        sentPage = new SentFolderPage();
    }

    @Test(description = "Login test")
    public void loginTest() {
        inbox = new HomePage().open().fillUsername(user.getUsername()).fillPassword(user.getPass()).chooseDomain().signIn();
        Assert.assertTrue(inbox.isUserSignedIn(), "Authentication failed");
    }

    @Test(dependsOnMethods = "loginTest")
    public void saveNewMailTest() {
        inbox.openWriteNewMail();
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
        Assert.assertTrue(sentPage.isSentMailExist(mail), "The sent letter isn't in 'Sent' folder");
    }

    @AfterClass(description = "closePanel browser")
    public void kill()throws Exception {
        Driver.getWebDriverInstance().quit();
    }
}
