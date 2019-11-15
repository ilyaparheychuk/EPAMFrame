package com.epam.framework.jsexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSEScroll extends JSExecutorMain {

    protected final String JS_REQUEST = "window.scrollBy(0,%s)";

    public JSEScroll(WebDriver driver) {
        super(driver);
    }

    public JavascriptExecutor scrollDown(String scrollValue) {
        return (JavascriptExecutor) javascriptExecutor
                .executeScript(String.format(JS_REQUEST, scrollValue));
    }
}
