package com.epam.framework.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected JavascriptExecutor javascriptExecutor;
    protected final int TIME_OUT_IN_SECONDS = 50;
    protected final String JS_REQUEST = "window.scrollBy(0,%s)";

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public WebElement waitElement(WebElement element) {
        return (new WebDriverWait(driver, TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public JavascriptExecutor scrollDown(String scrollValue) {
        return (JavascriptExecutor) javascriptExecutor
                .executeScript(String.format(JS_REQUEST, scrollValue));
    }
}
