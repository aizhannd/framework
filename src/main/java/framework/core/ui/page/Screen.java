package framework.core.ui.page;

import framework.core.ui.driver.Driver;
import org.openqa.selenium.WebDriver;

public abstract class Screen {
	private WebDriver browser;

	public Screen() throws Exception {
		this(Driver.getWebDriverInstance());
	}

	public Screen(WebDriver browser) {
		this.browser = browser;
		checkCorrectScreenOpened();
	}

	public WebDriver getDriver() {
		return browser;
	}

	public void setDriver(WebDriver driver) {
		this.browser = driver;
	}

	public abstract void checkCorrectScreenOpened();

	public abstract void initElements();
}
