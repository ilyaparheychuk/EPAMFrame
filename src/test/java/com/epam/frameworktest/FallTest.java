package com.epam.frameworktest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FallTest extends CommonConditions {

    @Test
    public void theSameCostTest() {
        String costInMinuteMail = tenMinutesPage.getTotalCostInMinutesMail() + "1";
        tenMinutesPage.switchPage(0);
        String costInGoogleCalculate = calculatorPage.getTotalCostInGoogleCalculator();
        Assert.assertEquals(costInMinuteMail, costInGoogleCalculate);
    }
}
