package framework.common.pages;

import framework.common.bo.Letter;
import framework.core.driver.DriverDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DraftsFolderPage extends DriverDecorator {

    @FindBy(xpath = ".//div[@class='b-datalist__item__addr']")
    private List<WebElement> addrList;

    @FindBy(xpath = ".//div[@class='b-datalist__item__panel']")
    private List<WebElement> mails;

    @FindBy(xpath = "//a[@data-mnemo='drafts']")
    private WebElement draftsFolderButton;

    @FindBy(xpath = "//a[@href='/messages/sent/']")
    private WebElement sentFolderButton;

    private List<WebElement> getAddrList() {
        return addrList;
    }

    public void openDraftsFolder() {
        draftsFolderButton.click();
    }

    public void openSentFolder() {
        sentFolderButton.click();
    }

    private List<Letter> getSavedMailsList() {
        List<Letter> results = new ArrayList<Letter>();
        for (WebElement mail : mails) {
            String addressee = mail.findElement(By.xpath(".//div[@class='b-datalist__item__addr']")).getText();
            String div = mail.findElement(By.xpath(".//div[@class='b-datalist__item__subj']")).getText();
            String span = mail.findElement(By.xpath(".//div[@class='b-datalist__item__subj']/span")).getText();
            int index = div.indexOf(span);
            String subject = div.substring(0, index);
            String body = mail.findElement(By.xpath(".//*[@class='b-datalist__item__subj__snippet']")).getText();
            results.add(new Letter(addressee, subject, body));
        }
        return results;
    }

    public boolean isSavedMailExist(Letter mail) {
        List<Letter> draftMails = getSavedMailsList();
        boolean content = false;
        for (Letter draftMail : draftMails) {
            if (draftMail.getAddressee().equals(mail.getAddressee()) &&
                    draftMail.getSubject().equals(mail.getSubject()) &&
                    draftMail.getBody().contains(mail.getBody())) {
                content = true;
                break;
            }
        }
        return content;
    }

    private int getIndexOfMail(Letter mail) {
        int index = 0;
        List<Letter> draftMails = getSavedMailsList();
        for (int i = 0; i < draftMails.size(); i++) {
            if (draftMails.get(i).getAddressee().equals(mail.getAddressee()) &&
                    draftMails.get(i).getSubject().equals(mail.getSubject()) &&
                    draftMails.get(i).getBody().equals(mail.getBody())) {
                index = i;
            }
        }
        return index;
    }

    public void openMail(Letter mail) {
        getAddrList().get(getIndexOfMail(mail)).click();
    }
}
