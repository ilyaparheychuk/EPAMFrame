package com.epam.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage extends AbstractPage {

    @FindBy(id = "input_53")
    private WebElement numberOfInstances;

    @FindBy(id = "select_value_label_49")
    private WebElement typeInstance;

    @FindBy(xpath = "//*[contains(text(), 'Add GPUs.')]")
    private WebElement addGPU;

    @FindBy(id = "select_value_label_346")
    private WebElement numberOfGPU;

    @FindBy(id = "select_option_353")
    private WebElement numberOfGPUOne;

    @FindBy(id = "select_value_label_347")
    private WebElement typeOfGPU;

    @FindBy(id = "select_value_label_50")
    private WebElement localSSD;

    @FindBy(id = "select_option_171")
    private WebElement localSSDWhatIWant;

    @FindBy(id = "select_value_label_51")
    private WebElement datacenter;

    @FindBy(id = "select_value_label_52")
    private WebElement commited;

    @FindBy(id = "select_option_83")
    private WebElement commitedOneYear;

    @FindBy(xpath = "(.//button[@aria-label='Add to Estimate'])[1]")
    private WebElement addToEstimate;

    @FindBy(xpath = ".//b[@class='ng-binding']")
    private WebElement waitJustElement;

    @FindBy(id = "email_quote")
    private WebElement emailEstimate;

    @FindBy(xpath = ".//input[@ng-model='emailQuote.user.email']")
    private WebElement emailToSent;

    @FindBy(xpath = "(.//b[@class='ng-binding'])[2]")
    private WebElement costInGoogleCalculator;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillingTheForm() {
        wait.waitElement(numberOfInstances,5)
                .click();
        numberOfInstances.sendKeys(user.getNumberOfInstances());
        typeInstance.click();
        dynamicElement.typeInstanceStandard
                (user.getTypeInstanceStandard()).click();
        wait.waitElement(addGPU,5);
        addGPU.click();
        numberOfGPU.click();
        numberOfGPUOne.click();
        typeOfGPU.click();
        dynamicElement.typeOfGPUTesla
                (user.getTypeOfGpuTesla()).click();
        scroll.scrollDown("750");
        wait.waitElement(localSSD,5)
                .click();
        localSSDWhatIWant.click();
        datacenter.click();
        wait.waitElement(dynamicElement.locationDatacenter
                (user.getIDLocationDatacenter()),5)
                .click();
        commited.click();
        commitedOneYear.click();
        addToEstimate.click();
        wait.waitElement(waitJustElement,5);
    }

    public void sentEmail() {
        emailEstimate.click();
        wait.waitElement(emailToSent,5);
    }

    public String getTotalCostInGoogleCalculator() {
        wait.waitElement(costInGoogleCalculator,5);
        return costInGoogleCalculator.getText().substring(26, 34);
    }
}
