package com.epam.training.student_andrii_dolhopolov.hurt_me_plenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudGoogleResultPage extends AbstractPage {
    protected CloudGoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage clickLinkWithText(String linkText) {
        scrollToElement(new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + linkText + "']"))))
                .click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}
