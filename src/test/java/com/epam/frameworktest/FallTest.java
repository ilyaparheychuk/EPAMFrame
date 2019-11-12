package com.epam.frameworktest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FallTest extends CommonConditions {

    @Test
    public void fallTest() {
        String costInMinuteMailWrong = tenMinutesPage.getTotalCostInMinutesMail() + "1";
        tenMinutesPage.switchPage(0);
        String costInGoogleCalculateWrong = calculatorPage.getTotalCostInGoogleCalculator();
        Assert.assertEquals(costInMinuteMailWrong, costInGoogleCalculateWrong);
    }
}
