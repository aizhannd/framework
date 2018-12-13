package framework.common.pages;

import framework.core.driver.Driver;
import framework.core.util.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id = "mailbox:login")
    private WebElement username;

    @FindBy(id = "mailbox:password")
    private WebElement password;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement signInButton;


    public HomePage open() {
        Driver.getWebDriverInstance().get("https://mail.ru");
        Waiting.waitForElementEnabled(username);
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

    public InboxPage signIn() {
        signInButton.click();
        return new InboxPage();
    }
}
