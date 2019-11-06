package com.epam.frameworktest;

import com.epam.framework.page.TenMinutesMailPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TheSameCostTest extends CommonConditions {

    @Test
    public void theSameCostTest() {
        String costInMinuteMail = driver.findElement(By.xpath("//*[@id='mobilepadding']/td/h2"))
                .getText()
                .substring(28, 36);
        driver.switchTo().window(TenMinutesMailPage.tabs.get(0));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String costInGoogleCalculate = driver.findElement(By.xpath("(.//b[@class='ng-binding'])[2]"))
                .getText()
                .substring(26, 34);
        Assert.assertEquals(costInMinuteMail, costInGoogleCalculate);
    }
}
