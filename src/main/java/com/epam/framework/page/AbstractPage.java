package com.epam.framework.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected final int TIME_OUT_IN_SECONDS = 50;
    protected final String SCROLL_VALUE = "window.scrollBy(0,840)";
    protected final String NEW_PAGE_VALUE = "window.open('https://10minutemail.com')";

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitElement(WebElement element) {
        return (new WebDriverWait(driver, TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public JavascriptExecutor scrollDown() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        return (JavascriptExecutor) javascriptExecutor.executeScript(SCROLL_VALUE);
    }

    public JavascriptExecutor openTenMinuteMailPage() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        return (JavascriptExecutor) javascriptExecutor.executeScript(NEW_PAGE_VALUE);
    }
}
