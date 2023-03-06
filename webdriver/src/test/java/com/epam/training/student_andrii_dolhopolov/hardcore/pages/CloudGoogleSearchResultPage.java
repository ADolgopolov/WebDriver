package com.epam.training.student_andrii_dolhopolov.hardcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudGoogleSearchResultPage extends AbstractPage {
    protected CloudGoogleSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public CloudGooglePricingCalculatorPage clickLinkWithText(String linkText) {
        scrollToElement(new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + linkText + "']"))))
                .click();
        return new CloudGooglePricingCalculatorPage(driver);
    }
}
