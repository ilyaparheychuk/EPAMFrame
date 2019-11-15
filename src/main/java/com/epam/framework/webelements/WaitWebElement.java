package com.epam.framework.webelements;

import com.epam.framework.driver.AbstractWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitWebElement extends AbstractWebDriver {

    public WaitWebElement(WebDriver driver){
        super(driver);
    }

    public WebElement waitElement(WebElement element, int waitTimeSeconds) {
        return (new WebDriverWait(driver, waitTimeSeconds))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
