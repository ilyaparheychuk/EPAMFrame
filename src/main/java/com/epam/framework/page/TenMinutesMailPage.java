package com.epam.framework.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class TenMinutesMailPage {

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

    private static String email;
    WebDriver driver;
    public static ArrayList<String> tabs;
    private JavascriptExecutor jse;

    public TenMinutesMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.jse = (JavascriptExecutor) driver;
    }

    public void openTenMinuteMail() {
        jse.executeScript("window.open('https://10minutemail.com')");
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.visibilityOf(fieldWithEmail))
                .isDisplayed();
        email = fieldWithEmail.getAttribute("value");
    }

    public void comeToGooglePage() {
        driver.switchTo().window(tabs.get(0));
        emailToSent.click();
        emailToSent.sendKeys(email);
        sendEmail.click();
    }

    public void waitEmailFromGoogle() throws InterruptedException {
        driver.switchTo().window(tabs.get(1));
        driver.navigate().refresh();
        Thread.sleep(30000);
        driver.navigate().refresh();
        (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.visibilityOf(fieldWithEmail))
                .isDisplayed();
        jse.executeScript("window.scrollBy(0,900)");
        (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.visibilityOf(emailFromGoogle))
                .isDisplayed();
        emailFromGoogle.click();
        jse.executeScript("window.scrollBy(0,900)");
        (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.visibilityOf(waitEmailFromGoogle))
                .isDisplayed();
    }
}
