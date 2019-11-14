package com.epam.framework.page;

import com.epam.framework.user.User;
import com.epam.framework.user.UserCreator;
import org.openqa.selenium.By;
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

    private WebElement typeInstanceStandard() {
        return driver.findElement
                (By.xpath(user.getTypeInstanceStandard()));
    }

    private WebElement locationDatacenter() {
        return driver.findElement
                (By.xpath(user.getIDLocationDatacenter()));
    }

    private WebElement typeOfGPUTesla() {
        return driver.findElement
                (By.xpath(user.getTypeOfGpuTesla()));
    }

    private User user;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        user = UserCreator.withCredentialsFromProperty();
    }

    public void fillingTheForm() {
        waitElement(numberOfInstances).click();
        numberOfInstances.sendKeys(user.getNumberOfInstances());
        typeInstance.click();
        typeInstanceStandard().click();
        waitElement(addGPU);
        addGPU.click();
        numberOfGPU.click();
        numberOfGPUOne.click();
        typeOfGPU.click();
        typeOfGPUTesla().click();
        scrollDown("750");
        waitElement(localSSD).click();
        localSSDWhatIWant.click();
        datacenter.click();
        waitElement(locationDatacenter())
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
