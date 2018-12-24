package framework.common.pages;

import framework.common.bo.Letter;
import framework.core.driver.DriverDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SentFolderPage extends DriverDecorator {

    @FindBy(xpath = ".//div[@class='b-datalist__item__panel']")
    private List<WebElement> mails;

    private List<Letter> getSentList() {
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

    public boolean isSentMailExist(Letter mail) {
        List<Letter> draftMails = getSentList();
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
}
