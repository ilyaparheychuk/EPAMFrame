package com.epam.framework.page;

import com.epam.framework.driver.AbstractWebDriver;
import com.epam.framework.jsexecutor.JSEOpenNewPages;
import com.epam.framework.jsexecutor.JSEScroll;
import com.epam.framework.user.User;
import com.epam.framework.user.UserCreator;
import com.epam.framework.webelements.DynamicWebElements;
import com.epam.framework.webelements.WaitWebElement;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage extends AbstractWebDriver {

    protected WaitWebElement wait;
    protected User user;
    protected JSEScroll scroll;
    protected JSEOpenNewPages openNewPages;
    protected DynamicWebElements dynamicElement;

    public AbstractPage(WebDriver driver) {
        super(driver);
        wait = new WaitWebElement(driver);
        user = UserCreator.withCredentialsFromProperty();
        scroll = new JSEScroll(driver);
        openNewPages = new JSEOpenNewPages(driver);
        dynamicElement = new DynamicWebElements(driver);
    }
}
