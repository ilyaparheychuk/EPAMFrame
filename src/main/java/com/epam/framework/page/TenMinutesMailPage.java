package com.epam.framework.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class TenMinutesMailPage extends AbstractPage {

    @FindBy(xpath = ".//input[@ng-model='emailQuote.user.email']")
    private WebElement emailToSent;

    @FindBy(xpath = ".//button[@aria-label='Send Email']")
    private WebElement sendEmail;

    @FindBy(xpath = ".//h3[@id='ui-id-1']")
    private WebElement emailFromGoogle;

    @FindBy(id = "mailAddress")
    private WebElement fieldWithEmail;

    @FindBy(xpath = "//*[@id='mobilepadding']/td/h2")
    private WebElement costInMinuteMail;

    @FindBy(xpath = ".//span[@id='totalMessageCount' and text()='1']")
    private WebElement waitMessage;

    private static String email;
    public static ArrayList<String> tabs;
    protected final String ATTRIBUTE = "value";
    protected final String NEW_PAGE_VALUE = "window.open('https://10minutemail.com')";

    public TenMinutesMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public JavascriptExecutor openTenMinuteMailPage() {
        return (JavascriptExecutor) javascriptExecutor.executeScript(NEW_PAGE_VALUE);
    }

    public WebDriver switchPage(int page) {
        return driver.switchTo().window(tabs.get(page));
    }

    public void openTenMinuteMail() {
        openTenMinuteMailPage();
        tabs = new ArrayList<String>(driver.getWindowHandles());
        switchPage(1);
        waitElement(fieldWithEmail);
        email = fieldWithEmail.getAttribute(ATTRIBUTE);
    }

    public void comeToGooglePage() {
        switchPage(0);
        emailToSent.click();
        emailToSent.sendKeys(email);
        sendEmail.click();
    }

    public void waitEmailFromGoogle() {
        switchPage(1);
        waitElement(waitMessage);
        waitElement(fieldWithEmail);
        scrollDown("700");
        waitElement(emailFromGoogle);
        emailFromGoogle.click();
        scrollDown("950");
        waitElement(costInMinuteMail);
    }

    public String getTotalCostInMinutesMail() {
        return costInMinuteMail.getText().substring(28, 36);
    }
}
