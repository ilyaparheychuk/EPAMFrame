package com.epam.framework.jsexecutor;

import com.epam.framework.driver.AbstractWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSExecutorMain extends AbstractWebDriver {

    protected JavascriptExecutor javascriptExecutor;

    public JSExecutorMain(WebDriver driver) {
        super(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
    }
}
