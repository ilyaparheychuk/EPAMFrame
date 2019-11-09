package com.epam.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudPage extends AbstractPage {

    private String PAGE_URL = "https://cloud.google.com/";
    private String WHAT_I_SEARCH = "Google Cloud Platform Pricing Calculator";
    private String GIVE_UP_PAGE = "https://cloudpricingcalculator.appspot.com";

    @FindBy(xpath = ".//input[@class='devsite-search-field devsite-search-query' and @name='q']")
    private WebElement search;

    @FindBy(xpath = "(.//a[@href='https://cloud.google.com/products/calculator/' and @class='gs-title'])[1]")
    private WebElement searchCalc;

    @FindBy(xpath = "//*[@id=\'gc-wrapper\']/div[2]")
    private WebElement nullField;

    public CloudPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void search() {
        driver.get(PAGE_URL);
        search.click();
        search.sendKeys(WHAT_I_SEARCH);
        search.submit();
        waitElement(searchCalc).click();
        waitElement(nullField).click();
        driver.get(GIVE_UP_PAGE);
    }
}
