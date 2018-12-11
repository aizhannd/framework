package framework.common.pages;

import framework.core.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id = "mailbox:login")
    private WebElement username;

    @FindBy(id = "mailbox:password")
    private WebElement password;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id='mailbox:domain']/option[4]")
    private WebElement domain;

    public HomePage open() {
        Driver.getWebDriverInstance().get("https://mail.ru");
        waitForElementEnabled(username);
        return this;
    }

    public HomePage fillUsername(String login) {
        username.sendKeys(login);
        return this;
    }

    public HomePage fillPassword(String pass) {
        password.sendKeys(pass);
        return this;
    }

    public HomePage chooseDomain() {
        domain.click();
        return this;
    }

    public InboxPage signIn() {
        signInButton.click();
        return new InboxPage();
    }
}
