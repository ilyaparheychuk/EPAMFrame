package com.epam.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;

public class TenMinutesMailPage extends AbstractPage{

    @FindBy(xpath = "//*[@id=\'input_415\']")
    private WebElement emailToSent;

    @FindBy(xpath = ".//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple' and @aria-label='Send Email']")
    private WebElement sendEmail;

    @FindBy(xpath = ".//h3[@id='ui-id-1']")
    private WebElement emailFromGoogle;

    @FindBy(xpath = "//*[@id='mobilepadding']/td/h2")
    private WebElement waitEmailFromGoogle;

    @FindBy(xpath = ".//input[@type='text' and @id='mailAddress']")
    private WebElement fieldWithEmail;

    @FindBy(xpath = "//*[@id='mobilepadding']/td/h2")
    private WebElement costInMinuteMail;

    @FindBy(xpath = ".//span[@id='totalMessageCount' and text()='1']")
    private WebElement waitMessage;

    private static String email;
    public static ArrayList<String> tabs;
    private String ATTRIBUTE = "value";

    public TenMinutesMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebDriver switchPage(int page){
        return driver.switchTo().window(tabs.get(page));
    }

    public void openTenMinuteMail() {
        openTenMinuteMailPage();
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        waitElement(fieldWithEmail);
        email = fieldWithEmail.getAttribute(ATTRIBUTE);
    }

    public void comeToGooglePage() {
        switchPage(0);
        emailToSent.click();
        emailToSent.sendKeys(email);
        sendEmail.click();
    }

    public void waitEmailFromGoogle(){
        switchPage(1);
        driver.navigate().refresh();
        waitElement(waitMessage);
        waitElement(fieldWithEmail);
        scrollDown();
        waitElement(emailFromGoogle);
        emailFromGoogle.click();
        scrollDown();
        waitElement(waitEmailFromGoogle);
    }

    public String getTotalCostInMinutesMail(){
        return costInMinuteMail.getText().substring(28, 36);
    }
}
