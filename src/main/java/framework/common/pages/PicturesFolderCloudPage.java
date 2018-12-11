package framework.common.pages;

import framework.core.driver.Driver;

public class PicturesFolderCloudPage extends AbstractPage {

    public String getTitle() {
            return Driver.getWebDriverInstance().getTitle();
    }
}