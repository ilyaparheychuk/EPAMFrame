package com.epam.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class TenMinutesMailPage extends AbstractPage {

    private static String email;
    public static ArrayList<String> tabs;
    protected final String ATTRIBUTE = "value";
    protected final String TEN_MINUTE_MAIL_PAGE = "window.open('https://10minutemail.com')";

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

    public TenMinutesMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebDriver switchPage(int page) {
        return driver.switchTo().window(tabs.get(page));
    }

    public void openTenMinuteMail() {
        openNewPages.openNewPage(TEN_MINUTE_MAIL_PAGE);
        tabs = new ArrayList<String>(driver.getWindowHandles());
        switchPage(1);
        wait.waitElement(fieldWithEmail,10);
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
        wait.waitElement(waitMessage,60);
        wait.waitElement(fieldWithEmail,5);
        scroll.scrollDown("700");
        wait.waitElement(emailFromGoogle,5);
        emailFromGoogle.click();
        scroll.scrollDown("950");
        wait.waitElement(costInMinuteMail,3);
    }

    public String getTotalCostInMinutesMail() {
        return costInMinuteMail.getText().substring(28, 36);
    }
}
