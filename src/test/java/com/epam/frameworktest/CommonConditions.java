package com.epam.frameworktest;

import com.epam.framework.driver.DriverSingleton;
import com.epam.framework.page.CalculatorPage;
import com.epam.framework.page.CloudPage;
import com.epam.framework.page.TenMinutesMailPage;
import com.epam.framework.user.User;
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
    CloudPage cloudPage;
    CalculatorPage calculatorPage;
    TenMinutesMailPage tenMinutesPage;

    @BeforeTest
    public void beforeTest() {
        driver = DriverSingleton.getDriver();
        cloudPage = new CloudPage(driver);
        calculatorPage = new CalculatorPage(driver);
        tenMinutesPage = new TenMinutesMailPage(driver);
        cloudPage.search();
        calculatorPage.fillingTheForm();
        calculatorPage.sentEmail();
        tenMinutesPage.openTenMinuteMail();
        tenMinutesPage.comeToGooglePage();
        tenMinutesPage.waitEmailFromGoogle();
    }

    @AfterTest
    public void afterTest() {
        DriverSingleton.closeDriver();
    }

}
