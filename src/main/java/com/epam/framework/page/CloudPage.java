package com.epam.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudPage {

    @FindBy(xpath = ".//input[@class='devsite-search-field devsite-search-query' and @name='q']")
    private WebElement search;

    @FindBy(xpath = "(.//a[@href='https://cloud.google.com/products/calculator/' and @class='gs-title'])[1]")
    private WebElement searchCalc;

    @FindBy(xpath = "//*[@id=\'gc-wrapper\']/div[2]")
    private WebElement nullField;

    WebDriver driver;

    public CloudPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search() {
        driver.get("https://cloud.google.com/");
        search.click();
        search.sendKeys("Google Cloud Platform Pricing Calculator");
        search.submit();
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOf(searchCalc)).click();
        (new WebDriverWait(driver, 40))
                .until(ExpectedConditions.visibilityOf(nullField)).click();
        driver.get("https://cloudpricingcalculator.appspot.com");
    }
}
