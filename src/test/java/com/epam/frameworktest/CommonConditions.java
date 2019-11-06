package com.epam.frameworktest;

import com.epam.framework.driver.DriverSingleton;
import com.epam.framework.page.CalculatorPage;
import com.epam.framework.page.CloudPage;
import com.epam.framework.page.TenMinutesMailPage;
import com.epam.framework.util.TestListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    CloudPage cloud;
    CalculatorPage calculator;
    TenMinutesMailPage tenMinutes;

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        driver = DriverSingleton.getDriver();
        cloud = new CloudPage(driver);
        calculator = new CalculatorPage(driver);
        tenMinutes = new TenMinutesMailPage(driver);
        cloud.search();
        calculator.fillingTheForm();
        calculator.sentEmail();
        tenMinutes.openTenMinuteMail();
        tenMinutes.comeToGooglePage();
        tenMinutes.waitEmailFromGoogle();
    }

    @AfterTest
    public void afterTest() {
        DriverSingleton.closeDriver();
    }

}
