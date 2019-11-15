package com.epam.framework.jsexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSEOpenNewPages extends JSExecutorMain {

    public JSEOpenNewPages(WebDriver driver) {
        super(driver);
    }

    public JavascriptExecutor openNewPage(String nameOFThePage) {
        return (JavascriptExecutor) javascriptExecutor.executeScript(nameOFThePage);
    }
}
