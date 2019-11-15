package com.epam.framework.webelements;

import com.epam.framework.driver.AbstractWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicWebElements extends AbstractWebDriver {

    public DynamicWebElements(WebDriver driver) {
        super(driver);
    }

    private final String xpathTypeInstanceStandard = "//*[contains(text(),'%s')]";
    private final String xpathTypeOfGpuTesla = ".//md-option[@value='%s']";
    private final String xpathLocationDatacenter = "(//*[contains(text(),'%s')])[4]";

    public WebElement typeInstanceStandard(String userLocator) {
        return driver.findElement
                (By.xpath(String.format(xpathTypeInstanceStandard, userLocator)));
    }

    public WebElement locationDatacenter(String userLocator) {
        return driver.findElement
                (By.xpath(String.format(xpathLocationDatacenter, userLocator)));
    }

    public WebElement typeOfGPUTesla(String userLocator) {
        return driver.findElement
                (By.xpath(String.format(xpathTypeOfGpuTesla, userLocator)));
    }
}
