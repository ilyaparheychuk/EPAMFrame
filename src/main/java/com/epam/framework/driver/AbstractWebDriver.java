package com.epam.framework.driver;

import org.openqa.selenium.WebDriver;

public abstract class AbstractWebDriver {

    protected WebDriver driver;

    public AbstractWebDriver(WebDriver driver) {
        this.driver = driver;
    }
}
