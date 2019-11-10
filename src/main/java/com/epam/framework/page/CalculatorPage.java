package com.epam.framework.page;

import com.epam.framework.user.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage extends AbstractPage {

    @FindBy(id = "input_53")
    private WebElement numberOfInstances;

    @FindBy(id = "select_value_label_49")
    private WebElement typeInstance;

    @FindBy(xpath = "//*[contains(text(), 'n1-standard-8 (vCPUs: 8, RAM: 30GB)')]")
    private WebElement typeInstanceStandard;

    @FindBy(xpath = "//*[contains(text(), 'Add GPUs.')]")
    private WebElement addGPU;

    @FindBy(id = "select_value_label_346")
    private WebElement numberOfGPU;

    @FindBy(id = "select_option_353")
    private WebElement numberOfGPUOne;

    @FindBy(id = "select_value_label_347")
    private WebElement typeOfGPU;

    @FindBy(xpath = ".//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement typeOfGPUTesla;

    @FindBy(id = "select_value_label_50")
    private WebElement localSSD;

    @FindBy(id = "select_option_171")
    private WebElement localSSDWhatIWant;

    @FindBy(id = "select_value_label_51")
    private WebElement datacenter;

    @FindBy(id = "select_option_185")
    private WebElement locationDatacenterFrankfurt;

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

    @FindBy(id = "input_415")
    private WebElement emailToSent;

    @FindBy(xpath = "(.//b[@class='ng-binding'])[2]")
    private WebElement costInGoogleCalculator;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillingTheForm() {
        waitElement(numberOfInstances).click();
        numberOfInstances.sendKeys(new User()
                .getNumberOfInstances());
        typeInstance.click();
        typeInstanceStandard.click();
        waitElement(addGPU);
        addGPU.click();
        numberOfGPU.click();
        numberOfGPUOne.click();
        typeOfGPU.click();
        typeOfGPUTesla.click();
        scrollDown();
        waitElement(localSSD).click();
        localSSDWhatIWant.click();
        datacenter.click();
        waitElement(locationDatacenterFrankfurt)
                .click();
        commited.click();
        commitedOneYear.click();
        addToEstimate.click();
        waitElement(waitJustElement);
    }

    public void sentEmail() {
        emailEstimate.click();
        waitElement(emailToSent);
    }

    public String getTotalCostInGoogleCalculator() {
        waitElement(costInGoogleCalculator);
        return costInGoogleCalculator.getText().substring(26, 34);
    }
}
