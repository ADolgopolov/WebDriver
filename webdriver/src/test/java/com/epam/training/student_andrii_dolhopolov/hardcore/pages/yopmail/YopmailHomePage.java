package com.epam.training.student_andrii_dolhopolov.hardcore.pages.yopmail;

import com.epam.training.student_andrii_dolhopolov.hardcore.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopmailHomePage extends AbstractPage {
    private static final String PAGE_URL = "https://yopmail.com/";
    private final By generatorButton = By.xpath("//div[@id=\"listeliens\"]/a[@href=\"email-generator\"]");

    public YopmailHomePage(WebDriver driver) {
        super(driver);
    }

    public YopmailHomePage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public YopmailGeneratorPage generateEmailAddress() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(generatorButton))
                .click();
        return new YopmailGeneratorPage(driver);
    }
}
