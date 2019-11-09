package com.epam.frameworktest;

import com.epam.framework.page.TenMinutesMailPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TheSameCostTest extends CommonConditions {

    @Test
    public void theSameCostTest() {
        String costInMinuteMail = tenMinutesPage.getTotalCostInMinutesMail();
        tenMinutesPage.switchPage(0);
        String costInGoogleCalculate = calculatorPage.getTotalCostInGoogleCalculator();
        Assert.assertEquals(costInMinuteMail, costInGoogleCalculate);
    }
}
