package com.epam.training.student_andrii_dolhopolov.hurt_me_plenty.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudGoogleHomePage extends AbstractPage {
    public static final String PAGE_URL = "https://cloud.google.com/";
    @FindBy(name = "q")
    protected WebElement searchButton;

    public CloudGoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleHomePage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public CloudGoogleResultPage inputSearchTerm(String term) {
        this.searchButton.click();
        this.searchButton.sendKeys(term);
        this.searchButton.sendKeys(Keys.ENTER);
        return new CloudGoogleResultPage(driver);
    }
}
