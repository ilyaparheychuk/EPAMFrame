package com.epam.frameworktest;

import com.epam.framework.driver.DriverSingleton;
import com.epam.framework.page.CalculatorPage;
import com.epam.framework.page.CloudPage;
import com.epam.framework.page.TenMinutesMailPage;
import com.epam.framework.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    CloudPage cloudPage;
    CalculatorPage calculatorPage;
    TenMinutesMailPage tenMinutesPage;

    @BeforeMethod
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

    @AfterMethod
    public void afterTest() {
        DriverSingleton.closeDriver();
    }

}
