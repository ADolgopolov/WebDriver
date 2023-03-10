package com.epam.training.student_andrii_dolhopolov.hardcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CloudGoogleSearchResultPage extends AbstractPage {
    protected CloudGoogleSearchResultPage(WebDriver driver) {
        super(driver);
    }
    private final By searchResultsLocator = By.xpath("//div[@class = 'gs-title']/a[@class = 'gs-title']");

    public CloudGooglePricingCalculatorPage clickLinkWithText(String linkText) {
        waitPresenceOfAllElementsLocatedBy(searchResultsLocator)
                .stream().filter(link -> link.getText().equalsIgnoreCase(linkText))
                .findFirst()
                .orElseThrow()
                .click();
        return new CloudGooglePricingCalculatorPage(driver);
    }
}
