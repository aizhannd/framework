package framework.common.pages;

import framework.core.driver.Driver;
import framework.core.driver.DriverDecorator;

public class PicturesFolderCloudPage extends DriverDecorator {

    public String getTitle() {
            return Driver.getWebDriverInstance().getTitle();
    }
}