package com.epam.framework.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage {

    @FindBy(xpath = ".//input[@id='input_53']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//*[@id=\'select_value_label_49\']/span[1]")
    private WebElement typeInstance;

    @FindBy(xpath = "//*[@id=\'select_option_217\']/div")
    private WebElement typeInstanceStandard;

    @FindBy(xpath = "//*[@id=\'mainForm\']/div[1]/div/md-card/md-card-content/div/div[1]/form/div[8]/div[1]/md-input-container/md-checkbox/div[2]")
    private WebElement addGPU;

    @FindBy(xpath = "//*[@id=\'select_value_label_346\']/span[1]/div")
    private WebElement numberOfGPU;

    @FindBy(xpath = "//*[@id=\'select_option_353\']/div[1]")
    private WebElement numberOfGPUOne;

    @FindBy(xpath = " //*[@id=\'select_value_label_347\']/span[1]/div")
    private WebElement typeOfGPU;

    @FindBy(xpath = "//*[@id=\'select_option_360\']/div")
    private WebElement typeOfGPUTesla;

    @FindBy(xpath = "//*[@id=\'select_value_label_50\']/span[1]")
    private WebElement localSSD;

    @FindBy(xpath = "//*[@id=\'select_option_171\']/div")
    private WebElement localSSDWhatIWant;

    @FindBy(xpath = "//*[@id=\'select_value_label_51\']/span[1]/div")
    private WebElement datacenter;

    @FindBy(xpath = "//*[@id=\'select_option_185\']")
    private WebElement locationDatacenter;

    @FindBy(xpath = "//*[@id=\'select_value_label_52\']/span[1]/div")
    private WebElement commited;

    @FindBy(xpath = "//*[@id=\'select_option_83\']/div")
    private WebElement commitedOneYear;

    @FindBy(xpath = "//*[@id=\'mainForm\']/div[1]/div/md-card/md-card-content/div/div[1]/form/div[13]/button")
    private WebElement addToEstimate;

    @FindBy(xpath = ".//b[@class='ng-binding']")
    private WebElement waitElement;

    @FindBy(xpath = "//*[@id=\'email_quote\']")
    private WebElement emailEstimate;

    @FindBy(xpath = "//*[@id=\'input_415\']")
    private WebElement emailToSent;

    WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillingTheForm() {
        (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.visibilityOf(numberOfInstances))
                .isDisplayed();
        numberOfInstances.click();
        numberOfInstances.sendKeys("4");
        typeInstance.click();
        typeInstanceStandard.click();
        addGPU.click();
        numberOfGPU.click();
        numberOfGPUOne.click();
        typeOfGPU.click();
        typeOfGPUTesla.click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,400)");
        (new WebDriverWait(driver, 40))
                .until(ExpectedConditions.visibilityOf(localSSD))
                .click();
        localSSDWhatIWant.click();
        datacenter.click();
        (new WebDriverWait(driver, 40))
                .until(ExpectedConditions.visibilityOf(locationDatacenter))
                .click();
        commited.click();
        commitedOneYear.click();
        addToEstimate.click();
        (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.visibilityOf(waitElement))
                .isDisplayed();
    }

    public void sentEmail() {
        emailEstimate.click();
        (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.visibilityOf(emailToSent))
                .isDisplayed();

    }

}
