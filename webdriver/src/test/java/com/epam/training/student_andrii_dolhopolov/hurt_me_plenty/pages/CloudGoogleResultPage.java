package com.epam.training.student_andrii_dolhopolov.hurt_me_plenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CloudGoogleResultPage extends AbstractPage {
    protected CloudGoogleResultPage(WebDriver driver) {
        super(driver);
    }
    private final By searchResultsLocator = By.xpath("//div[@class = 'gs-title']/a[@class = 'gs-title']");

    public GoogleCloudPricingCalculatorPage clickLinkWithText(String linkText) {
        waitPresenceOfAllElementsLocatedBy(searchResultsLocator)
                .stream().filter(link -> link.getText().equalsIgnoreCase(linkText))
                .findFirst()
                .orElseThrow()
                .click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}
