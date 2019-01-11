package framework.common.pages;

import framework.core.util.MyLogger;
import framework.core.util.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "mailbox:login")
    private WebElement username;

    @FindBy(id = "mailbox:password")
    private WebElement password;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement signInButton;


    public HomePage open() {
        driver.get("https://mail.ru");
        MyLogger.info("Going to URL: " + "https://mail.ru");
        Waiting.waitForElementEnabled(username);
        return this;
    }

    public HomePage fillUsername(String login) {
        username.sendKeys(login);
        MyLogger.info("The username filling");
        return this;
    }

    public HomePage fillPassword(String pass) {
        password.sendKeys(pass);
        MyLogger.info("Password filling");
        return this;
    }

    public InboxPage signIn() {
        signInButton.click();
        MyLogger.info("The signIn button clicking");
        return new InboxPage();
    }
}
